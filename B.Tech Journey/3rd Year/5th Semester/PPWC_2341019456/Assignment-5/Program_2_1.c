#include<stdio.h>
int main(){
    int size;
    printf("Enter the size: ");
    scanf("%d",&size);
    int arr[size];
    printf("Enter the elements: ");
    for (int i=0;i<size;i++){
        scanf("%d",&arr[i]);
    }
    printf("Even Numbers: ");
    for (int i=0;i<size;i++){
        if (arr[i]%2==0)
        printf("%d ",arr[i]);
    }
    printf("\nOdd Numbers: ");
    for (int i=0;i<size;i++){
        if (arr[i]%2!=0)
        printf("%d ",arr[i]);
    }
    return 0;
}