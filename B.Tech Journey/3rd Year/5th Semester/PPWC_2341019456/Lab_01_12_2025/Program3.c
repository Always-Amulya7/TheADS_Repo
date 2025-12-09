#include<stdio.h>
#include<stdlib.h>
#include<unistd.h>

void display(){
	printf("Function exit....\n");
}
int main(){
	int i;
	if(atexit(display)){
		fprintf(stderr,"Failed");
		return -1;
	}
	for (i=0;i<5;i++){
		sleep(5);
		printf("%d\n",i);
	}
	return 0;
}		
