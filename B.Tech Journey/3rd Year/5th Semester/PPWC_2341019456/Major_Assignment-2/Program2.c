#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>
#include <sys/wait.h>
#include <fcntl.h>
#define MAX 1024
#define MAX_ARGS 100
#define MAX_CMDS 10
void parse(char *cmd, char **args)
{
    int i = 0;
    args[i] = strtok(cmd, " \n");
    while (args[i] != NULL)
    {
        i++;
        args[i] = strtok(NULL, " \n");
    }
}
int main()
{
    char cmd[MAX];
    char *args[MAX_ARGS];
    char *commands[MAX_CMDS];
    while (1)
    {
        printf("[myshell]$ ");
        fgets(cmd, MAX, stdin);
        if (strncmp(cmd, "exit", 4) == 0)
            break;
        int cmd_count = 0;
        commands[cmd_count] = strtok(cmd, "|");
        while (commands[cmd_count] != NULL)
        {
            cmd_count++;
            commands[cmd_count] = strtok(NULL, "|");
        }
        int fd_in = 0;
        int pipefd[2];
        for (int i = 0; i < cmd_count; i++)
        {
            pipe(pipefd);
            pid_t pid = fork();
            if (pid == 0)
            {
                dup2(fd_in, STDIN_FILENO);
                if (i < cmd_count - 1)
                    dup2(pipefd[1], STDOUT_FILENO);
                close(pipefd[0]);
                int fd_input = -1, fd_output = -1;

                char *input = strchr(commands[i], '<');
                char *output = strchr(commands[i], '>');
                if (input)
                {
                    *input = '\0';
                    input++;
                    fd_input = open(strtok(input, " \n"), O_RDONLY);
                    dup2(fd_input, STDIN_FILENO);
                    close(fd_input);
                }
                if (output)
                {
                    *output = '\0';
                    output++;
                    fd_output = open(strtok(output, " \n"),
                                     O_CREAT | O_WRONLY | O_TRUNC, 0644);
                    dup2(fd_output, STDOUT_FILENO);
                    close(fd_output);
                }
                parse(commands[i], args);
                execvp(args[0], args);
                perror("Execution failed");
                exit(1);
            }
            else
            {
                wait(NULL);
                close(pipefd[1]);
                fd_in = pipefd[0];
            }
        }
    }
    return 0;
}
