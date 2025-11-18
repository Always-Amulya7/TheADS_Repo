#include<stdio.h>
#include<string.h>
int main(){
	char str1[10]="PPWC CLASS";
	char str2[10]="HAI AABHI";
	strncpy(str1,str2,5);
	printf("The copy value is %s\n",str1);
	return 0;
}
