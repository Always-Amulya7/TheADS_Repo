#include<stdio.h>
int main(){
    int num;
    printf("Enter the number: ");
    scanf("%d",&num);
    int rev=0;
    int temp=num;
    while (num>0){
        rev=rev*10+num%10;
        num/=10;
    }
    if (rev==temp)
    printf("It is a Palindrome Number\n");
    else
    printf("It is not a Palindrome Number\n");
    return 0;
}