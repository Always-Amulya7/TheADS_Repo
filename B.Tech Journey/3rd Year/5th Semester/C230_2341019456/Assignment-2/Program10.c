#include<stdio.h>
int main(){
    int week_day;
    printf("Enter the week date: ");
    scanf("%d",&week_day);
    switch (week_day)
    {
    case 1:printf("It's Soomwaar");
           break;
    case 2:printf("It's Mangalwaar");
           break;
    case 3:printf("It's Budhwaar");
           break;
    case 4:printf("It's Guruwaar");
           break;
    case 5:printf("It's Shukrawaar");
           break;
    case 6:printf("It's Shaniwaar");
           break;
    case 7:printf("It's Raviwaar");
           break;
    default:printf("Not correct input");
           break;
    }
    return 0;
}