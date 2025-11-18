#include<stdio.h>
int main(){
	int arr[2][3]={{1,2,3}, {4,5,6}};
	int *p[2];
	int **ptr;
	// arr->   1 2 3
	// arr+1-> 4 5 6
	p[0]=arr[0];
	p[1]=arr[1];
	ptr=p;
	printf("%d\n",*(*(ptr+0)+0));
	printf("%d\n",*(*(ptr+0)+1));
	printf("%d\n",*(*(ptr+1)+2));
	return 0;
}
