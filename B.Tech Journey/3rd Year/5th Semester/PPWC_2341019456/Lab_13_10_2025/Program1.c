#include<stdio.h>
#include<string.h>
int main(){
	char str1[10]="PPWC";
	char str2[10]="CLASS";
	strcpy(str1,str2);
	printf("The copy value is %s\n",str1);
	return 0;
}
