// execvp to take arguments from command line
// A process that creates a child process to run ls -l
#include<stdio.h>
#include<stdlib.h>
#include<unistd.h>
#include<sys/wait.h>
int main(int argsc, char *argv[]){
	pid_t pid;
	pid=fork();
	if(pid==0){
		execvp("ls",&argv[1]);
	}
	else{
		wait(NULL);
		printf("Child Terminate\n");
	}
	return 0;
}
