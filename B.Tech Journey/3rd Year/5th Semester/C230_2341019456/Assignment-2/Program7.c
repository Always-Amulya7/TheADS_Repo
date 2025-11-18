#include<stdio.h>
int main(){
    char character;
    printf("Enter a Uppercase chracter: ");
    scanf("%c",&character);
    for (int i=65;i<=90;i++){
        if ((int)character==i)
        printf("The alphabet character entered was: %c\n",character);
    }
    return 0;
}