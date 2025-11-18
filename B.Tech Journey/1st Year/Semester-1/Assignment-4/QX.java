import java.util.Scanner;
class QX
{
    public static void main(String[] args)
    {
        try(Scanner sc=new Scanner(System.in))
        {
            int i,count=0;
            System.out.print("Enter a number:");
            int num=sc.nextInt();
            for (i=3;i<=num;i++)
            {
                if((int)Math.pow(3,i)<=num)
                count=i;
            }
            if ((int)Math.pow(3,count)==num)
            System.out.println("The largest power of 3 less than or equal to "+num);
            else
            System.out.println("The largest power of 3 less than or equal to "+num+" is "+(int)Math.pow(3,count));
        }
    }
}