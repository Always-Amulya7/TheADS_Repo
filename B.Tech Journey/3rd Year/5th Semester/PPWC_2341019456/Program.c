// #include <stdio.h>
// int main() {
//     printf("Size of char: %zu byte(s)\n", sizeof(char));
//     printf("Size of unsigned char: %zu byte(s)\n", sizeof(unsigned char));
//     printf("Size of short: %zu byte(s)\n", sizeof(short));
//     printf("Size of unsigned short: %zu byte(s)\n", sizeof(unsigned short));
//     printf("Size of int: %zu byte(s)\n", sizeof(int));
//     printf("Size of unsigned int: %zu byte(s)\n", sizeof(unsigned int));
//     printf("Size of long: %zu byte(s)\n", sizeof(long));
//     printf("Size of unsigned long: %zu byte(s)\n", sizeof(unsigned long));
//     printf("Size of long long: %zu byte(s)\n", sizeof(long long));
//     printf("Size of unsigned long long: %zu byte(s)\n", sizeof(unsigned long long));
//     printf("Size of float: %zu byte(s)\n", sizeof(float));
//     printf("Size of double: %zu byte(s)\n", sizeof(double));
//     printf("Size of long double: %zu byte(s)\n", sizeof(long double));
//     printf("Size of void pointer: %zu byte(s)\n", sizeof(void *));
//     printf("Size of int pointer: %zu byte(s)\n", sizeof(int *));
//     printf("Size of char pointer: %zu byte(s)\n", sizeof(char *));
//     printf("Size of float pointer: %zu byte(s)\n", sizeof(float *));
//     printf("Size of double pointer: %zu byte(s)\n", sizeof(double *));
//     return 0;
// }

// #include<stdio.h>
// #include<string.h>
// #include<ctype.h>
// #include<stdlib.h>
// int main(){
//     char str[]="Amulya";
//     char strr[]="AmulyaDeep";
//     char strrr[50];
//     printf("The length is: %d\n",strlen(str));
//     printf("The Cmp is: %d\n",strcmp(str,strr));
//     printf("The Cmp is: %d\n",strncmp(str,strr,6));
//     printf("the copy is %s",strcpy(strrr,str));
//     printf("the copy is %s",strncpy(strrr,str,4));
//     printf("The cat is: %s\n",strcat(str,strr));
//     printf("The cat is: %s\n",strncat(str,strr,6));
//     printf("The check is: %d",strchr(str,'A'));
//     return 0;
// }

// #include<stdio.h>
// #include<stdlib.h>
// struct check{
//     int roll,marks;
//     struct checkk{
//         int age;
//     } work;
// };
// union check1{
//     char gender;
// } Wor2;
// enum check2{
//     LOW=0,
//     MEDIUM=1,
//     HIGH=2
// } Wor3;
// int main(){
//     struct check e1;
//     e1.roll=59;
//     e1.marks=90;
//     e1.work.age=21;
//     union check1 e2;
//     e2.gender='M';
//     Wor3=MEDIUM;
//     printf("Struct: roll=%d marks=%d age=%d\n", e1.roll, e1.marks, e1.work.age);
//     printf("Union: gender='%c' (as int: %d)\n", e2.gender, (int)e2.gender);
//     printf("Enum: e3 = %d (MEDIUM)\n", Wor3);
//     return 0;
// }

// #include<stdio.h>
// #include<stdlib.h>
// int main(){
//     printf("ITER\n");
//     fork();
//     printf("ITER\n");
//     fork();
//     printf("ITER\n");
//     fork();
//     printf("ITER\n");
//     fork();
//     return 0;
// }

// #include<stdio.h>
// int main(){
//     printf("This is my first C program!\n");
//     printf("I Know:\n\twhere to write C program,\n");
//     printf("\thow to save and edit the program!\n");
//     printf("To compile- (1) gcc filename.c\n");
//     printf("\t    (2) gcc filename.c -o myout");
//     printf("\nTo run- (1) ./a.out\n\t(2) ./myout\n------------------------\nAble to run successfully !!!");
//     return 0;
// }

// #include<stdio.h>
// void bubblesort(int arr[],int n){
//     for (int i=0;i<n-1;i++){
//         for (int j=0;j<n-i-1;j++){
//             if (arr[j]>arr[j+1]){
//                 int temp=arr[j];
//                 arr[j]=arr[j+1];
//                 arr[j+1]=temp;
//             }
//         }
//     }
// }
// int main(){
//     int arr[]={64,25,12,22,11};
//     int n=5;
//     bubblesort(arr,n);
//     printf("Sorted Array: ");
//     for (int i=0;i<n;i++){
//         printf("%d ",arr[i]);
//     }
//     printf("\n");
//     return 0;
// }

