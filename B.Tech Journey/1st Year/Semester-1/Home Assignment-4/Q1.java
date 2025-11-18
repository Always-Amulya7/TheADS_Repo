import java.util.Scanner;
class Q1
{
    public static void main(String args[])
    {
        try(Scanner sc=new Scanner(System.in))
        {
            int i,num,nsum=0,ssum=0;
            System.out.println("Enter The Range:");
            num=sc.nextInt();
            for (i=1;i<=num;i++)
            {
                nsum=nsum+(i*i);
            }
            for (i=1;i<=num;i++)
            {
                ssum=ssum+(i);
            }
            System.out.println("Sum of The Numbers:"+nsum);
            System.out.println("Sum of The Squares Of The Numbers:"+((int)Math.pow(ssum,2)));
            int diff=((int)Math.pow(ssum,2))-nsum;
            System.out.println("Sum:"+diff);
        }
    }
}