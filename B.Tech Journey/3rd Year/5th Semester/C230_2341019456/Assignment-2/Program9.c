#include<stdio.h>
int main(){
    int num1,num2;
    printf("Enter the numbers: ");
    scanf("%d",&num1);
    scanf("%d",&num2);
    if (num1==num2)
    printf("Both numbers are equal\n");
    if (num1>=num2)
    printf("Num1 is greater than equal to Num2\n");
    if (num1<=num2)
    printf("Num1 is less than equal to Num2\n");
    if (num1<num2)
    printf("Num1 is less than num2\n");
    if (num1>num2)
    printf("Num1 is greater than num2\n");
    return 0;
}