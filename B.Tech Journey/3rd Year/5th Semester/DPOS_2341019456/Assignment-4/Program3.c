#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/wait.h>
int main(){
    pid_t pid1,pid2,pid3;
    pid1=fork();
    if (pid1<0){
        perror("fork");
        exit(1);
    }
    if (pid1 == 0) {
        printf("\n[Child 1] PID: %d, Parent PID: %d\n", getpid(), getppid());
        printf("[Child 1] Copying file1 to file2...\n");
        execl("/bin/cp", "cp", "file1", "file2", (char *)NULL);
        perror("execl");
        exit(1);
    }
    sleep(1);
    pid2 = fork();
    if (pid2 < 0) {
        perror("fork");
        exit(1);
    }
    if (pid2 == 0) {
        printf("\n[Child 2] PID: %d, Parent PID: %d\n", getpid(), getppid());
        printf("[Child 2] Displaying content of file2:\n\n");

        execl("/bin/cat", "cat", "file2", (char *)NULL);
        perror("execl");
        exit(1);
    }
    sleep(1);
    pid3 = fork();
    if (pid3 < 0) {
        perror("fork");
        exit(1);
    }
    if (pid3 == 0) {
        printf("\n[Child 3] PID: %d, Parent PID: %d\n", getpid(), getppid());
        printf("[Child 3] Displaying sorted reverse content of file2:\n\n");

        execl("/bin/sh", "sh", "-c", "sort file2 | tac", (char *)NULL);
        perror("execl");
        exit(1);
    }
    wait(NULL);
    wait(NULL);
    wait(NULL);
    printf("\n[Parent] All child processes completed.\n");
    printf("[Parent] PID: %d\n\n", getpid());

    return 0;
}

// execl("/bin/cp", "cp", "file1", "file2", NULL);

// execl("/bin/cat", "cat", "file2", NULL);

// execl("/bin/sh", "sh", "-c", "sort file2 | tac", NULL);

// wait(NULL);
