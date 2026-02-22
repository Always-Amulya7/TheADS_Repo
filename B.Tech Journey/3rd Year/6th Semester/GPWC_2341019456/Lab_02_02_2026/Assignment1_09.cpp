#include<iostream>
using namespace std;
int main(){
	int a,b,c;
	cout << "Enter three numbers: ";
	cin >> a >> b >> c;
	if (a>b&&a>c)
	cout << a << " Is greatest\n";
	else if (b>a&&b>c)
	cout << b << " Is greatest\n";
	else
	cout << c << " Is greatest\n";
	return 0;
}
