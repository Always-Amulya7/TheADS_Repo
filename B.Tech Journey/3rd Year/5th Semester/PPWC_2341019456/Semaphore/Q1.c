#include<stdio.h>
#include<unistd.h>
#include<semaphore.h>
int main(){
	sem_t sem;
	int rs,val;
	rs=sem_init(&sem,2,10);
	if (rs==0){
		printf("Semaphore create successfully.\n");
	}
	else{
		perror("Failed to create semaphore.\n");
		return -1;
	}
	sem_getvalue(&sem,&val);
	printf("Semaphore value is %d\n",val);
	return 0;
}
