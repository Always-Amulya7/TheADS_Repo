/*#include<stdio.h>
#include<math.h>
int main(){
    int val=15;
    int *ptp=&val;
    double store=12345e5;
    printf("The memory address is %d\n",(void*)ptp);
    printf("%d",*ptp);
    printf("%r",store);
    return 0;
}*/

#include<stdio.h>
#include<math.h>
#define PI 3.14159
int main(){
    double radius,area,circumference;
    int num_circ=5;
    char circ_name='A';
    printf("Enter the radius:");
    scanf("%d",&radius);
    printf("Enter the area: ");
    scanf("%d",&area);
    printf("Enter the circumference: ");
    scanf("%d",&circumference);
    printf("The radius,area and circumference is: %d,%d,%d\n",radius,area,circumference);
    printf("The char and int value is: %c, %d",circ_name,num_circ);
    printf("The PI value is: ",PI);
    return 0;
}