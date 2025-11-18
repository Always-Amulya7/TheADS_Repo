//Write a program that reads three integers from the user and prints "Increasing" if the numbers are in increasing order, "Decreasing" 
//if the numbers are in decreasing order, and "Neither increasing nor decreasing order" otherwise.

//Here is sample run:

//Input first number: 241
//Input second number:345
//Input third number: 4563
//“Increasing”

//Input first number: 345
//Input second number:145
//Input third number: 563
//“Neither Increasing nor decreasing”

//Input first number: 45
//Input second number:14
//Input third number: 3
//“Decreasing”

import java.util.Scanner;
class Q3 
{
    public static void main(String[] args)
    {
        try (Scanner sc = new Scanner(System.in))
        {
            System.out.print("Enter the first integer: ");
            int a = sc.nextInt();
            System.out.print("Enter the second integer: ");
            int b = sc.nextInt();
            System.out.print("Enter the third integer: ");
            int c = sc.nextInt();
            String order;
            if (a < b && b < c)
            {
                order = "\"Increasing\"";
            } 
            else if (a > b && b > c) 
            {
                order = "\"Decreasing\"";
            } 
            else 
            {
                order = "\"Neither increasing nor decreasing order\"";
            }

            System.out.println(order);
        }
    }
}
