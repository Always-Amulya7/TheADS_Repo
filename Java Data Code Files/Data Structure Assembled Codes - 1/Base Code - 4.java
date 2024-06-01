//Write a java program that gets three integer numbers from the user. Count from the first number to the second number increments by the 
//third number. Use for loop to do it. Also, display the sum of numbers displayed between the first number and second number.
//Sample run:
//Enter first number: 4 Enter second number: 13 Enter third number: 3 4 7 10 13
//The sum of number displayed is 34

import java.util.Scanner;
class Q1
{
    public static void main(String args[])
    {
        try(Scanner sc=new Scanner(System.in))
        {
            int n1,n2,n3,i,sum=0;
            System.out.print("Enter The Number1:");
            n1=sc.nextInt();
            System.out.print("Enter The Number2:");
            n2=sc.nextInt();
            System.out.print("Enter The Number3:");
            n3=sc.nextInt();
            for(i=n1;i<=n2;i+=n3)
            {
                sum=sum+i;
            }
            System.out.println("Sum:"+sum);
        }
    }
}

//An integer n is divisible by 9 if the sum of its digits is divisible by 9. Use this concept in your program to determine whether or not the 
//number is divisible by 9. Test it on the following numbers: Use while loop.
//n = 123456
//n = 154368
//n = 621594
//Hint: Use the % operator to get each digit; then use / operator to remove the digit.
//Sample run 1:
//Enter a number: 154368
//The number 154368 is divisible by 9.
//Sample run 2:
//Enter a number: 123456
//The number 123456 is not divisible by 9.

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

//Write a java program that takes an integer N from user, uses Math. Random () to print N random integer numbers between 1 to N, and then prints 
//their average value. Use do while loop.
//Sample run:
//Enter a number: 6
//Random numbers generated are: 6 4 5 2 2 5
//Average of 6 random numbers are 4

class Q3
{
    public static void main(String args[])
    {
            int i,rnum=0,avg,sum=0;
            for (i=1;i<=6;i++)
            {
                rnum=((int) ((Math.random()*6)+1));
                sum=sum+rnum;
                System.out.print(rnum+" ");
            }
            avg=sum/6;
            System.out.println("");
            System.out.println("Average:"+avg);
    }
}

//Write a program that finds greatest common divisor (GCD) of two numbers using Euclid's algorithm, which is an iterative computation based on the 
//following observation: if y divides x, the GCD of x and y is y; otherwise, the GCD of x and y is same as GCD of x % y and y.
//Sample run:
//Enter the first number: 56
//Enter the second number: 98
//GCD of 56 and 98 is 14.

import java.util.Scanner;
class Q4
{
    public static void main(String args[])
    {
        try(Scanner sc=new Scanner(System.in))
        {
            int i;
            System.out.println("Enter Two Numbers To Find GCD Of The Numbers:");
            int num1=sc.nextInt();
            int num2=sc.nextInt();
            int rem,gcd=1;
            for (i=1;i<=Math.max(num1,num2);i++)
            {
                if (num2%num1!=0)
                {
                    rem=num2%num1;
                    gcd=num1%rem;
                }
            }
            System.out.println("GCD Of The Numbers Are:"+gcd);
        }
    }
}

//Write a Java program to check if a number is perfect number or not.
//(Hints: A number N is called perfect number, if the sum of factors except N as a factor is equals to the number N.
//Example:
//N = 28 is a perfect number as (1 + 2 + 4 + 7 + 14 = 28.)
//Sample run1:
//Enter a number: 496
//496 is a perfect number.
//Sample run2:
//Enter a number: 490
//490 is not a perfect number.

import java.util.Scanner;
class Q5
{
    public static void main(String[] args)
    {
        try(Scanner sc=new Scanner(System.in))
        {
            System.out.print("Enter A Number:");
            int num=sc.nextInt();
            int sum=0;
            for (int i=1;i<num;i++)
            {
                if (num%i==0)
                {
                    sum=sum+i;
                }
            }
            if (num==sum)
            System.out.println(num+" Is A Perfect Number");
            else
            System.out.println(num+" Is Not A Perfect Number");
        }
    }
}

//Write a java program to enter two numbers through the keyboard. Write a program to find the value of one number raised to the power of another.
//(Do not use Java built-in method).
//Sample run:
//Enter the base: 5
//Enter the power: 4
//5 to the power 4 is: 625

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

//Write a java program to print the multiplication table of a number entered by the user.
//Sample run:
//Enter a no. for which you want to find the multiplication table: 8 
//The multiplication table of 8 is:
//8x1=8 
//8x2=16 
//8x3=24 
//8x4=32 
//8x5=40 
//8x6=48
//8x7=56 
//8x8=64 
//8x9=72 
//8x10=80

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

