#include<stdio.h>
#include<unistd.h>
#include<semaphore.h>
sem_t S;
sem_t T;
int main(){
	sem_init(&S,2,0);
	sem_init(&T,3,1);
	int count=0;
	while(1){
		sem_wait(&T);
		printf("0");
		printf("0");
		sem_post(&S);
		sem_wait(&S);
		printf("1");
		printf("1");
		sem_post(&T);
	}
	sem_destroy(&S);
	sem_destroy(&T);
	return 0;
}
