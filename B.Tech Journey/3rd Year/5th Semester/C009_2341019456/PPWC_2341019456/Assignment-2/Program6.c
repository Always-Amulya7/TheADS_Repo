#include<stdio.h>
#include<math.h>
float g_Salary(float salary){
	float g_salary;
	if (salary<=10000)
	g_salary+=((0.2*salary)+(0.6*salary));
	else if (salary>=10001&& salary<=20000)
	g_salary+=((2.5*salary)+(9*salary));
	else
	g_salary+=((3*salary)+(9.5*salary));
	return salary+g_salary;
}
int main(){
	float salary;
	printf("Enter the salary: ");
	scanf("%f",&salary);
	printf("The gross salary is %f\n",g_Salary(salary));
	return 0;
}
