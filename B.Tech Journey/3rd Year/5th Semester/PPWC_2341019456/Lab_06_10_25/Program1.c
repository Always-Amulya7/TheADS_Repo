#include<stdio.h>
int main(){
	int arr[5]={1,2,3,4,5};
	printf("%d\n",arr[2]);
	arr[2]=10;
	int i;
	for (i=0;i<5;i++){
		printf("%d ",arr[i]);
	}
}
