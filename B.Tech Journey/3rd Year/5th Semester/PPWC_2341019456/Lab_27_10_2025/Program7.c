#include<stdio.h>
int main(){
	int arr[3]={12,52,8};
	int *ptr1=&arr[0],*ptr2=&arr[1],*ptr3=&arr[2];
	*ptr1=*ptr1+10;
	*ptr2=*ptr2+10;
	*ptr3=*ptr3+10;
	printf("The value of a: %d\n",*ptr1);
	printf("The value of b: %d\n",*ptr2);
	printf("The value of c: %d\n",*ptr3);
	return 0;
}
