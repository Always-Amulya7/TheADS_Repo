#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <string.h>
#include <sys/types.h>
int main(int argc,char *argv[]){
    pid_t childpid=0;
    int i,n;
    if (argc!=2){
        fprintf(stderr,"Usage: %s process\n",argv[0]);
        return -1;
    }
    n = atoi(argv[1]);
    for (i=1;i<n;i++){
        childpid=fork();
        if (childpid!=0)
            break;
    }
    fprintf(stderr,"i = %d, process id = %ld, parent id = %ld, child process id = %ld\n", i, (long)getpid(), (long)getppid(), (long)childpid);
    return 0;
}
