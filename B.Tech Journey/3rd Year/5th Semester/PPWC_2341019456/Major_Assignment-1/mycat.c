#include <stdio.h>
#include <unistd.h>
#include <fcntl.h>
#include <string.h>
#include <stdlib.h>

#define BUFFER_SIZE 1024

void print_file(int fd, int number_lines)
{
    char buffer[BUFFER_SIZE];
    int bytes_read;
    int line = 1;
    int at_line_start = 1;

    while ((bytes_read = read(fd, buffer, BUFFER_SIZE)) > 0)
    {
        for (int i = 0; i < bytes_read; i++)
        {
            if (number_lines && at_line_start)
            {
                char num[20];
                int len = sprintf(num, "%d\t", line++);
                write(1, num, len);
                at_line_start = 0;
            }

            write(1, &buffer[i], 1);

            if (buffer[i] == '\n')
                at_line_start = 1;
        }
    }
}

int main(int argc, char *argv[])
{
    int fd;

    if (argc == 1)
    {
        print_file(0, 0);
        return 0;
    }

    if (strcmp(argv[1], "-n") == 0)
    {
        if (argc == 2)
        {
            print_file(0, 1);
            return 0;
        }

        for (int i = 2; i < argc; i++)
        {
            fd = open(argv[i], O_RDONLY);
            if (fd < 0)
            {
                perror("open");
                continue;
            }
            print_file(fd, 1);
            close(fd);
        }
        return 0;
    }

    for (int i = 1; i < argc; i++)
    {
        fd = open(argv[i], O_RDONLY);
        if (fd < 0)
        {
            perror("open");
            continue;
        }
        print_file(fd, 0);
        close(fd);
    }

    return 0;
}

