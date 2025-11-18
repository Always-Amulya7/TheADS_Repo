#include<stdio.h>
#include<string.h>
#include<ctype.h>
int main(){
    int max=0,counter=0;
    char str[100];
    printf("Enter the string: ");
    gets(str);
    while(counter<strlen(str)){
        int count=0;
        char check=(char) str[counter];
        for (int i=0;i<strlen(str);i++){
            if ((char) str[i]==check)
            count++;
        }
        if (count>max)
        max=count;
        counter++;
    }
    printf("The max value is: %d",max);
    return 0;
}