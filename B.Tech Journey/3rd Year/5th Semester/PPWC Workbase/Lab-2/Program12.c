#include <stdio.h>
int main(){
    float ang1,ang2,ang3;
    printf("Enter the three angles: \n");
    scanf("%f%f%f",&ang1,&ang2,&ang3);
    float sum;
    sum=(ang1+ang2+ang3);
    printf("The Traingle is satisfied");
    if (sum==90.0)
    printf("The right angled triangle is satisfied");
    return 0;
}