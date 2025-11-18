#include<stdio.h>
void main(){
	float rate,principle;
	int time;
	printf("Enter the principle: ");
	scanf("%f",&principle);
	printf("Enter the rate: ");
	scanf("%f",&rate);
	printf("Enter the time: ");
	scanf("%d",&time);
	float SI=(principle*rate*time)/100;
	printf("The Simple Interest is: %f\n",SI);
}
