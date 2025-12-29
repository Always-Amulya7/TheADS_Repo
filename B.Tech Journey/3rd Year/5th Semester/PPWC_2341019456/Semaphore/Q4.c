#include<stdio.h>
#include<unistd.h>
#include<semaphore.h>
#include<sys/wait.h>
sem_t S1;
sem_t S2;
sem_t S3;
sem_t S4;
int main(){
	sem_init(&S1,2,0);
	sem_init(&S2,3,1);
	sem_init(&S3,4,0);
	sem_init(&S4,5,0);
	pid_t P1,P2,P3,P4;
	P2=fork();
	if(P2==0){
		sem_wait(&S2);
		fprintf(stderr,"PPWC CLASS ");
		sem_post(&S4);
	}
	P4=fork();
	if(P4==0){
		sem_wait(&S4);
		fprintf(stderr,"IS ");
		sem_post(&S3);
	}
	P3=fork();
	if(P3==0){
		sem_wait(&S3);
		fprintf(stderr,"VERY ");
		sem_post(&S1);
	}
	P1=fork();
	if(P1==0){
		sem_wait(&S1);
		fprintf(stderr,"BORING");
	}
	wait(NULL);
	wait(NULL);
	wait(NULL);
	wait(NULL);
	sem_destroy(&S1);
	sem_destroy(&S2);
	sem_destroy(&S3);
	sem_destroy(&S4);
	return 0;
}
