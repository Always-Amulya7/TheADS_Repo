import java.util.Scanner;
class Q5
{
    public static void main(String[] args)
    {
        try(Scanner sc=new Scanner(System.in))
        {
            System.out.print("Enter The Range:");
            int i,n,j;
            n=sc.nextInt();
            int count=1;
            for (i = 1; i <= n; i++)
            {
                for (j =1 ; j <= i; j++) 
                {
                    if(j==1)
                    {
                        System.out.print(j);
                    }
                    else
                    {
                        System.out.print(j);
                        System.out.print(count);
                        count++;
                    }
                }
                System.out.println();
            }
        }
    }
}