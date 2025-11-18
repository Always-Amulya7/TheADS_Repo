#include<stdio.h>
float main(){
    float ang1,ang2,ang3;
    printf("Enter the angles: \n");
    scanf("%f",&ang1);
    scanf("%f",&ang2);
    scanf("%f",&ang2);
    float sum=(ang1+ang2+ang3);
    if (sum==180.0){
        printf("The Traingle is satisfied");
    }
    if (sum==90.0){
        printf("The right angled triangle is satisfied");
    }
}