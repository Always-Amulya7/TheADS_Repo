#include<stdio.h>
int main(){
    int amount,choice,value;
    printf("Enter the amount: ");
    scanf("%d",&amount);
    printf("Enter your choice (10,20,50,100,200,500): ");
    scanf("%d",&choice);
    switch (choice)
    {
    case 10:value=(int) amount/10;
            amount=amount-(value*10);
            printf("The number of %d notes alloted is: %d",10,value);
            break;
    case 20:value=(int) amount/20;
            amount=amount-(value*20);
            printf("The number of 20 notes alloted is: %d",value);
            break;
    case 50:value=(int) amount/50;
            amount=amount-(value*50);
            printf("The number of 50 notes alloted is: %d",value);
            break;
    case 100:value=(int) amount/100;
            amount=amount-(value*100);
            printf("The number of 100 notes alloted is: %d",value);
            break;
    case 200:value=(int) amount/200;
            amount=amount-(value*200);
            printf("The number of 200 notes alloted is: %d",value);
            break;
    case 500:value=(int) amount/500;
            amount=amount-(value*500);
            printf("The number of 500 notes alloted is: %d",value);
            break;
    }
    if (amount!=0)
    printf("\nYour debit was done!");
    else{
        int count=0;
        while(amount!=0){
            if (amount!=10||amount!=20||amount!=50||amount!=100||amount!=500){
                count++;
                amount=amount-(count*amount);
            }
            printf("Take %d notes of %d",count,amount);
        }
    }
    return 0;
}