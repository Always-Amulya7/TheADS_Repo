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
	cout << "The common elements are: \n";
	for (int i=0;i<5;i++){
		for (int j=0;j<5;j++){
			if (arr1[i]==arr2[j])
			cout << "Common element found is: " << arr1[i] << "\n";
		}
	}
	return 0;
}
