#include<iostream>
using namespace std;
long factorial(int num){
	if (num==1)
	return (long)1;
	return (long)(num*factorial(num-1));
}
int main(){
	long fact;
	int num;
	cout << "Enter the number: ";
	cin >> num;
	cout << "The factorial of " << num << " is: " << factorial(num) << "\n";
	return 0;
}
