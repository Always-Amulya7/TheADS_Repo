#include<iostream>
using namespace std;
int main(){
	int a,b,temp;
	cout << "Enter two numbers: ";
	cin >> a >> b;
	cout << "The numbers entered: " << a << ", "<< b << "\n";
	temp=a;
	a=b;
	b=temp;
	cout << "After swapping the numbers we have: " << a << ", "<< b << "\n";
	return 0;
}
