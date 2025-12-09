#include<stdio.h>
#include<stdlib.h>
#include<unistd.h>
#include<sys/types.h>
#include<sys/wait.h>

int main(){
	pid_t childpid;
	childpid=fork();
	if(childpid==-1){
		printf("Error\n");
		return -1;
	}
	else if(childpid==0){
		printf("Child PID= %ld PPID= %ld\n",(long)getpid(),(long)getppid());
		sleep(30);
		printf("Child PID= %ld PPID= %ld\n",(long)getpid(),(long)getppid());
	}
	else{
		printf("Parent PID %ld and PPID %ld\n",(long)getpid(),(long)getppid());
		exit(0);
	}
	return 0;
}
