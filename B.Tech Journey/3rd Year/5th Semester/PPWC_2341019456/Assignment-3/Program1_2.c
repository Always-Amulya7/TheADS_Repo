#include <stdio.h>

int main() {
    int arr[3];
    int smallest,second_smallest;
    printf("Enter three numbers: ");
    for (int i=0;i<3;i++) {
        scanf("%d",&arr[i]);
    }
    if(arr[0]<arr[1]&&arr[0]<arr[2])
        smallest=arr[0];
    else if(arr[1]<arr[2])
        smallest=arr[1];
    else
        smallest = arr[2];
    if(smallest==arr[0]) {
        second_smallest=(arr[1]<arr[2])?arr[1]:arr[2];
    }else if(smallest==arr[1]){
        second_smallest=(arr[0]<arr[2])?arr[0]:arr[2];
    }else{
        second_smallest=(arr[0]<arr[1])?arr[0]:arr[1];
    }
    printf("Smallest: %d\n",smallest);
    printf("2nd Smallest: %d\n",second_smallest);
    return 0;
}

