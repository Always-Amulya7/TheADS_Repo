#include<stdio.h>
int main(){
    int size;
    printf("Enter the size: ");
    scanf("%d",&size);
    int arr[size];
    printf("Enter the elements in sorted way: ");
    for (int i=0;i<size;i++){
        scanf("%d",&arr[i]);
    }
    printf("Enter the position & element to insert: ");
    int position,element;
    scanf("%d %d",&position,&element);
    arr[position]=element;
    printf("The updated array is: ");
    for (int i=0;i<size;i++){
        printf("%d ",arr[i]);
    }
    return 0;
}