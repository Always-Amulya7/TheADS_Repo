#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <fcntl.h>
#include <string.h>
#define BUFFER_SIZE 1024

void print_file(int fd, int line_number_flag)
{
    char buffer[BUFFER_SIZE];
    int bytes_read;
    int line = 1;
    int i;
    if (!line_number_flag)
    {
        while ((bytes_read = read(fd, buffer, BUFFER_SIZE)) > 0)
        {
            write(1, buffer, bytes_read);
        }
    }
    else
    {
        while ((bytes_read = read(fd, buffer, BUFFER_SIZE)) > 0)
        {
            for (i = 0; i < bytes_read; i++)
            {
                if (i == 0 || buffer[i - 1] == '\n')
                {
                    char num[20];
                    int len = sprintf(num, "%d\t", line++);
                    write(1, num, len);
                }
                write(1, &buffer[i], 1);
            }
        }
    }
}

int main(int argc, char *argv[])
{
    int fd, i;
    int line_number_flag = 0;
    if (argc == 1)
    {
        /* cat */
        print_file(0, 0);
        return 0;
    }
    if (strcmp(argv[1], "-n") == 0)
    {
        line_number_flag = 1;
        for (i = 2; i < argc; i++)
        {
            fd = open(argv[i], O_RDONLY);
            if (fd < 0)
            {
                perror("Error opening file");
                continue;
            }
            print_file(fd, line_number_flag);
            close(fd);
        }
        return 0;
    }
    if (strcmp(argv[1], ">") == 0)
    {
        fd = open(argv[2], O_WRONLY | O_CREAT | O_TRUNC, 0644);
        dup2(fd, 1);
        close(fd);
        print_file(0, 0);
        return 0;
    }
    if (strcmp(argv[1], ">>") == 0)
    {
        fd = open(argv[2], O_WRONLY | O_CREAT | O_APPEND, 0644);
        dup2(fd, 1);
        close(fd);
        print_file(0, 0);
        return 0;
    }
    if (strcmp(argv[1], "<") == 0)
    {
        fd = open(argv[2], O_RDONLY);
        dup2(fd, 0);
        close(fd);
        print_file(0, 0);
        return 0;
    }
    for (i = 1; i < argc; i++)
    {
        fd = open(argv[i], O_RDONLY);
        if (fd < 0)
        {
            perror("Error opening file");
            continue;
        }
        print_file(fd, 0);
        close(fd);
    }
    return 0;
}
