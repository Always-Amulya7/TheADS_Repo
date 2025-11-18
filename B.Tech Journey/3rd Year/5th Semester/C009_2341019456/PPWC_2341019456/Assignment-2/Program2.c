#include<stdio.h>
#include<math.h>
int square(int x){
	return pow(x,2);
}
int main(){
	int num;
	printf("Enter the number: ");
	scanf("%d",&num);
	int value=square(num);
	printf("The value is %d\n",value);
	return 0;
}
