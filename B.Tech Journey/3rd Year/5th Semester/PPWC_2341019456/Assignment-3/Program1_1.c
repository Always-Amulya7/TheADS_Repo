#include <stdio.h>
int main(){
    int arr[3];
    int largest,second_largest;
    printf("Enter three numbers: ");
    for (int i=0;i<3;i++){
        scanf("%d",&arr[i]);
    }
    if (arr[0]>arr[1]){
        largest=arr[0];
        second_largest=arr[1];
    }else{
        largest=arr[1];
        second_largest=arr[0];
    }
    for (int i=2;i<3;i++){
        if(arr[i]>largest){
            second_largest=largest;
            largest=arr[i];
        }else if(arr[i]>second_largest&&arr[i]!=largest){
            second_largest = arr[i];
        }
    }
    printf("Largest: %d\n",largest);
    printf("Second Largest: %d\n",second_largest);
    return 0;
}
