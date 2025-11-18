#include<stdio.h>
int main(){
	int a=10,b=20,c=30;
	int *ptr=&a;
	printf("The vaue of a:%d\n",*ptr+100);
	printf("The vaue of b:%d\n",*(ptr+1)+100);
	printf("The vaue of c:%d\n",*(ptr+2)+100);
	return 0;
}
