#include <stdio.h>
int main(){
    int size;
    printf("Enter the size of the array: ");
    scanf("%d",&size);
    int arr[size+1];
    printf("Enter the elements of the array: ");
    for (int i=0;i<size;i++) {
        scanf("%d",&arr[i]);
    }
    int position,element;
    printf("Enter the position & element to enter: ",size);
    scanf("%d %d",&position,&element);
    for (int i=size;i>position;i--){
        arr[i]=arr[i-1];
    }
    arr[position]=element;
    printf("The updated array is: ");
    for (int i=0;i<=size;i++){
        printf("%d ",arr[i]);
    }
    return 0;
}
