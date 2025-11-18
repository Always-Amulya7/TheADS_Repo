#include <stdio.h>
int main(){
    char character;
    printf("Enter a chracter: ");
    scanf("%c",&character);
    if (character>='A'&&character<='Z')
    printf("The alphabet character entered was: %c\n",character);
    if (character>='a'&&character<='z')
    printf("The alphabet character entered was: %c\n",character);
    return 0;
}