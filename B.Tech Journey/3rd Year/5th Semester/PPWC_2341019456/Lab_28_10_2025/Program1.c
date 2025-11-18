#include<stdio.h>
int length(char *ptr){
    int count=0;
    while(*ptr!='\0'){
        count++;
        ptr++;
    }
    return count;
}
int main(){
    printf("Enter the string: ");
    char str[50];
    gets(str);
    int l;
    l=length(str);
    printf("The length of the string is %d",l);
    return 0;
}