#include<stdio.h>
int main(){
	int x=10;
	int *p1=&x,*p2=&x,*p3=&x;
	*p3=*p3+100;
	printf("The value of x: %d\n",*p1);
	printf("The value of x: %d\n",*p2);
	printf("The value of x: %d\n",*p3);
	return 0;
}
