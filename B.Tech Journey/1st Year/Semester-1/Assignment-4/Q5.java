import java.util.Scanner;
class Q5
{
    public static void main(String[] args)
    {
        try(Scanner sc=new Scanner(System.in))
        {
            System.out.print("Enter A Number:");
            int num=sc.nextInt();
            int sum=0;
            for (int i=1;i<num;i++)
            {
                if (num%i==0)
                {
                    sum=sum+i;
                }
            }
            if (num==sum)
            System.out.println(num+" Is A Perfect Number");
            else
            System.out.println(num+" Is Not A Perfect Number");
        }
    }
}