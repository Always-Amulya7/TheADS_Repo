#include<stdio.h>
#include<string.h>
struct emp{
    int id;
    char name[10];
    float salary;
};
struct emp e1,e2;
int main(){
    strcpy(e1.name,"abcd");
    e1.id=4001;
    e1.salary=10000;
    printf("The name, id, salary of employee is: %s, %d, %f",e1.name,e1.id,e1.salary);
    return 0;
}