//Write a java program that reads a Fahrenheit degree in a double value from the console, then converts it to Celsius and displays the result. The formula for the conversion is as follows:
//Celsius = (Fahrenheit-32) *(5/9)
//Hint: Hint: In Java, 5 / 9 is 0, but 5.0 / 9 is 0.556
//Here is a sample run:
//Enter a degree in Fahrenheit: 54
//54 Fahrenheit is 12.22 Celsius

import java.util.Scanner;
class Q1
{
	public static void main(String args[])
	{
		int Fah_value;;
		double Cel_value;
		try (Scanner inp = new Scanner(System.in)) 
		{
			System.out.print("Enter a degree in Fahrenheit: ");
			Fah_value=inp.nextInt();
		}
		Cel_value=(Fah_value-32)*(5.0/9);
		System.out.println(Fah_value+" Fahrenheit is "+Cel_value+" Celsius");
	}
}

//The distance between two cities (in km.) is input through the keyboard. Write a java program to convert and print this distance in meters, feet, inches and centimetres. Hint: 1km=1000meter, 1km=3280.8399feet, 1km= 39370.0787 inch, 1km= 100000 centimetre
//Here is the sample run:
//Enter the distance in km=165
//165 km is 165000 meters 165 km is 541338.5835 feet 165 km is 6496062.9854999995 inch 165 km is 16500000 centimetres

import java.util.Scanner;
class Q2
{
	public static void main(String args[])
	{
		try (Scanner input = new Scanner(System.in)) 
		{
			int kilometre;
			System.out.print("Enter the distance in km=");
			kilometre=input.nextInt();
			System.out.println(kilometre+" km is "+kilometre*1000+" meters");
			System.out.println(kilometre+" km is "+kilometre*3280.8399+" feet");
			System.out.println(kilometre+" km is "+kilometre*39370.0787+" inch");
			System.out.println(kilometre+" km is "+kilometre*100000+" centimetres");
		}
	}
}

//Enter the basic salary of an employee of an organization through the keyboard. His dearness allowance (DA) is 40% of basic salary, and house rent allowance (HRA) 
//is 20% of basic salary. Write a java program to calculate his gross salary. Print the DA, HRA and Gross salary.
//Here is the sample run:
//Enter basic salary: 15600
//DA is 6240.0
//HRA is 3120.0
//Gross salary is 24960

import java.util.Scanner;
class Q3
{
	public static void main(String args[])
	{
		System.out.print("Enter basic salary: ");
		float salary;
		try (Scanner sc = new Scanner(System.in))
		{
			salary=sc.nextFloat();
			System.out.print("Enter His dearness allowance:");
			float da;
			da=sc.nextFloat();
			System.out.print("Enter His house rent allowance:");
			float hra;
			hra=sc.nextFloat();
			float gsal= ((float)salary) + ((float) 0.4*salary) + ((float) 0.2*salary);
			System.out.println("DA is "+da);
			System.out.println("HRA is "+hra);
			System.out.println("Gross Salary is "+(int)gsal);
		}
	}
}

//Write a java program that reads an integer between 0 and 1000 and adds all the digits in the integer. For example, if an integer is 749, the sum of all its digits is 20.
//Hint: Use the % operator to extract digits, and use the / operator to remove the extracted digit.
//For instance, 749 % 10 = 9 and 749 / 10 = 74.
//Here is a sample run:
//Enter a number between 0 and 1000: 999 The sum of the digits is 27

import java.util.Scanner;
class Q4
{
	public static void main(String args[]) 
	{
		int a,b,c,e,d;
		try (Scanner sc = new Scanner(System.in))
		{
			System.out.print("Enter a number between 0 and 1000:");
			int no=sc.nextInt();
			a=no%10;
			b=no/10;
		}
		c=b%10;
		d=b/10;
		e=a+c+d;
		System.out.println("The Sum Of Digits Is "+e);
	}
}

//sum=number%10;
//number/=10;
//sum+=number%10;
//number/=10
//sum+=number%10;

//Write a java program that reads the radius of a hemisphere and computes the surface area and volume using the following formulas: Surface Area of Hemisphere = 
//3 π r2. Volume of a hemisphere = (2/3)πr3 Where π is a constant whose value is equal to 3.14 approximately. “r” is the radius of the hemisphere. Hint: Use Math.PI.
//Here is a sample run: Enter the radius of the hemisphere: 7.0 The surface area of the hemisphere is 461.814 The volume area of the hemisphere is 718.377

import java.util.Scanner;
class Q5
{
	public static void main(String args[])
	{
		try (Scanner Sc = new Scanner(System.in)) 
		{
			System.out.print("Enter the radius of the hemisphere:");
			double r;
			r=Sc.nextDouble();
			double area=3*Math.PI*r*r;
			double volume=(2.0/3)*Math.PI*r*r*r;
			System.out.println("The surface area of the hemisphere is "+(float) area);
			System.out.println("The volume of the hemisphere is "+(float) volume);
		}
	}
}

