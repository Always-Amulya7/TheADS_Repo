#include<stdio.h>
void greatest(int x,int y,int z){
	if (x>y && x>z)
	printf("%d is greatest amongst them\n",x);
	else if (y>z)
	printf("%d is the greatest amongst them\n",y);
	else
	printf("%d is the greatest amongst them\n",z);
}
int main(){
	int num1,num2,num3;
	printf("Enter three numbers: ");
	scanf("%d %d %d",&num1,&num2,&num3);
	greatest(num1,num2,num3);
	return 0;
}
