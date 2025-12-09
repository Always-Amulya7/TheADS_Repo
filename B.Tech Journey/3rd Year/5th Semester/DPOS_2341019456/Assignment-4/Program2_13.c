#include <stdio.h>
#include <unistd.h>
#include <sys/types.h>
int main()
{
	int i=5;
	fork();
	i=i+1;
	fork();
	printf("% d",i);
	return 0;
}
