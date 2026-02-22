#include <iostream>
using namespace std;
int main(){
    int n,key;
    cout << "Enter number of elements: ";
    cin >> n;
    int arr[100];
    cout << "Enter array elements:\n";
    for (int i=0;i<n;i++){
        cin >> arr[i];
    }
    cout << "Enter element to remove: ";
    cin >> key;
    int index=0;
    for (int i=0;i<n;i++){
        if (arr[i]!=key){
            arr[index]=arr[i];
            index++;
        }
    }
    cout << "Array after removing occurrences:\n";
    for (int i=0;i<index;i++){
        cout << arr[i] << " ";
    }
    return 0;
}

