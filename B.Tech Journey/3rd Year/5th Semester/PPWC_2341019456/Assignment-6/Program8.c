#include<stdio.h>
#include<string.h>
#include<ctype.h>
int main(){
    char str[50];
    printf("Enter the string: ");
    gets(str);
    printf("Enter the character: ");
    char letter;
    int frequency=0;
    scanf("%c",&letter);
    for (int i=0;i<strlen(str);i++){
        char check=(char) tolower(str[i]);
        if (check==letter)
        frequency++;
    }
    if (frequency==0)
    printf("Not found.");
    else
    printf("Frequency of the character \'%c\' is: %d",letter,frequency);
    return 0;
}