//When a brick is dropped from a tower, it falls faster and faster until it hits the earth. The distance it travels is given by d = (1/2) gt2 Here d is in feet, t is 
//the time in seconds, and g is 32.174. Write a program that asks the user for the number of seconds and then prints out the distance travelled.
//Here is the sample run: Enter the number of seconds: 5.4 Distance travelled: 469.096

import java.util.Scanner;
class Q6
{
	public static void main(String args[])
	{
		try (Scanner sc = new Scanner(System.in)) 
		{
			System.out.print("Enter the number of seconds:");
			double t,g;
			g=32.174;
			t=sc.nextDouble();
			double d=(1.0/2)*g*Math.pow(t,2);
			System.out.println("Distance travelled:"+d);
		}
	}
}

//Write a java program that displays the following table. Cast floating-point numbers into integers.
//a b pow(a, b)
//1 2 1
//2 3 8
//3 4 81
//4 5 1024
//5 6 15625

class Q7
{
	public static void main(String args[])
	{
		System.out.println("a"+"\t"+"b"+"\t"+"pow(a, b)");
		System.out.println(1+"\t"+2+"\t"+(int)Math.pow(1,2));
		System.out.println(2+"\t"+3+"\t"+(int)Math.pow(2,3));
		System.out.println(3+"\t"+4+"\t"+(int)Math.pow(3,4));
		System.out.println(4+"\t"+5+"\t"+(int)Math.pow(4,5));
		System.out.println(5+"\t"+6+"\t"+(int)Math.pow(5,6));
	}
}

//Using Math Function

class Q7
{
	public static void main(String args[])
	{
		System.out.println("a"+'\t'+"b"+'\t'+"pow(a, b)");
		int b=2;
		for (int a=1;a<=5;a++)
		{
			System.out.println(a+"\t"+b+"\t"+(int)Math.pow(a, b));
			b++;
		}
	}
}

//Write a java program that prompts the user to enter the minutes (e.g., 1 billion), and displays the number of years and days for the minutes.
//For simplicity, assume a year has 365 days.
//Here is a sample run:
//Enter the number of minutes: 1000000000
//1000000000 minutes is approximately 1902 years and 214 days.

import java.util.Scanner;
class Q8
{
    public static void  main(String args[])
    {
        try(Scanner sc=new Scanner(System.in))
        {
            System.out.print("Enter The Number Of Minutes:");
            int Minutes=sc.nextInt();
            System.out.println(Minutes+" minutes is approximately "+(int)Minutes/(60*24*365)+" Years and "+(int)Minutes % (60*24*365)/1440+" days");
        }
    }
}

//If you have N eggs, then you have N/12 dozen eggs, with N%12 eggs left over. (This is essentially the definition of the / and % operators for integers.) 
//Write a java program that asks the user how many eggs she has and then tells the user how many dozen eggs she has and how many extra eggs are left over. 
//A gross of eggs is equal to 144 eggs. Extend your program so that it will tell the user how many gross, how many dozen, and how many left over eggs she has. 
//For example, if the user says that she has 1342 eggs, and then your program would respond with Your number of eggs is 9 gross, 3 dozen, and 10.

import java.util.Scanner;
class Q9
{
	public static void main(String[] args) 
    {
        try (Scanner input = new Scanner(System.in))
        {
            System.out.print("Enter the number of eggs: ");
            int eggs = input.nextInt();
            int gross = eggs / 144;
            int dozens = (eggs % 144) / 12;
            int remainingEggs = eggs % 12;
            System.out.println("Your number of eggs is " + gross + " gross, " + dozens + " dozens, and " + remainingEggs + " left over.");
        }
    }
}

//Write a java program that prompts the user to enter three points (x1, y1), (x2, y2), (x3, y3) of a triangle and displays its area. The formula for computing the 
//area of a triangle is
//s = (side1 + side2 + side3)/2;
//area=√𝑠∗(𝑠−𝑎)∗(𝑠−𝑏)∗(𝑠−𝑐)
//Here is a sample run:
//Enter three points for a triangle: 1.5 -3.4 4.6 5 9.5 -3.4
//The area of the triangle is 33.6

import java.util.Scanner;
class QX
{
    public static void main(String args[])
    {
        try(Scanner sc=new Scanner(System.in))
        {
            System.out.println("Enter Points1:");
            double x1=sc.nextDouble();
            double y1=sc.nextDouble();
            System.out.println("Enter Points2:");
            double x2=sc.nextDouble();
            double y2=sc.nextDouble();
            System.out.println("Enter Points3:");
            double x3=sc.nextDouble();
            double y3=sc.nextDouble();
            double a = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
            double b = Math.sqrt(Math.pow(x3 - x2, 2) + Math.pow(y3 - y2, 2));
            double c = Math.sqrt(Math.pow(x1 - x3, 2) + Math.pow(y1 - y3, 2));
            double s=(a+b+c)/2;
            double area=Math.sqrt(s*(s-a)*(s-b)*(s-c));
            System.out.println("Area Of The Triangle is "+area);
        }
    }
}

//Command Line Argument Use---->

//Write a java program that takes two int values from the command line as dividend and divisor and print the quotient and remainder.

