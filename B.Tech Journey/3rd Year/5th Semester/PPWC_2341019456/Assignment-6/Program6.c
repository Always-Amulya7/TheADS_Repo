#include <stdio.h>
#include <string.h>
#include <ctype.h>
int main(){
    char str[100];
    printf("Enter the string: ");
    gets(str);
    int vowels=0,consonants=0,digits=0,white_space=0,other=0;
    int len=strlen(str);
    for (int i=0;i<len;i++){
        char check=tolower(str[i]);
        if (check=='a'||check=='e'||check=='i'||check=='o'||check=='u')
        vowels++;
        else if((check>='a'&&check<='z')&&(check!='a'||check!='e'||check!='i'||check!='o'||check!='u'))
        consonants++;
        else if (check>='0'&&check<='9')
        digits++;
        else if(check==' '||check=='\t'||check=='\n')
        white_space++;
        else
        other++;
    }
    printf("Vowels: %d\n",vowels);
    printf("Consonants: %d\n",consonants);
    printf("Digits: %d\n",digits);
    printf("White Space: %d\n",white_space);
    printf("Other Symbols: %d\n",other);
    return 0;
}