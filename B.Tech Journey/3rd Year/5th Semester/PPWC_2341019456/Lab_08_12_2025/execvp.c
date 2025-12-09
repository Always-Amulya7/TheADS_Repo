// A program that creates a child process to run ls -l
#include<stdio.h>
#include<stdlib.h>
#include<unistd.h>
#include<sys/wait.h>
int main(void){
	char *cmdargs[]={"ls","-l",NULL};
	pid_t pid;
	pid=fork();
	if(pid==0){
		execvp("ls",cmdargs);
	}
	else{
		wait(NULL);
		printf("Child terminate\n");
	}
	return 0;
}
