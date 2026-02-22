#include<iostream>
using namespace std;
int main(){
	int num,count=0;
	cout << "Enter a number: ";
	cin >> num;
	if (num<=1)
	cout << "The number " << num << " is not Prime\n";
	else{
	for (int i=2 ;i*i<num;i++){
		if (num%i==0)
		count++;
	}
	if (count==0)
	cout << "The number " << num << " is Prime\n";
	else
	cout << "The number " << num << " is not Prime\n";}
	return 0;
}
