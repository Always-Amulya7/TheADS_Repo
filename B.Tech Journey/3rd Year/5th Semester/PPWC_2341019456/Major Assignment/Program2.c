#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>
#include <sys/wait.h>
#include <fcntl.h>

#define MAX 1024
#define MAX_ARGS 100

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
    while (1)
    {
        printf("[myshell]$ ");
        fgets(cmd, MAX, stdin);
        if (strncmp(cmd, "exit", 4) == 0)
            break;
        int fd_in = -1, fd_out = -1;
        char *input = strchr(cmd, '<');
        char *output = strchr(cmd, '>');
        if (input)
        {
            *input = '\0';
            input++;
            fd_in = open(strtok(input, " \n"), O_RDONLY);
        }
        if (output)
        {
            *output = '\0';
            output++;
            fd_out = open(strtok(output, " \n"),
            O_CREAT | O_WRONLY | O_TRUNC, 0644);
        }
        parse(cmd, args);
        pid_t pid = fork();
        if (pid == 0)
        {
            if (fd_in != -1)
            {
                dup2(fd_in, STDIN_FILENO);
                close(fd_in);
            }
            if (fd_out != -1)
            {
                dup2(fd_out, STDOUT_FILENO);
                close(fd_out);
            }
            execvp(args[0], args);
            perror("Execution failed");
            exit(1);
        }
        else
        {
            wait(NULL);
        }
    }
    return 0;
}
