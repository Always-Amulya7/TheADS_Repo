#include <stdio.h>
#include <stdbool.h>
int main(){
    printf("The size of int is: %zu bytes\n",sizeof(int));
    printf("The size of float is: %zu bytes\n",sizeof(float));
    printf("The size of short is: %zu bytes\n",sizeof(short));
    printf("The size of long is: %zu bytes\n",sizeof(long));
    printf("The size of float is: %zu bytes\n",sizeof(float));
    printf("The size of double is: %zu bytes\n",sizeof(double));
    printf("The size of bool is: %zu bytes\n",sizeof(bool));
    return 0;
}