#include<stdio.h>
#include<string.h>
int main(){
    char str1[50],str2[50];
    printf("Enter the first string: ");
    gets(str1);
    printf("Enter the second string: ");
    gets(str2);
    int count=0;
    char *ptr1=&str1[0],*ptr2=&str2[0];
    if (strlen(str1)==strlen(str2)){
        while(*ptr1!='\0'&&*ptr2!='\0'){
            if (*ptr1==*ptr2)
            count++;
            *ptr1++;
            *ptr2++;
        }
    }
    if (count==strlen(str1))
    printf("They are equal");
    else
    printf("They are not equal");
}