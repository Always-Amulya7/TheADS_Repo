#include <stdio.h>
int main(){
    float rate,principle;
    int time;
    printf("Enter the principle: ");
    scanf("%f",&principle);
    printf("Enter rate: ");
    scanf("%f",&rate);
    printf("Enter time: ");
    scanf("%d",&time);
    float SI=(principle*rate*time)/100;
    printf("The Simple Interest is: %f\n",SI);
    return 0;
}