// #include <stdio.h>
// int main()
// {
//     int x = 89;
//     int *p1 = &x;
//     int *p2 = &x;
//     int *p3 = &x;
//     printf("Value of x from p1: %d\n", *p1);
//     *p3 = 100;
//     printf("Updated value of x: %d\n", x);
// }

// #include <stdio.h>
// int main()
// {
//     int a = 12, b = 25, c = 18;
//     int *ptr;
//     printf("Before increment:\n");
//     printf("a = %d, b = %d, c = %d\n", a, b, c);
//     ptr = &a;
//     *ptr += 10;
//     ptr = &b;
//     *ptr += 10;
//     ptr = &c;
//     *ptr += 10;
//     printf("After increment:\n");
//     printf("a = %d, b = %d, c = %d\n", a, b, c);
//     return 0;
// }

// #include <stdio.h>
// int main()
// {
//     int int_arr[5] = {10, 13, 20, 33, 44};
//     float float_arr[6] = {10.2, 13.3, 20.0, 33.3, 45.3, 89.9};
//     printf("Integer array:\n");
//     for (int i = 0; i < 5; i++)
//     {
//         printf("Value: %d, Address: %p\n", *(int_arr + i), int_arr + i);
//     }
//     printf("Float array:\n");
//     for (int i = 0; i < 6; i++)
//     {
//         printf("Value: %.1f, Address: %p\n", *(float_arr + i), float_arr + i);
//     }
//     return 0;
// }

// #include <stdio.h>
// int main()
// {
//     int a[5], b[5], c[5], d[5], sumarr[5];
//     int *ptr_a = a, *ptr_b = b, *ptr_c = c, *ptr_d = d, *ptr_sum = sumarr;
//     printf("Enter 5 elements for array a: ");
//     for (int i = 0; i < 5; i++)
//         scanf("%d",  ptr_a+i);
//     printf("Enter 5 elements for array b: ");
//     for (int i = 0; i < 5; i++)
//         scanf("%d", ptr_b + i);
//     printf("Enter 5 elements for array c: ");
//     for (int i = 0; i < 5; i++)
//         scanf("%d", ptr_c + i);
//     printf("Enter 5 elements for array d: ");
//     for (int i = 0; i < 5; i++)
//         scanf("%d", ptr_d + i);
//     for (int i = 0; i < 5; i++)
//     {
//         *(ptr_sum + i) = *(ptr_a + i) + *(ptr_b + i) + *(ptr_c + i) + *(ptr_d + i);
//     }
//     printf("Element-wise sum: ");
//     for (int i = 0; i < 5; i++)
//         printf("%d ", *(ptr_sum + i));
//     printf("\n");
//     return 0;
// }

// #include <stdio.h>
// #include <string.h>

// int main() {
//     char str[] = "Amulya";
//     int len = strlen(str);
//     for (int i = 0; i < len / 2; i++) {
//         char temp = str[i];
//         str[i] = str[len - i - 1];
//         str[len - i - 1] = temp;
//     }
//     printf("%s", str);
//     return 0;
// }

// #include<stdio.h>
// int main(){
//     int arr[3];
//     int *ptr;
//     ptr=arr;
//     for (int i=0;i<3;i++){
//         scanf("%d",ptr+i);
//     }
//     for (int i=0;i<3;i++){
//         printf(" %d %p",*(ptr+i),ptr+i);
//     }
// }

// #include <stdio.h>
// int main()
// {
//     int *p = NULL;
//     p = (int *)malloc(sizeof(int));
//     *p = 10;
//     int *q;
//     q = (int *)malloc(sizeof(int));
//     *q = 15;
//     printf("%d %d\n", *p, *q);
//     return 0;
// }

// #include <stdio.h>
// int main(void)
// {
//     if (fork() == 0)
//         printf("1\n");
//     else if (fork() == 0)
//         printf("2\n");
//     else if (fork() == 0)
//         printf("3\n");
//     else if (fork() == 0)
//         printf("4\n");
//     else
//         printf("5\n");
//     return 0;
// }

#include<stdio.h>
int main()
{
    int ivar = 1234;
    printf(":%.*d:\n", 7, ivar);
    printf(":%-.*d:\n", 7, ivar);
    return 0;
}