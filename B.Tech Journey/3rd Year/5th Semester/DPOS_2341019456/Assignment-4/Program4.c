#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/shm.h>
#include <sys/wait.h>
#include <stdbool.h>
bool isPrime(int n) {
    if (n < 2) return false;
    for (int i = 2; i * i <= n; i++)
        if (n % i == 0) return false;
    return true;
}
int main() {
    int n;
    printf("Enter length of Fibonacci series: ");
    scanf("%d", &n);
    if (n <= 0) {
        printf("Invalid length.\n");
        return 1;
    }
    int shmid = shmget(IPC_PRIVATE, n * sizeof(int), IPC_CREAT | 0666);
    if (shmid < 0) {
        perror("shmget");
        exit(1);
    }
    int *fib = (int *)shmat(shmid, NULL, 0);
    pid_t pid = fork();
    if (pid < 0) {
        perror("fork");
        exit(1);
    }
    if (pid == 0) {
        printf("\n[Child] Generating Fibonacci series...\n");
        if (n >= 1) fib[0] = 0;
        if (n >= 2) fib[1] = 1;
        for (int i = 2; i < n; i++)
            fib[i] = fib[i-1] + fib[i-2];
        printf("[Child] Fibonacci series generated. Child exiting...\n\n");
        exit(0);
    }
    wait(NULL);
    printf("\n[Parent] Child completed.\n");
    printf("[Parent] Fibonacci Series:\n");
    for (int i = 0; i < n; i++)
        printf("%d ", fib[i]);
    printf("\n");
    printf("\n[Parent] Prime Fibonacci Numbers:\n");
    int found = 0;
    for (int i = 0; i < n; i++) {
        if (isPrime(fib[i])) {
            printf("Value %d at position %d is prime.\n", fib[i], i);
            found = 1;
        }
    }
    if (!found)
        printf("No prime Fibonacci numbers found.\n");
    shmdt(fib);
    shmctl(shmid, IPC_RMID, NULL);
    return 0;
}

// shmget()
// shmat()
