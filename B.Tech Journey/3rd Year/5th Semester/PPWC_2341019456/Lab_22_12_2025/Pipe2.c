#include<stdio.h>
#include<stdlib.h>
#include<unistd.h>
#include<fcntl.h>
#include<sys/wait.h>
int main(){
	int fd[2];
	pid_t pid1,pid2;
	// Create pipe
	if (pipe(fd)==-1){
		perror("Pipe Failed");
		return -1;
	}
	// Child l: ls -l
	pid1=fork();
	if(pid1==0){
		// stdout -> pipe write
		dup2(fd[1],STDOUT_FILENO);
		close(fd[0]);
		close(fd[1]);
		execlp("ls","ls","-l",NULL);
		perror("execlp ls");
		exit(1);
	}
	// Child2: sort -n
	pid2=fork();
	if(pid2==0){
		// stdin <- pipe read
		dup2(fd[0],STDIN_FILENO);
		close(fd[1]);
		close(fd[0]);
		execlp("sort","sort","-n",NULL);
		perror("execlp sort");
		exit(1);
	}
	// Parent close the pipe
	close(fd[0]);
	close(fd[1]);
	// Wait for both child
	wait(NULL);
	wait(NULL);
	return 0;
}
