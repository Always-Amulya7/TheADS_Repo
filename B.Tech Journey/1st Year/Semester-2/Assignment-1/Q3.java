import java.util.Scanner;
class Q3
{
    public static void main(String args[])
    {
        try(Scanner sc=new Scanner(System.in))
        {
            System.out.print("Enter The Number: ");
            int Number=sc.nextInt();
            int Sum=0,PSum=1,Store=Number;
            while(Number>0)
            {
                Sum+=Number%10;
                PSum*=Number%10;
                Number=Number/10;
            }
            if (Sum==PSum)
            System.out.println("So, "+Store+" Is A Spy Number");
            else
            System.out.println("So, "+Store+" Is Not A Spy Number");
        }
    }
}