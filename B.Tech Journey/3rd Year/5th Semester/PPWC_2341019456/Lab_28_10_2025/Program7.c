#include<stdio.h>
#include<string.h>
struct subject{
    char sub_name[50];
    char sub_duration[50];
    int id;
};
int main(){
    struct subject sub;
    struct subject *ptr;
    ptr=&sub;
    strcpy(sub.sub_name,"PPWC");
    sub.id=3544;
    strcpy(sub.sub_duration,"six months");
    printf("Subject name is %s\n",(*ptr).sub_name);
    printf("Enter the subject name: ");
    scanf("%s",&ptr->sub_name);
    printf("Subject name is : %s\n",ptr->sub_name);
    return 0;
}