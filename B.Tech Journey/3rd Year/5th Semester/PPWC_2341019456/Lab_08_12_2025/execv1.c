// A sample that creates 2nd Argument of execv
#include<stdio.h>
#include<stdlib.h>
#include<unistd.h>
int main(int argc,char *argv[]){
	int i;
	char *cmdarg[20];
	for(i=1;argv[i]!=NULL;i++){
		cmdarg[i-1]=argv[i];
	}
	cmdarg[i-1]=NULL;
	execv("/bin/ls",cmdarg);
	return 0;
}
