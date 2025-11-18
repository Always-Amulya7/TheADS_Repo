#include<stdio.h>
void check(int num){
	if (num>0)
	printf("The number is +ve\n");
	else if (num<0)
	printf("The number is -ve\n");
	else
	printf("The number is 0\n");
}
int main(){
	int num; 
	printf("Enter the number: ");
	scanf("%d",&num);
	check(num);
	return 0;
}
