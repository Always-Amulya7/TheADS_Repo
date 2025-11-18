#include<stdio.h>
int main(){
    int age,a_age=0,b_age=0,s_age=0;
    for (int i=0;i<5;i++){
        printf("Enter the age: ");
        scanf("%d",&age);
        if (age<=5)
        b_age++;
        else if (age>5 && age<=17)
        s_age++;
        else
        a_age++;
    }
    printf("Baby Age: %d\n",b_age);
    printf("Attending School Age: %d\n",s_age);
    printf("Adult life Age: %d\n",a_age);
    return 0;
}