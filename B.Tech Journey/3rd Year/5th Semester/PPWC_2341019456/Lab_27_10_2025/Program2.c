#include<stdio.h>
int main(){
	int a=10,b=20,c=30;
	int *arr[3];
	arr[0]=&a;
	arr[1]=&b;
	arr[2]=&c;
	int **ptr=arr;
	printf("Value of a=%d\n",**ptr);
	printf("Value of b=%d\n",*(*(ptr+1)));
	printf("Value of c=%d\n",*(*(ptr+2)));
	return 0;
}
