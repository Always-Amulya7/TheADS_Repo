#include <stdio.h>
int main(){
    float phy,chem,math;
    float agg,agg_per;
    printf("Enter the marks: ");
    scanf("%f%f%f",&phy,&chem,&math);
    agg=(phy+chem+math);
    agg_per=(agg/300)*100;
    if (agg_per>=90)
    printf("Your aggregate is A");
    else if (agg_per>=80&&agg_per<90)
    printf("Your aggregate is B");
    else if (agg_per>=70&&agg_per<80)
    printf("Your aggregate is C");
    else if (agg_per>=60&&agg_per<70)
    printf("Your aggregate is D");
    else if (agg_per>=50&&agg_per<60)
    printf("Your aggregate is E");
    else
    printf("Fail");
    return 0;
}