#include<stdio.h>
#include<string.h>
int main(){
    char str[50];
    printf("Enter a string: ");
    gets(str);
    char str1[50];
    int j=0;
    for (int i=strlen(str)-1;i>=0;i--){
        str1[j++]=(char)str[i];
    }
    printf("The reversed string: %s\n",str1);
    return 0;
}