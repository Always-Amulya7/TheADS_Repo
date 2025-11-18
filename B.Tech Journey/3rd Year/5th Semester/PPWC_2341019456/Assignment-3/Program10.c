#include<stdio.h>
int main(){
    int num;
    printf("Enter the number: ");
    scanf("%d",&num);
    int sum=0;
    for (int i=1;i<=num;i++){
        sum+=i;
    }
    printf("The sum in the range is %d",sum);
    return 0;
}