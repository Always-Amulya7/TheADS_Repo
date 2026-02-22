#include<iostream>
using namespace std;
int main(){
	int num;
	cout << "Enter the number: ";
	cin >> num;
	cout << "The Multiplication Table of " << num << " Is: \n";
	for (int i=1;i<=10;i++){
		cout << num << " x " << i << " = " << num*i << "\n";
	}
	return 0;
}
