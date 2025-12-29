#include<stdio.h>
#include<unistd.h>
#include<semaphore.h>
int main(){
	sem_t sem;
	int rs,val;
	rs=sem_init(&sem,2,10);
	// Wait Operation
	sem_wait(&sem);
	sem_getvalue(&sem,&val);
	printf("Semaphore value is %d\n",val);
	sem_wait(&sem);
	sem_getvalue(&sem,&val);
	printf("Semaphore value is %d\n",val);
	// Post Operation
	sem_post(&sem);
	sem_getvalue(&sem,&val);
	printf("Semaphore value is %d\n",val);
	sem_post(&sem);
	sem_getvalue(&sem,&val);
	printf("Semaphore value is %d\n",val);
	sem_wait(&sem);
	sem_getvalue(&sem,&val);
	printf("Semaphore value is %d\n",val);
	return 0;
}
