#include<iostream>
#include<cmath>
using namespace std;
int main(){
	float p,r,t;
	cout << "Enter the principal, rate and time: ";
	cin >> p >> r >> t;
	float ci=p*pow((1+(r/100)),t);
	cout << "The compound interest is: " << ci << "\n";
	return 0;
}
