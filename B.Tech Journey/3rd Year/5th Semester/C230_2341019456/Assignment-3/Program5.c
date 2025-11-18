#include<stdio.h>
int fib(int x){
    if (x==0)
    return 0;
    if (x==1)
    return 1;
    return fib(x-1)+fib(x-2);
}
int main(){
    int num;
    printf("Enter the number: ");
    scanf("%d",&num);
    printf("The Fib Series is: ");
    for (int i=0;i<=num;i++){
        printf("%d ",fib(i));
    }
    return 0;
}