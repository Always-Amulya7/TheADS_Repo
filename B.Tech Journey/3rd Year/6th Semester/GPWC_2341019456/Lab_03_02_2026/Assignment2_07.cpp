#include<iostream>
using namespace std;
int main(){
	int ope1,ope2;
	char oper;
	cout << "Enter the Operand1: ";
	cin >> ope1;
	cout << "Enter the Operator: ";
	cin >> oper;
	cout << "Enter the Operand2: ";
	cin >> ope2;
	switch(oper){
		case '+':
		cout << "The sum of the numbers is: " << ope1+ope2 << "\n";
		break;
		case '-':
		cout << "The differnce of the numbers is: " << ope1-ope2 << "\n";
		break;
		case '*':
		cout << "The multiplication of the numbers is: " << ope1*ope2 << "\n";
		break;
		case '/':
		if (ope2!=0)
		cout << "The division of the numbers is: " << ope1/ope2 << "\n";
		else
		cout << "Division by 0 error\n";
		break;
		default:
		cout << "Wrong operation to be performed\n";
		break;
	}
	return 0;
}
