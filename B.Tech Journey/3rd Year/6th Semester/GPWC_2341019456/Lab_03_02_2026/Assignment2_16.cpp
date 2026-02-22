#include <iostream>
using namespace std;
int removeDuplicates(int arr[],int n){
    if(n==0)
    return 0;
    int index=1;
    for(int i=1;i<n;i++){
        if(arr[i]!=arr[i-1]){
            arr[index]=arr[i];
            index++;
        }
    }
    return index;
}
int main(){
    int arr[]={1,1,2,2,2,3,4,4,5};
    int n=sizeof(arr)/sizeof(arr[0]);
    int newSize=removeDuplicates(arr,n);
    cout << "Array after removing duplicates:\n";
    for (int i=0;i<newSize;i++){
        cout << arr[i] << " ";
    }
    return 0;
}
