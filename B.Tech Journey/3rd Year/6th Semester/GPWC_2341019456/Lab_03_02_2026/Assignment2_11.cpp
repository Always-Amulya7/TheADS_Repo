#include<iostream>
using namespace std;
int main(){
	int arr1[5],arr2[5];
	cout << "Enter elements of array1: \n";
	for (int i=0;i<5;i++){
		int inp;
		cout << "The element at " << i+1 << " is: ";
		cin >> inp;
		arr1[i]=inp;
	}
	cout << "Enter elements of array2: \n";
	for (int i=0;i<5;i++){
		int inp;
		cout << "The element at " << i+1 << " is: ";
		cin >> inp;
		arr2[i]=inp;
	}
	bool flag=true;
	for (int i=0;i<5;i++){
		if (arr1[i]==arr2[i])
		continue;
		else
		flag=false;
	}
	if (flag)
	cout << "Is the array equal?: True\n";
	else
	cout << "Is the array equal?: False\n";
	return 0;
}
