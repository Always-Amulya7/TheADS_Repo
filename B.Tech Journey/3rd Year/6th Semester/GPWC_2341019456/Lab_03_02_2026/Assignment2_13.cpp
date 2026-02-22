#include<iostream>
using namespace std;
int main(){
	int arr[5];
	int sum=0;
	cout << "Enter elements of array1: \n";
	for (int i=0;i<5;i++){
		int inp;
		cout << "The element at " << i+1 << " is: ";
		cin >> inp;
		arr[i]=inp;
		sum+=arr[i];
	}
	cout << "The average of the array elements is: " << (float)sum/5 << "\n";
	return 0;
}
