#include <stdio.h>
#include <string.h>
struct student
{
    int roll;
    char name[50];
    float marks;
};
int main()
{
    struct student s[3];
    struct student *ptr;
    ptr = s;
    for (int i = 0; i < 3; i++)
    {
        printf("Enter the students details %d\n", i + 1);
        printf("Enter the roll number");
        scanf("%d", &(ptr + i)->roll);
        printf("Enter name: ");
        scanf("%s", &(ptr + i)->name);
        printf("Enter marks: ");
        scanf("%f", &(ptr + i)->marks);
    }
    printf("Students details\n");
    for (int i = 0; i < 3; i++)
    {
        printf("Student roll %d\n",(ptr+i)->roll);
        printf("Student name %s\n",(ptr+i)->name);
        printf("Student marks %f\n",(ptr+i)->marks);
    }
    return 0;
}