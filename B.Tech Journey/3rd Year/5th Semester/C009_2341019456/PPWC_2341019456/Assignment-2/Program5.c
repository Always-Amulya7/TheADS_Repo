#include <stdio.h>
float add(float num1,float num2){
	float sum=num1+num2;
        printf("The Sum is %f\n",sum);
        return 0.0;
}
float sub(float num1,float num2){
	float diff=num1-num2;
        printf("The Difference is %f\n",diff);
        return 0.0;
}
float mul(float num1,float num2){
	float mul=num1*num2;
        printf("The Multiplication is %f\n",mul);
        return 0.0;
}
float div(float num1,float num2){
	if (num2==0)
        printf("Error: Division by zero\n");
        else{
        	float div=num1/num2;
                printf("The Division is %f\n",div);
        }
        return 0.0;
}
void calculator(float num1,float num2,char ope){
    switch (ope){
    	case '+':add(num1,num2);
            	 break;
        case '-':sub(num1,num2);
            	 break;
        case '*':mul(num1,num2);
            	 break;
        case '/':div(num1,num2);
        	 break;
        default:printf("Error: Invalid operator\n");
            	break;
    }
}
int main(){
    float num1, num2;
    char ope;
    printf("Enter first number: ");
    scanf("%f",&num1);
    printf("Enter the operation: ");
    scanf(" %c",&ope);
    printf("Enter second number: ");
    scanf("%f",&num2);
    calculator(num1,num2,ope);
    return 0;
}
