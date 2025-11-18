#include <stdio.h>
int main(){
    int choice;
    float value;
    printf("Enter your choice: ");
    scanf("%d",&choice);
    switch(choice){
        case 1: float fah;
                printf("Enter the fah: ");
                scanf("%f",&fah);
                value=5.0*(fah-32.0)/9.0;
                printf("The converted cel value is: %f\n",value);
                break;
        case 2: float cel;
                printf("Enter the cel: ");
                scanf("%f",&cel);
                value=(9.0/5.0)*cel+32.0;
                printf("The converted fah value is: %f\n",value);
                break;
        default: printf("Has some error.");
    }
    return 0;
}