import java.util.Scanner;
class Q2
{
    public static void main(String args[])
    {
        try(Scanner sc=new Scanner(System.in))
        {
            System.out.print("Enter Person Weight In Kg: ");
            float Weight=sc.nextFloat();
            System.out.print("Enter Height Of Person In Meter: ");
            float Height=sc.nextFloat();
            float BMI=Weight/(Height*Height);
            {
                if (BMI<18.5)
                System.out.println("The Person Is Underweight");
                else if (BMI>=18.5 && BMI<=24.9)
                System.out.println("The Person Has Normal Weight");
                else if (BMI>=25.0 && BMI<=29.9)
                System.out.println("The Person Is Over Weight");
                else
                System.out.println("The Person Is OBSE");
            }
        }
    }
}