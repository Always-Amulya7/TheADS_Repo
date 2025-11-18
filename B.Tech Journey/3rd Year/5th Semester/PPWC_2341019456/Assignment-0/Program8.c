#include<stdio.h>
#include<math.h>
int main(){
	int num;
	printf("Enter the number: ");
	scanf("%d",&num);
	printf("The second pow is: %f\n",pow(num,2));
	printf("The third pow is: %f\n",pow(num,3));
	printf("The fourth pow is: %f\n",pow(num,4));
	float sum=pow(num,2)+pow(num,3)+pow(num,4);
	printf("The sum of powers are: %f\n",sum);
	return 0;
}
