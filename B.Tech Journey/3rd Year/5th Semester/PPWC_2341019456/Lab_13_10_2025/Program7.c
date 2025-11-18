#include <stdio.h>
#include <string.h>
int main() {
	char result[10];
	char str1[15]="Jan.30.1998";
	result[9]='\0';
    	strncpy(result,str1,9);
    	printf("%s\n",result);
    	return 0;
}
