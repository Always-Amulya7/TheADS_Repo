#include <stdio.h>
#include <unistd.h>
#include <sys/types.h>
int main()
{
	int i=5;
	if(vfork()==0)
	{
		printf("Child: %d",i);
		_exit(0);
	}
	else
	{
		printf("Parent: %d",i);
	}
	return 0;
}
