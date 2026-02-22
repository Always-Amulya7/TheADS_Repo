#include<iostream>
using namespace std;
int main(){
	int num,num1;
	cout << "Enter the number: ";
	cin >> num1;
	num=num1;
	int rev=0;
	while(num1>0){
		rev=rev*10+num1%10;
		num1/=10;
	}
	cout << "The reverse of " << num << " is: " << rev << "\n";
	return 0;
}
