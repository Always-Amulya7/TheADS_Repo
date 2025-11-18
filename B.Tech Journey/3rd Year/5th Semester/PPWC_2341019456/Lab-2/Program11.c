#include <stdio.h>
int main(){
    int amount;
    printf("Enter amount: ");
    scanf("%d",&amount);
    int value;
    if (amount>=500)
    {
        value=amount/500;
        printf("The number of 500 notes alloted is: %d\n",value);
        amount=amount-(value*500);
    }
    if (amount>=200)
    {
        value=amount/200;
        printf("The number of 200 notes alloted is: %d\n",value);
        amount=amount-(value*200);
    }
    if (amount>=100)
    {
        value=amount/100;
        printf("The number of 100 notes alloted is: %d\n",value);
        amount=amount-(value*100);
    }
    if (amount>=50)
    {
        value=amount/50;
        printf("The number of 50 notes alloted is: %d\n",value);
        amount=amount-(value*50);
    }
    if (amount>=20)
    {
        value=amount/20;
        printf("The number of 20 notes alloted is: %d\n",value);
        amount=amount-(value*20);
    }
    if (amount>=10)
    {
        value=amount/10;
        printf("The number of 10 notes alloted is: %d\n",value);
        amount=amount-(value*10);
    }
    if (amount!=0)
    {
        printf("The remaining amount is: %d\n",amount);
    }
    return 0;
}