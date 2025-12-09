#include<stdio.h>
#include<stdlib.h>
#include<unistd.h>
#include<sys/wait.h>
int main(){
    pid_t cpid;
    pid_t cpid2;
    int status=0;
    cpid=fork();
    if (cpid==-1){
        exit(-1);
    }
    if (cpid==0){
        printf("\nFirst child executing itspid= (%d)\n",getpid());
        sleep(40);
        printf("Child pid= %d\n",getpid());
        exit(1);
    }
    else{
        cpid2=fork();
        if (cpid2==0){
            printf("Second child executing its pid= (%d)\n",getpid());
            sleep(40);
            printf("Child pid= %d\n",getpid());
            exit(1);
        }
        printf("\nParent executing before wait()\n");
        while(1){
            pid_t id2 = waitpid(cpid, &status, WNOHANG | WUNTRACED | WCONTINUED );
            printf("Status == %d\n",status);
            sleep(1);
            if(id2==-1){
                break;
            }
            if(id2>0){
                //cpid=wait(&status);
                if(WIFEXITED(status)){
                    printf("The exit status set is %d\n",WEXITSTATUS(status));
                }
                else if(WIFSIGNALED(status)){
                    printf("The terminationsignal is %d\n",WTERMSIG(status));
                }
                else if(WIFSTOPPED(status)){
                    printf("The stopped signal is: %d\n",WSTOPSIG(status));
                }
                else if(WIFCONTINUED(status)){
                    printf("The process is resume\n");
                }
            }
        }
    }
    printf("The process process completed..........\n");
    return 0;
}
