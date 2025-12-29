#include<stdio.h>
#include<unistd.h>
#include<string.h>
int main(){
	int fd[2];
	pid_t pid;
	char write_msg[100]={"PPWC class at 2 pm"};
	char read_msg[100];
	// Create Pipe
	if(pipe(fd)==-1){
		perror("Pipe failed");
		return -1;
	}
	pid=fork();
	if(pid<0){
		perror("Fork failed");
		return -1;
	}
	if(pid==0){
		close(fd[1]); // Close write 
		read(fd[0],read_msg,sizeof(read_msg));
		printf("Child Received: %s\n",read_msg);
		close(fd[0]);
	}
	// Parent
	else{
		close(fd[0]);
		write(fd[1],write_msg,strlen(write_msg));
		close(fd[1]);
	}
	return 0;
}
