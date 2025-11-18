#include<stdio.h>
#include<string.h>
#include<ctype.h>
int main(){
    char str[50];
    printf("Enter the string: ");
    gets(str);
    int count=0;
    for (int i=0;i<strlen(str);i++){
        if ((char) str[i]==' ' && (char) str[i+1]!=' ')
        count++;
    }
    printf("Total number of words: %d",count+1);
    return 0;
}