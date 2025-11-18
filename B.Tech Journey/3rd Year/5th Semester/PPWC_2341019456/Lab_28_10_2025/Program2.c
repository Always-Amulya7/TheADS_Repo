#include<stdio.h>
#include<string.h>
int main(){
    printf("Enter a string: ");
    char str[50];
    gets(str);
    printf("The reversed string is: %s",strrev(str));
    return 0;
}