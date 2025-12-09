#include<stdio.h>
#include<stdlib.h>
#include<unistd.h>
#include<sys/types.h>
#include<sys/wait.h>

int main(){
	pid_t childpid;
	childpid=fork();
	if (childpid){
		sleep(50);
	}
	else{
		printf("I am child and my id is %ld and my parent id is %ld\n",(long)getpid(),(long)getppid());
	}
	exit(0);
}
