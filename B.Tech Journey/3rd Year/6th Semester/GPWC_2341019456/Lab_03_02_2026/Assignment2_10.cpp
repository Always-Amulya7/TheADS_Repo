#include<iostream>
using namespace std;
long Pow(int num,int pow){
	if (pow==1)
	return 1;
	int ans=1;
	for (int i=1;i<=pow;i++){
		ans*=num;
	}
	return ans;
}
int main(){
	int num,pow;
	cout << "Enter a number: ";
	cin >> num;
	cout << "Enter the power: ";
	cin >> pow;
	cout << "The power of " << num << "^" << pow << " is: " << Pow(num,pow) << "\n";
	return 0;
}
