#include <stdio.h>
int main(){
    float sub1,sub2,sub3;
    printf("Enter marks in subject1: ");
    scanf("%f",&sub1);
    printf("Enter marks in subject2: ");
    scanf("%f",&sub2);
    printf("Enter marks in subject3: ");
    scanf("%f",&sub3);
    float average=(sub1+sub2+sub3)/3;
    printf("The average percentage is: %f\n",average);
    return 0;
}