#include<stdio.h>
#include<stdlib.h>
#include<unistd.h>
#include<sys/types.h>
#include<sys/wait.h>

int main(){
	pid_t childpid;
	childpid=fork();
	if (childpid==-1){
		printf("Error\n");
		return -1;
	}
	else if(childpid==0){
		printf("I am child and my process id is %ld\n",(long)getpid());
		exit(0);
	}
	else{
		printf("I am parent and my ID= %ld\n",(long)getpid());
		sleep(20);
		wait(NULL);
		exit(0);
	}
	return 0;
}
