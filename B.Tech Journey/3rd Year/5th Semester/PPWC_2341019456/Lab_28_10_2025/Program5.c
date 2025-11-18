#include<stdio.h>
struct emp{
    int id;
    char name[10];
    float salary;
};
int main(){
    int size;
    struct emp s;
    size=sizeof(s);
    printf("Size of structure %d\n",size);
    return 0;
}