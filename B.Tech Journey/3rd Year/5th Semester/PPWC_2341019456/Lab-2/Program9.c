#include <stdio.h>
int main(){
    int num1,num2;
    printf("Enter the numbers: ");
    scanf("%d%d",&num1,&num2);
    if (num1==num2)
    printf("Both numbers are equal\n");
    else{
        if (num1>num2)
        printf("Num1 is greater than equal to Num2\n");
        else
        printf("Num2 is less than equal to Num1\n");
        if (num1!=num2){
            if (num1>num2)
            printf("Num1 is greater than num2\n");
            else
            printf("Num1 is less than num2\n");
        }
    }
    return 0;
}