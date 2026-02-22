#include<iostream>
using namespace std;
int main(){
	int arr[5];
	cout << "Enter elements of array: \n";
	for (int i=0;i<5;i++){
		int inp;
		cout << "The element at " << i+1 << " is: ";
		cin >> inp;
		arr[i]=inp;
	}
	int max=arr[0],min=arr[0];
	for (int i=0;i<5;i++){
		 if (max>arr[i])
		 max=arr[i];
	}
	for (int i=0;i<5;i++){
		 if (min<arr[i])
		 min=arr[i];
	}
	cout << "The max element is: " << max << "\n";
	cout << "The min element is: " << min << "\n";
	return 0;
}
