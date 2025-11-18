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
    int position;
    printf("Enter the position to delete: ",size-1);
    scanf("%d",&position);
    for (int i=position;i<size-1;i++){
        arr[i]=arr[i+1];
    }
    size--;
    printf("The updated array is: ");
    for (int i=0;i<size;i++){
        printf("%d ",arr[i]);
    }
    return 0;
}
