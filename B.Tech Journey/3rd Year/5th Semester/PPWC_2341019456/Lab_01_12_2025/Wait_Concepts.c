#include<stdio.h>
#include<stdlib.h>
#include<unistd.h>
#include<sys/wait.h>

int main(){
	pid_t childpid;
	int status=0;
	childpid=fork();
	if (childpid==-1)
		exit(-1);
	if (childpid==0){
		printf("\nChild executing first it's pid= (%d)\n",getpid());
		sleep(30);
		printf("Child pid= %d\n",getpid());
		exit(1);
	}
	else{
		printf("\nParent executing before wait()\n");
		//Childpid=wait(NULL); //Use this when child process status information is not needed.
		childpid=wait(&status); //Get the child process status code from status available.
		printf("\n Wait() in parent done\nParent PID= %d\n",getpid());
		printf("\n Childpid returned is (%d)\n",childpid);
		printf("\n Status id (%d)\n",status);
	}
	return 0;
}
