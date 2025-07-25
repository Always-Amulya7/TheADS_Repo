#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <string.h>

void filework();
void enter(int n);

int main()
{
    printf("Enter your name: ");
    char ch[100];
    gets(ch);
    printf("Your name is: ");
    puts(ch);
    filework();
    enter(1);
    int Arr[]={1,2,3,4,5,6,7,8,9,10};
    for (int i=0;i<10;i++){
        printf("%d\t",Arr[i]);
    }
    int *value=&Arr[0];
    printf("\n");
    printf("The first element is %u\n",*value);
    int *new_array = (int *)malloc(5 * sizeof(int));
    for (int i = 1; i <= 10; i++)
    {
        new_array[i] = i;
        printf("%d\t", new_array[i]);
    }
    free(new_array);
    return (0);
}

void filework()
{
    FILE *fptr = fopen("Text.txt", "r");
    char ch = fgetc(fptr);
    while (ch != EOF)
    {
        printf("%c", ch);
        ch = fgetc(fptr);
    }
    fclose(fptr);
}

typedef struct details
{
    char Name[100];
    int age;
    char gender;
} school;

void enter(int n)
{
    school s1;
    printf("\n");
    for (int i = 0; i < n; i++)
    {
        printf("Enter name: ");
        fgets(s1.Name, sizeof(s1.Name), stdin);
        s1.Name[strcspn(s1.Name, "\n")] = 0;
        printf("Enter age: ");
        scanf("%d", &s1.age);
        while (getchar() != '\n')
            ;
        printf("Enter gender: ");
        scanf("%c", &s1.gender);
        while (getchar() != '\n')
            ;
    }
}

// int *ptr=arr[0];
// printf(ptr->code);
// int **ptr=*ptr;
//printf(**ptr);