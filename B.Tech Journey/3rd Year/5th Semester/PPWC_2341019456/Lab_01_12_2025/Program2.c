#include<stdio.h>
#include<stdlib.h>
#include<unistd.h>

void f1(){
	printf("PPWC\n");
}
void f2(){
	printf("DOS\n");
}

int main(){
	atexit(f1);
	atexit(f2);
	printf("Main end...\n");
	return 0;
}
