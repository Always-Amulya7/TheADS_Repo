#include <stdio.h>
#include <unistd.h>
#include <sys/types.h>
int main() {
    pid_t pid = fork();
    if (pid < 0) {
        perror("fork failed");
        return 1;
    }
    if (pid == 0) {
        printf("Child process started:\n");
        printf("   PID  = %d\n", getpid());
        printf("   PPID = %d\n", getppid());
        printf("Child is now running an infinite loop...\n");
        while (1);
    }
    else {
        printf("Parent process started:\n");
        printf("   PID = %d\n", getpid());
        printf("   Child PID = %d\n", pid);
        printf("Parent is now running an infinite loop...\n");
        while (1);
    }
    return 0;
}

// Run gcc Program1.c
// ./a.out &

// ps -elf | grep Program1.c

// kill <child_pid>

// ps -elf | grep fork_loop

// kill <parent_pid>

// ps -elf | grep fork_loop
