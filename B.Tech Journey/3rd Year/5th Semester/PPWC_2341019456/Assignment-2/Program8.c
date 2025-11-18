#include<stdio.h>
int main(){
    char character;
    printf("Enter the character: ");
    scanf("%c",&character);
    if (character=='A'||character=='E'||character=='I'||character=='O'||character=='U'||
        character=='a'||character=='e'||character=='i'||character=='o'||character=='u')
    printf("The character entered is a vowel");
    else
    printf("The character entered is a consonant");
    return 0;
}