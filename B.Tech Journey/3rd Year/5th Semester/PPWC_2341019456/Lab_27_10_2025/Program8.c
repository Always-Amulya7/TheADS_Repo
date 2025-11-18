#include<stdio.h>
int main(){
	int a=52,b=10;
	int *ptr1=&a,*ptr2=&b;
	if (*ptr1>*ptr2)
	printf("A is greater\n");
	else
	printf("B is greater\n");
	return 0;
}
