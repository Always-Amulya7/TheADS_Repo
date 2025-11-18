#include<stdio.h>
#include<string.h>
int main(){
	char str1[20]="PPWC\0";
	char str2[10]="Class in 3PM\0";
	strncpy(str1,str2,10);
	printf("%s\n",str1);
	printf("%s\n",str2);
	return 0;
}