class Q1
{
    public static void main(String args[])
    {
        System.out.println("The Shit Will Be Done: ");
        int X=Integer.parseInt(args[0]);
        int Y=Integer.parseInt(args[1]);
        System.out.println("The Quotient Is:"+X/Y);
        System.out.println("The Remainder Is:"+X%Y);
    }
}

//Write a java program that takes two positive integers from command-line arguments and prints the result of first number raise to the power of second number.

class Q2
{
    public static void main(String args[])
    {
        System.out.println("The Shit Will Be Done More Properly: ");
        int X=Integer.parseInt(args[0]);
        int Y=Integer.parseInt(args[1]);
        System.out.println("The Result Is: "+(int)Math.pow(X,Y));
    }
}

//Write a java program that prints the sum of two random integers between 1 and 6 (such as you might get when rolling dice)

class Q3
{
    public static void main(String args[])
    {
        System.out.println("The Shit Will Be Done More Properly: ");
        int X=(int)(Math.random()*6+1);
        int Y=(int)(Math.random()*6+1);
        System.out.println(X+" "+Y);
        System.out.println("The Result Is: "+(X+Y));
    }
}

//Write a java program that takes a double value t from the command line and prints the value of cos (5t) + sin (7t). Use Math.cos() and math.sin()

class Q4
{
    public static void main(String args[])
    {
        System.out.println("The Shit Will Be Done More Properly: ");
        double t=Double.parseDouble(args[0]);
        double X=(Math.sin(5*t));
        double Y=(Math.cos(7*t));
        System.out.println(X+" "+Y);
        System.out.println("The Result Is: "+(Y+X));
    }
}

//Write a java program that takes three int values from the command line and prints them in ascending order. Use Math.min() and Math.max().

class Q5
{
    public static void main(String args[])
    {
        System.out.println("The Shit Will Be Done More More Properly: ");
        System.out.println("Enter The Values: ");
        int X=Integer.parseInt(args[0]);
        int Y=Integer.parseInt(args[1]);
        int Z=Integer.parseInt(args[2]);
        int Max=Math.max(Math.max(X,Y),Z);
        int Min=Math.min(Math.min(X,Y),Z);
        System.out.println("Maximum Value Is: "+Max);
        System.out.println("Middle Value Is: "+(X+Y+Z-Max-Min));
        System.out.println("Minimum Value Is: "+Min);
    }
}

//Write a java program to input a character from command line and display the ASCII value of the entered character.

class Q6
{
    public static void main(String args[])
    {
        System.out.println("The Shit Will Be Done More More More Properly: ");
        System.out.println("Enter The Value: ");
        char ch = args[0].charAt(0); 
        System.out.println("The ASCII Value The Letter Is: "+(int)ch);
    }
}

//Write a java program that takes three positive integers from command-line arguments and prints true if any one of them is less than or equal to the product of 
//the other two and false otherwise.

class Q7
{
    public static void main(String args[])
    {
        System.out.println("The Shit Will Be Done More More Properly: ");
        System.out.println("Enter The Values: ");
        int X=Integer.parseInt(args[0]);
        int Y=Integer.parseInt(args[1]);
        int Z=Integer.parseInt(args[2]);
        if (X<=Y*Z || Y<=X*Z || Z<=X*Y)
        System.out.println(true);
        else
        System.err.println(false);
    }
}

//Write a java program to take three inputs from command line argument as principle, rate and time. Find Simple interest.

class Q8
{
    public static void main(String args[])
    {
        System.out.println("The Shit Will Be Done More More Properly: ");
        System.out.println("Enter The Values: ");
        double P=Double.parseDouble(args[0]);
        double R=Double.parseDouble(args[1]);
        double T=Double.parseDouble(args[2]);
        System.out.println("The Simple Interest Is: "+(P*R*T)/100);
    }
}

//The surface area of a cylinder can be defined as A= πr2+2πrh, where r and h are the radius height of the cylinder respectively. Write a java program to find 
//the area where r and h are inputted from command line argument. Hint: Use Math.PI.

class Q9
{
    public static void main(String args[])
    {
        System.out.println("The Shit Will Be Done More More Properly: ");
        System.out.println("Enter The Values: ");
        double R=Double.parseDouble(args[1]);
        double H=Double.parseDouble(args[2]);
        System.out.println("The Surface Area Is: "+(Math.PI*Math.pow(R,2)+2*Math.PI*R*H));
    }
}

//Write a java program to input a four-digit number from command line argument and find sum of the first and last digit of the number.

class Demo
{
    public static void main(String args[])
    {
        System.out.println("Kya Zindagi Ho Gayi Hai");
        int Number=Integer.parseInt(args[0]);
        String Value=args[1];
        System.out.println("Haan Yeh Kar Lo Pahle "+Value);
        int EndDigit=Number%10;
        Number=Number/10;
        Number=Number/10;
        Number=Number/10;
        int FirstDigit=Number%10;
        System.out.println("The Sum Will Be: "+(EndDigit+FirstDigit));
        System.out.println("7: Thala For A Reason");
    }
}