//Write a program that generates a random integer number between 1 to 10 and asks the user to guess what the number is. 
//If the user's guess is higher than the random number, the program should display "Too high, try again." If the user's guess is lower than 
//the random number, the program should display "Too low, try again." The program should use a loop that repeats until the user correctly guesses
//the random number and display good guess.
//Sample run:
//Computer guess: 7
//User guess: 5
//Too low, try again
//Computer guess: 5
//User guess: 7
//Too high, try again
//Computer guess: 5
//User guess: 5
//Good guess

import java.util.Scanner;
class Q8
{
    public static void main(String[] args)
    {
        try(Scanner sc=new Scanner(System.in))
        {
            while(true)
            {
                int random_number = (int) ((Math.random()*9)+1);
                int guess;
                System.out.print("User Guess:");
                guess=sc.nextInt();
                System.out.println("Computer Guess:"+random_number);
                if(guess>random_number)
                {
                    System.out.println("Too high, try again.");
                }
                else if (guess < random_number)
                {
                    System.out.println("Too low, try again.");
                }
                else if (guess==random_number)
                {
                    System.out.println("Good guess! You got it!");
                    break;
                }
            }
        }
    }
}

//Write a java program to take an integer input from the user and print the input by removing all zeros.
//Example: Input = 10200 then Output = 12.
//Sample run:
//Enter an integer number: 10203040
//After removing 0 from number 10203040, the new number is 1234.

import java.util.Scanner;
class Q9
{
    public static void main(String[] args)
    {
        try(Scanner sc = new Scanner(System.in);)
        {
            String res;
            System.out.print("Enter an integer: ");
            int input = sc.nextInt();
            while (input > 0)
            {
            int digit = input % 10;
            if (digit != 0)
            {
                res=""+digit;
                input /= 10;
                System.out.print(res+"");
            }
            else
            {
                input=input/10;
            }
            }
        }
    }
}

//Write a java program to print largest power of three less than or equal to N.
//Sample run:
//Enter a number: 100
//The largest power of 3 less than or equal to 100 is 81

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

//Write a java program to find the difference between the sum of the squares of the first ten natural numbers and the square of the sum.
//The sum of the squares of the first ten natural numbers is: 12 + 22 + 32 + 42 + 52 + 62 + 72 + 82 + 92 + 102 = 385
//The square of the sum of the first ten natural numbers is: (1 + 2 + ... + 10)2 = 552 = 3025
//Hence the difference between the sum of the squares of the first ten natural numbers and the square of the sum is 3025 − 385 = 2640.

import java.util.Scanner;
class Q11
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

//If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. 
//The sum of these multiples is 23. Write a java program to find the sum of all the multiples of 3 or 5 below 1000.

class Q12
{
    public static void main(String[] args)
    {
        int i,sum=0;
        for (i=1;i<=1000;i++)
        {
            if (i%3==0||i%5==0 )
            sum=sum+i;
        }
        System.out.println("Sum is: "+sum);
    }
}

//Write a java program in which using one for loop and one if statement, prints the integers from 1,000 to 2,000 with five integers per line. 
//Hint: Use the % operation.

class Q13
{
    public static void main(String[] args)
    {
        int i;
        for (i=1000;i<=2000;i++)
        {
            System.out.print(i+" ");
            if ((i+1) % 5 == 0)
            {
                System.out.println();
            }
        }
    }
}

//Write a java program to print the sum of all even numbers and the product of all odd numbers from 1 to N. Where, N is the input to the program.
//For input, N = 10 Sum of all even numbers = 2 + 4 + 6 + 8 + 10 = 30 Product of all odd numbers = 1 * 3 * 5 * 7 * 9 = 945

import java.util.Scanner;
class Q14
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

//Write a java program to print the following output using loop. Where, input is the number of rows in output pattern.
//For input, N = 4. 
//1 
//121 
//1213121 
//121312141213121

import java.util.Scanner;
class Q15
{
    public static void main(String[] args)
    {
        try(Scanner sc=new Scanner(System.in))
        {
            System.out.print("Enter The Range:");
            int i,n,j;
            n=sc.nextInt();
            int count=1;
            for (i = 1; i <= n; i++)
            {
                for (j =1 ; j <= i; j++) 
                {
                    if(j==1)
                    {
                        System.out.print(j);
                    }
                    else
                    {
                        System.out.print(j);
                        System.out.print(count);
                        count++;
                    }
                }
                System.out.println();
            }
        }
    }
}