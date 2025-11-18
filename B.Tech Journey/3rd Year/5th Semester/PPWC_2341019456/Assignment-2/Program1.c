#include<stdio.h>
int main(){
    int num;
    printf("Enter a number: ");
    scanf("%d",&num);
    if (num==0)
    printf("The number entered is 0");
    if (num<0)
    printf("The number is less than 0");
    if (num>0)
    printf("The number is greater than 0");
    return 0;
}