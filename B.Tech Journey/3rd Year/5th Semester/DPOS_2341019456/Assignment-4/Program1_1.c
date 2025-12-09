#include <stdio.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/wait.h>
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
        printf("Child running infinite loop... kill me to continue.\n");
        while (1);
    }
    else {
        printf("Parent process started:\n");
        printf("   PID = %d\n", getpid());
        printf("Parent waiting for child process (PID = %d) to finish...\n", pid);
        wait(NULL);

        printf("Parent: Child has terminated. Parent exiting now.\n");
    }
    return 0;
}

// gcc Program1_1.c
// ./a.out &

// ps -elf | grep fork_wait

// kill <child_pid>

// ps -elf | grep fork_wait
