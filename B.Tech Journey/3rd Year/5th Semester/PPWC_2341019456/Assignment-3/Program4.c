#include<stdio.h>
int main(){
    int num;
    char choice='n';
    do{
        printf("Enter the number: ");
        scanf("%d",&num);
        if (num == 0)
        printf("The number is zero\n");
        else if (num < 0)
        printf("The number is negative\n");
        else
        printf("The number is positive\n");
        printf("Wish to exit?: ");
        scanf(" %c",&choice);
    }
    while(choice!='y');
    return 0;
}
