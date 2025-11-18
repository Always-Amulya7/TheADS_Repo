import java.util.Scanner;
class Q5
{
    public static int Sum_Of_Digits(int Num)
    {
        while (Num >= 10)
        {
            Num = calculateDigitSum(Num);
        }
        return Num;
    }
    private static int calculateDigitSum(int Num)
    {
        int Sum = 0;
        while (Num > 0)
        {
            Sum += Num % 10;
            Num /= 10;
        }
        return Sum;
    }    public static void main(String args[])
    {
        try(Scanner sc=new Scanner(System.in))
        {
            System.out.print("Enter A Number: ");
            int Number=sc.nextInt();
            System.out.print("Sum Of Digits Of "+Number+" Until The Number Is A Single Digit Is "+Sum_Of_Digits(Number));
        }
    }
}