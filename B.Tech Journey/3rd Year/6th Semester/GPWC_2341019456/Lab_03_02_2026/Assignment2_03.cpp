#include<iostream>
using namespace std;
int main(){
	int fact=1;
	int num;
	cout << "Enter the number to get the factorial: ";
	cin >> num;
	for (int i=1;i<=num;i++){
		fact*=i;
	}
	cout << "The factorial of " << num << " is: " << fact << "\n";
	return 0;
} 
