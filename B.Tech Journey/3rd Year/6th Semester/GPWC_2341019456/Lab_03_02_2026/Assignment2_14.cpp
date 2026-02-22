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
	int arr[10];
	int count=0;
	for (int i=0;i<10;i++){
		if (i<5)
		arr[i]=arr1[i];
		else{
			arr[i]=arr2[count];
			count++;
		}
	}
	cout << "The sorted array is: ";
	for (int i=0;i<10;i++){
		if (i!=9)
		cout << arr[i] << ", ";
		else
		cout << arr[i] << "\n";
	}
	return 0;
}
