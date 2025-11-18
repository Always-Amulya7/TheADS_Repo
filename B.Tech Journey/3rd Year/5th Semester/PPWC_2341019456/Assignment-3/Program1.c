#include<stdio.h>
int main(){
    int num;
    printf("Enter the number: ");
    scanf("%d",&num);
    printf("Odd Numbers upto %d: \n",num);
    int count=1;
    while(count<=num){
        if (count%2!=0)
        printf("%d ",count);
        count++;
    }
    return 0;
}