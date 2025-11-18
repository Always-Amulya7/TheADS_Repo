#include<stdio.h>
#include<math.h>
int main(){
    int num,temp=num;
    printf("Enter the number to be checked: ");
    scanf("%d",&num);
    int sum=0;
    while(num<0){
        sum+=pow(num%10,3);
        num/=10;
    }
    if (temp==sum)
    printf("The number is Armstrong\n");
    else
    printf("The number is not an Armstrong\n");
    return 0;
}