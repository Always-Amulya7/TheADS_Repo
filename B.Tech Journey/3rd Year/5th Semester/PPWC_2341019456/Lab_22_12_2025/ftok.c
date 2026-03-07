#include<stdio.h>
#include<unistd.h>
#include<stdlib.h>
#include<sys/types.h>
#include<sys/wait.h>
#include<sys/ipc.h>
#include<sys/shm.h>
int main(){
	pid_t pid;
	int  shmid, *shvar;
	key_t key=ftok(".",45);
	shmid=shmget(key,20,0664 | IPC_CREAT);
	printf("Key=%x...shmid=%d\n",key,shmid);
	shvar=shmat(shmid,NULL,0);
	printf("Default initial value of shvar= %d\n",*shvar);
	*shvar=10;
	pid=fork();
	if(pid==0){
		*shvar=*shvar+90;
		printf("Child update the value= %d\n",*shvar);
		exit(0);
	}
	else{
		wait(NULL);
		*shvar=*shvar+110;
		printf("Update the parent value= %d\n",*shvar);
	}
	return 0;
}
