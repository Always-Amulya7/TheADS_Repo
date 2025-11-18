#include<stdio.h>
int main(){
    int num1,num2,num3;
    printf("Enter 3 numbers: ");
    scanf("%d",&num1);
    scanf("%d",&num2);
    scanf("%d",&num3);
    int max;
    if (num1>num2&&num1>num3)
    max=num1;
    if (num2>num1&&num2>num3)
    max=num2;
    if (num3>num1&&num3>num2)
    max=num3;
    printf("The max element is %d",max);
    return 0;
}