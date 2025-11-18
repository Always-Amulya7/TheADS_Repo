import java.util.Scanner;
class Q6
{
    public static void main(String[] args)
    {
        try(Scanner sc=new Scanner(System.in))
        {
            System.out.print("Enter The Base:");
            int base=sc.nextInt();
            System.out.print("Enter The Power:");
            int power=sc.nextInt();
            System.out.println(base+" To Power "+power+" Is: "+(int) (Math.pow(base,power)));
        }
    }
}