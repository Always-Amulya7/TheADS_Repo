#include <stdio.h>
int main(){
    int size;
    printf("Enter the size of the array: ");
    scanf("%d",&size);
    int arr[size];
    printf("Enter the elements of the array: ");
    for (int i=0;i<size;i++) {
        scanf("%d",&arr[i]);
    }
    int newSize=size;
    for (int i=0;i<newSize;i++){
        for (int j=i+1;j<newSize;j++){
            if (arr[i]==arr[j]){
                for (int k=j;k<newSize-1;k++){
                    arr[k]=arr[k+1];
                }
                newSize--;j--;
            }
        }
    }
    printf("The updated array with removed duplicates is: ");
    for (int i=0;i<newSize;i++){
        printf("%d ",arr[i]);
    }
    return 0;
}