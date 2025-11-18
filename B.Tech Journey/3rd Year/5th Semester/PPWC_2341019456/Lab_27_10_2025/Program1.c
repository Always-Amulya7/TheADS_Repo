#include<stdio.h>
int main(){
	int x=10;
	int *p;
	int **p1;
	p=&x;
	p1=&p;
	printf("Value of x %d\n",x);
	printf("Address of x %p\n",&x);
	printf("Value of p (address of x)=%d\n",*p);
	printf("Value of p1 %d\n",**p1);
	printf("Accessing x using p %d\n",*p);
	printf("Accessing x using pointer %d\n",**p1);
	return 0;
}
