#include<stdio.h>
float main(){
	int choice;
	float value;
	printf("Enter your choice: ");
	scanf("%d",&choice);
	switch(choice){
		case 1: float fah;
			printf("Enter the fah: ");
			scanf("%f",&fah);
			value=5*(fah-32)/9;
			printf("The converted cel value is: %f\n",value);
			break;
		case 2: float cel;
			printf("Enter the celcius: ");
			scanf("%f",&cel);
			value=9*(cel+32)/5;
			printf("The converted F value is: %f\n",value);
			break;
		default:printf("Has some error.");
	}
	return value;
}
