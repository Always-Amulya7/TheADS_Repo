import java.util.Scanner;
class Q4
{
    public static void main(String args[])
    {
        try(Scanner sc=new Scanner(System.in))
        {
            int i;
            System.out.println("Enter Two Numbers To Find GCD Of The Numbers:");
            int num1=sc.nextInt();
            int num2=sc.nextInt();
            int rem,gcd=1;
            for (i=1;i<=Math.max(num1,num2);i++)
            {
                if (num2%num1!=0)
                {
                    rem=num2%num1;
                    gcd=num1%rem;
                }
            }
            System.out.println("GCD Of The Numbers Are:"+gcd);
        }
    }
}