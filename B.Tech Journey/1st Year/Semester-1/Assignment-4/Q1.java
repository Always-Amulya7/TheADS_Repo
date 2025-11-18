import java.util.Scanner;
class Q1
{
    public static void main(String args[])
    {
        try(Scanner sc=new Scanner(System.in))
        {
            int n1,n2,n3,i,sum=0;
            System.out.print("Enter The Number1:");
            n1=sc.nextInt();
            System.out.print("Enter The Number2:");
            n2=sc.nextInt();
            System.out.print("Enter The Number3:");
            n3=sc.nextInt();
            for(i=n1;i<=n2;i+=n3)
            {
                sum=sum+i;
            }
            System.out.println("Sum:"+sum);
        }
    }
}