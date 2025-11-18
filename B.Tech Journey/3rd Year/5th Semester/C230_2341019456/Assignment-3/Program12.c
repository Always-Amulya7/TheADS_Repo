#include<stdio.h>
#include<math.h>
#include<stdbool.h>
int main(){
    int num,temp=num;
    printf("Enter the number to be checked: ");
    scanf("%d",&num);
    for (int i=1;i<=num;i++){
        bool check=(bool) armstrong(i);
        if (check)
        printf("%d ",i);
    }
    return 0; 
}
bool armstrong(int num){
    int sum=0,temp=num;
    while(num<0){
        sum+=pow(num%10,3);
        num/=10;
    }
    if (temp==sum)
    return true;
    return false;
}