#include <iostream>
using namespace std;
int main(){
    int n;
    cout << "Enter number of elements: ";
    cin >> n;
    int arr[10];
    cout << "Enter array elements:\n";
    for (int i=0;i<n;i++) {
        cin >> arr[i];
    }
    cout << "Array elements in reverse order:\n";
    for (int i=n-1;i>=0;i--) {
        cout << arr[i] << " ";
    }
    return 0;
}
