#include<stdio.h>
int main(){
	int x=10,y=20,z=30;
	int *ptr=&x;
	printf("The value of X: %d\n",*ptr);
	printf("The value of Y: %d\n",*(ptr+1));
	printf("The value of Z: %d\n",*(ptr+2));
	return 0;
}
