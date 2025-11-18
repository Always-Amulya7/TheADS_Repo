#include<stdio.h>
int main(){
    int count=65;
    printf("The Uppercase Characters are: ");
    while (count<=90)
    {
        printf("%c ",(char) count);
        count++;
    }
    return 0;
}