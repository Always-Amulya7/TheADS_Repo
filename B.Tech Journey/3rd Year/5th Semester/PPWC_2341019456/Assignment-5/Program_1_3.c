// Write a C programto find the maxzimum difference between two elements in an array.

#include<stdio.h>
int main(){
    int arr[]={1,2,3,4,5};
    for (int i=0;i<5;i++){
        for (int j=0;j<5;j++){
            if (arr[j]>arr[j+1])
                arr[j]=arr[j+1];
        }
    }
    printf("The largest element is: %d\n",arr[0]);
    printf("The 2nd largest element is: %d",arr[1]);
    return 0;
}