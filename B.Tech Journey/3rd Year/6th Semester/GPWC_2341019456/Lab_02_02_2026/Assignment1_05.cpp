#include<iostream>
using namespace std;
int main(){
	float fah;
	cout << "Enter the Fah value: ";
	cin >> fah;
	float cel=(5*(fah-32))/9;
	cout << "The Fah value is: " << cel << "\n";
	return 0;
}
