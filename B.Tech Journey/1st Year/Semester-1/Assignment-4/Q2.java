import java.util.Scanner;
class Q2
{
    public static void main(String[] args)
    {
        try(Scanner sc=new Scanner(System.in))
        {
            int sumOfDigits=0,temp=0;
            System.out.println("Enter A Number:");
            int number=sc.nextInt();
            for (int i=1;i<=number;i++)
            {
            sumOfDigits = 0;
            temp = number;
            // Extract digits and add them to the sum
            while (temp > 0)
            {
                sumOfDigits=sumOfDigits+(temp % 10);
                temp /= 10;
            }
            }
            // Check if the sum is divisible by 9
            if (sumOfDigits % 9 == 0)
            {
                System.out.println(number + " is divisible by 9.");
            }
            else
            {
                System.out.println(number + " is not divisible by 9.");
            }
        }
    }
}
