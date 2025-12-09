// A program that creates a child process to run ls -l
#include<stdio.h>
#include<unistd.h>
#include<sys/wait.h>
#include<sys/types.h>
#include<stdlib.h>
int main(void){
	pid_t childpid;
	childpid=fork();
	if(childpid==-1){
		perror("Failed to fork");
		return 1;
	}
	if(childpid==0){
		/* Child Code */
		execl("/bin/ls","ls","-l",NULL);
		perror("Child failed to exec ls");
		return 1;
	}
	if (childpid!=wait(NULL)){
		// Parent Code
		perror("Parent failed to wait due to signal or error");
		return 1;
	}
	return 0;
}
