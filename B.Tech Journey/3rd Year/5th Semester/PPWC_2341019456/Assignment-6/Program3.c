#include<stdio.h>
#include<string.h>
int main(){
    char str[50];
    printf("Enter the string: ");
    gets(str);
    char str1[50]="Again ";
    strcat(str1,str);
    printf("Original string: %s\n",str);
    printf("Concatinated string: %s\n",str1);
    return 0;
}