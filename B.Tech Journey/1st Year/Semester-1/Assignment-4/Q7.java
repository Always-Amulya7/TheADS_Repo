import java.util.Scanner;
class Q7
{
    public static void main(String args[])
    {
        try(Scanner sc=new Scanner(System.in))
        {
            System.out.print("Enter a no. for which you want to find the multiplication table:");
            int num=sc.nextInt();
            for (int i=1;i<=10;i++)
            {
                System.out.println(num+" X "+i+" = "+num*i);
            }
        }
    }
}