#include<stdio.h>
void evenOdd(int num){
	if (num%2==0)
	printf("The number %d is even\n",num);
	else
	printf("The number %d is odd\n",num);
}
int main(){
	int num;
	printf("Enter the number: ");
	scanf("%d",&num);
	evenOdd(num);
}
