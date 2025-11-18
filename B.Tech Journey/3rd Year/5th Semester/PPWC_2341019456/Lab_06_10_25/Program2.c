#include<stdio.h>
void display(int a1,int a2){
	printf("%d\n",a1);
	printf("%d\n",a2);
}
int main(){
	int arr[]={1,2,3,4,5};
	display(arr[1],arr[2]);
	return 0;
}
