#include<stdio.h>
#include<string.h>
int main(){
	int arr1[10]={1,2,3,4,5,6,7,8,9,10};
	int arr2[10]={11,12,13,14,15,16,17,18,19,20};
	int arr[20];
	int count=0;
	for (int i=0;i<10;i++){
		arr[i]=arr1[i];
	}
	for (int i=10;i<20;i++){
		arr[i]=arr2[count];
		count++;
	}
	printf("The merged array is: ");
	for (int i=0;i<20;i++){
		printf("%d ",arr[i]);
	}
	printf("\n");
	return 0;
}
