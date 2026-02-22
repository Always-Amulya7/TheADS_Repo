#include<iostream>
using namespace std;
int main(){
	int num,num1,rev=0;
	cout << "Enter the number: ";
	cin >> num1;
	num=num1;
	while(num1>0){
		rev=rev*10+num1%10;
		num1/=10;
	}
	if (rev==num)
	cout << "The number is a palindrome number\n";
	else
	cout << "The number is not a palindrome number\n";
	return 0;
}
