import java.util.Scanner;
class Q4
{
    public static void main(String[] args)
    {
        try(Scanner sc=new Scanner(System.in))
        {
            int esum=0,osum=1;
            String est="",ost="";
            System.out.print("Enter A Number: ");
            int num=sc.nextInt();
            for (int i=1;i<=num;i++)
            {
                if (i%2==0)
                {
                    esum=esum+i;
                    est=est+(i+"+");
                }
                else
                {
                    osum=osum*i;
                    ost=ost+(i+"*");
                }
            }
            System.out.println("Sum of all even numbers = "+est+" = "+esum);
            System.out.println("Sum of all odd numbers = "+ost+" = "+osum);
        }
    }
}