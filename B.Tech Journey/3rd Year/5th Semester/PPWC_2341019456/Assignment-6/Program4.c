#include <stdio.h>
#include <string.h>
#include <ctype.h>
int main(){
    char str[50];
    char str1[50];
    printf("Enter the 1st string: ");
    gets(str);
    printf("Enter the 2nd string: ");
    gets(str1);
    for (int i=0;str[i];i++){
        str[i]=tolower((char)str[i]);
    }
    for (int i=0;str1[i];i++){
        str1[i]=tolower((char)str1[i]);
    }
    printf("%s, %s\n",str,str1);
    int value=strcmp(str, str1);
    if (value==0)
    printf("Strings are equal.\n");
    else
    printf("Strings are not equal.\n");
    return 0;
}