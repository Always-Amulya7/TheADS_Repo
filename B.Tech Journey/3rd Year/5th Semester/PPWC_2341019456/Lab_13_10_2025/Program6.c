#include <stdio.h>
#include <string.h>
#include <ctype.h>
int main() {
    char str1[50]="PPWC";
    for (int i=0;i<strlen(str1);i++){
        str1[i]=tolower(str1[i]);
    }
    printf("%s\n",str1);
    return 0;
}
