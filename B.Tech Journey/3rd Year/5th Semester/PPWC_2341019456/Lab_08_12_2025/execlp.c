// A program that creates a child process to run echo
#include<stdio.h>
#include<stdlib.h>
#include<unistd.h>
#include<sys/wait.h>
int main(void){
	char *temp1,*temp2;
	temp1="Funny";
	temp2="World";
	pid_t pid;
	pid=fork();
	if (pid==0){
		execlp("echo","echo",temp1,temp2,NULL);
		printf("Error");
		return 1;
	}
	else{
		wait(NULL);
		fprintf(stdout,"Parent (%ld) terminated.\n",(long)getpid());
	}
	return 0;
}
