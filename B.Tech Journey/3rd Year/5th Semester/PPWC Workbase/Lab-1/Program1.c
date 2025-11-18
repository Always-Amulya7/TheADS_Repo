#include <stdio.h>
#define PI 3.4141593
int main(){
    float area,circumference;
    printf("Enter radius: ");
    float radius;
    scanf("%f",&radius);
    area=PI*radius*radius;
    circumference=2*PI*radius;
    printf("The area is: %f\n",area);
    printf("The circumference is: %f\n",circumference);
    return 0;
}