#include<stdio.h>
#include<string.h>
int main(){
    printf("Enter a string: ");
    char str[50];
    gets(str);
    char str1[50];
    printf("The copied string is: %s",strcpy(str1,str));
    return 0;
}