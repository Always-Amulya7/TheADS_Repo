//Write a program to input the age of a person and check if the age of the person is greater than or equal to 18 then print the message:
//“You are eligible to cast your vote”.

import java.util.Scanner;
class Q1
{
	public static void main(String args[])
	{
		try (Scanner sc = new Scanner(System.in))
		{
			int age;
			System.out.print("Enter Your Age:");
			age=sc.nextInt();
			if (age>=18)
				System.out.println("\"You are eligible to cast your vote\"");
		}
	}
}

//Alice visited SUM hospital to get treatment for her fever and illness. Doctor advised her to drink at least 5000 ml of water each day.
// Alice drank x ml of water today. Write a program that print the following message depending on the value of x.
//“Yes, Alice is following doctor’s advice”
//                 OR
//“No, Alice is not following doctor’s advice”

import java.util.Scanner;
class Q2
{
	public static void main(String args[])
	{
		try (Scanner sc = new Scanner(System.in))
		{
			int WaterLevel;
			System.out.print("Enter Level Of Water Consumed:");
			WaterLevel=sc.nextInt();
			if (WaterLevel>=5000)
				System.out.println("\"Yes, Alice is following doctor’s advice\"");
			else
				System.out.println("\"No, Alice is following doctor’s advice\"");
		}
	}
}

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


//Make a simple game involving a computer and a user. The computer first guesses a number between 1 and 9 inclusive, then ask the user 
//to enter a number between 1 and 9 inclusive. If the user guess is correct then display “You got it right”, if the guess is close (+1, -1) 
//“Almost got it “, Otherwise “You got it wrong”.
//Here are some sample runs.

//Enter user number: 2
//Computer guesses: 3
///“Almost got it”

//Enter user number: 4
//Computer guesses: 4
//“You got it right”

//Enter user number: 1
//Computer guesses: 5
//“You got it wrong”

import java.util.Scanner;
class Q4
{
	public static void main(String args[]) 
	{
        int cinp= (int) (Math.random()*9+1);
        try (Scanner sc = new Scanner(System.in))
        {
            System.out.print("Enter user number: ");
            int yinp= sc.nextInt();
            System.out.println("Computer guessses: "+cinp);
            if (yinp==cinp) 
            	System.out.println("You got it right!"); 
            else if (yinp+1==cinp)
                System.out.println("Almost got it");
            else if (yinp-1==cinp)
            	System.out.println("You got it wrong");
            else
                System.out.print("");
        }
	}
}

//Write a Java program that takes a year from user and print true if that year is a leap year otherwise print false.

//Here is a sample run:

//Input the year: 2016
//2016 is a leap year: true

//Input the year: 2008
//2008 is a leap0 year: false

//Input the year: 1900
//1900 is a leap year: false

import java.util.Scanner;
class Q5
{
	public static void main(String args[])
	{
		try (Scanner sc = new Scanner(System.in))
		{
			int year;
			System.out.print("Enter The Year:");
			year=sc.nextInt();
			if ((year%4==0 || year%100==0)||(year%400==0))
			{
				System.out.println(year+" is a leap year:"+true);
			}
			else
			{
				System.out.println(year+" is a leap year:"+false);
			}
		}
	}
}

//Write a java program to calculate the monthly electricity bill. The tariff is given as follows:
//Price per unit          Unit range
//Rs. 3/-               First 50 units
//Rs. 4.80/-            50-200 units
//Rs. 5.80/-            200-400 units
//Rs. 6.20/-            Above 400 units

import java.util.Scanner;
class Q6
{
	public static void main(String args[])
	{
		try(Scanner sc = new Scanner (System.in))
		{
			System.out.print("Enter the unit of electricity used:");
		double unit = sc.nextDouble();
		if (unit <= 50) 
		{
			System.out.print("Amount:"+(unit*3.0));
		} 
		else if (unit <=200)
		{
			System.out.print("Amount:"+((50*3.0)+(unit-50)*4.8));
		} 
		else if (unit <=400)
		{
			System.out.print("Amount:"+((200*4.8)+(unit-200)*5.8)); 
		}
		else if (unit>=401)
		{
			System.out.print("Amount:"+((400*5.8)+(unit-400)*6.2));
		}
		}
		
	}
}

//From the above question no. (6) write a java program with a 
//choice if the consumer wants to pay bill online. Consumer who pays 
//their electricity bill online will get a discount of 3%.

//Here is the sample output:
///No. of units consumed: 867
//Do you want to pay online(y/n): y
//Total amount: 4925.4
//Discount: 147.762
//Amount payable: 4777.638

import java.util.*;
public class Q7
{
public static void main(String[] args)
{
try(Scanner sc = new Scanner (System.in))
{
	System.out.println("Enter the unit: ");
    int unit = sc.nextInt();
    System.out.println("Do you want to pay online(y/n):");
    char c = sc.next().charAt(0);
    System.out.println("No. of units consumed: "+unit);
    double amount= 0;
    double discount = 0.0;
    if (unit <=50)
    {
        amount= unit *3;
    }
    else if (unit <=200)
    {
       amount=50*3+(unit -50)*4.80;
    }
    else if(unit <=400)
    {
       amount=50*3+150*4.80+(unit -200)*5.80;
    }
    else
    {
       amount=50*3+150*4.80+200*5.80+(unit -400)*6.20;
    }
    if (c=='y')
    {
       discount = amount*0.03;
    }
    System.out.println("Total amount is "+amount);
    System.out.println("Discount:"+discount);
    System.out.println("Amount payable: "+(amount-discount));
}
}
}

//Write a java program that takes the x – y coordinates of a
// point in the Cartesian plane and prints a message telling 
//either an axis on which the point lies or the quadrant in which it 
//is found.

//Here is the sample output:
//(-1.0, -2.5) is in quadrant III
//(0.0, 4.8) is on the y-axis

import java.util.Scanner;
class Q8
{
	public static void main(String args[])
	{
		try (Scanner sc = new Scanner(System.in))
		{
			System.out.println("Enter The Coordinates For X And Y:");
			double x,y;
			x=sc.nextDouble();
			y=sc.nextDouble();
			if (x>0 && y>0)
			System.out.println("("+x+","+y+") is in quadrant I");
			else if (x<0 && y>0)
			System.out.println("("+x+","+y+") is in quadrant II");
			else if (x<0 && y<0)
			System.out.println("("+x+","+y+") is in quadrant III");
			else if (x>0 && y<0)
			System.out.println("("+x+","+y+") is in quadrant IV");
			else if (x==0 && y==0)
			System.out.println("("+x+","+y+")"+" is at the origin");
			else if (x==0)
			System.out.println("("+x+","+y+") is at the Y-Axis");
			else
			System.out.println("("+x+","+y+") is at the X-Axis");
		}
	}
}

//Write a program to input 3 integer number a, b, c. Find the largest number among 3. Also find the 2nd largest number among 3. 

//Here is the sample output:
//Enter the value of a, b, c:10 30 50
//Largest number: 50
//2nd largest number: 30

import java.util.Scanner;
class Q9
{
	public static void main(String args[])
	{
		try(Scanner sc=new Scanner(System.in))
		{
		System.out.print("Enter the value of a, b, c:");
		int a,b,c ,largest,secondLargest;
		a=sc.nextInt();
		b=sc.nextInt();
		c=sc.nextInt();
		largest=Math.max(Math.max(a, b), c);
		if (a != largest && b != largest)
		{
           secondLargest = Math.max(a, b); // Find the second largest number
        } 
		else if (a != largest && c != largest) 
		{
            secondLargest = Math.max(a, c);
        } 
		else 
		{
            secondLargest = Math.max(b, c);
        }
		System.out.println("Largest number: "+largest);
		System.out.println("2nd Largest number: "+secondLargest);
		}
	}
}

//A University conducts a 100-mark exam for its student and grades them as follows. Assigns a grade based on the value of the marks. 
//Write a java program to print the grade according to the mark secured by the student. [Use switch-case].
//Mark Range    Letter Grade
//>=90                O
//>=80 AND <90        A
//>=70 AND <80        B
//>=60 AND <70        C
//>=50 AND <60        D
//>=50 AND <40        E 
//<40                 F

import java.util.Scanner;
class QX 
{
    public static void main(String[] args) 
    {
        try (Scanner sc = new Scanner(System.in))
        {
            System.out.print("Enter the student's mark: ");
            int mark = sc.nextInt();
            String grade;
            switch (mark / 10) 
            {
                case 10:case 9:grade = "O";
                               break;
                case 8:grade = "A";
                               break;
                case 7:grade = "B";
                               break;
                case 6:grade = "C";
                               break;
                case 5:grade = "D";
                               break;
                default:grade = "F";
            }

            System.out.println("The student's grade is: " + grade);
        }
    }
}

//Write a java program that plays the popular scissor-rock-paper game. (A scissor can cut a paper, a rock can knock a scissor, and a paper can wrap a rock.) The program randomly generates a number 0, 1, or 2 representing scissor, rock, and paper. The program prompts the user to enter a number 0, 1, or 2 and displays a message indicating whether the user or the computer wins, loses, or draws.
//Here are sample runs:
//scissor (0), rock (1), paper (2): 1
//The computer is scissor. You are rock. You won
//scissor (0), rock (1), paper (2): 2
//The computer is paper. You are paper too. It is a draw

import java.util.Scanner;
class Q11
{
	public static void main(String args[])
	{
		try (Scanner sc = new Scanner(System.in))
		 {
			System.out.print("Scissor (0), Rock (1), Paper (2):");
			int ch,cch;
			String nm="",nnm="";
			ch=sc.nextInt();
			cch=(int) (Math.random()*2);
			switch ((int)ch)
			{
			case 0:nm="Scissor";
			break;
			case 1:nm="Rock";
			break;
			case 2:nm="Paper";
			break;
			}
			switch ((int)cch)
			{
			case 0:nnm="Scissor";
			break;
			case 1:nnm="Rock";
			break;
			case 2:nnm="Paper";
			break;
			}
			if (cch==ch)
			{
				System.out.println("The computer is "+nnm+". You are "+nm+". It's A Draw");
			}
			else if (ch>cch)
			{
				System.out.println("The computer is "+nnm+". You are "+nm+". You Won");
			}
			else
			{
				System.out.println("The computer is "+nnm+". You are "+nm+". You Lost");
			}
		}
	}
}

/*switch ((int)ch)
		{
		case 0:nm="Scissor";
		break;
		case 1:nm="Rock";
		break;
		case 2:nm="Paper";
		break;
		}
		switch ((int)cch)
		{
		case 0:nnm="Scissor";
		break;
		case 1:nnm="Rock";
		break;
		case 2:nnm="Paper";
		break;*/

//Write a java program that prompts the user to enter an integer for today’s day of the week (Sunday is 0, Monday is 1… and Saturday is 6). 
//Also prompt the user to enter the number of days after today for a future day and display the future day of the week.
//Here is a sample run:
//Enter today's day: 1
//Enter the number of days elapsed since today: 3
//Today is Monday and the future day is Thursday
//Enter today's day: 0 Enter the number of days elapsed since today: 31
//Today is Sunday and the future day is Wednesday


import java.util.Scanner;
class Q12 
{
    public static void main(String[] args)
    {
        try (Scanner sc = new Scanner(System.in)) 
        {
            System.out.print("Enter today's day:");
            int today = sc.nextInt();
            System.out.print("Enter the number of days elapsed since today:");
            int daysAfter = sc.nextInt();
            int futureDay = (today + daysAfter) % 7;
            String futureDayName="",Dname="";
            if (today==1)
            	Dname="Monday";
            else if (today==2)
            	Dname="Tuesday";
            else if (today==3)
            	Dname="Wednesday";
            else if (today==4)
            	Dname="Thursday";
            else if (today==5)
            	Dname="Friday";
            else if (today==6)
            	Dname="Saturday";
            else if (today==0)
            	Dname="Sunday";
            switch (futureDay) 
            {
                case 0:
                    futureDayName = "Sunday";
                    break;
                case 1:
                    futureDayName = "Monday";
                    break;
                case 2:
                    futureDayName = "Tuesday";
                    break;
                case 3:
                    futureDayName = "Wednesday";
                    break;
                case 4:
                    futureDayName = "Thursday";
                    break;
                case 5:
                    futureDayName = "Friday";
                    break;
                case 6:
                    futureDayName = "Saturday";
                    break;
            }
            System.out.println("Today is "+Dname+" and the future day is "+futureDayName);
        }
    }
}

//Write a java program that randomly generates an integer between 1 and 12 and displays the English month name January, February… December 
//for the number 1, 2… 12, accordingly.

class Q13
{
	public static void main(String args[])
	{
		{
			int monthno=(int) (Math.random()*12+1);
			switch(monthno)
			{
			case 1:System.out.println("The Month is January");
			break;
			case 2:System.out.println("The Month is February");
			break;
			case 3:System.out.println("The Month is March");
			break;
			case 4:System.out.println("The Month is April");
			break;
			case 5:System.out.println("The Month is May");
			break;
			case 6:System.out.println("The Month is June");
			break;
			case 7:System.out.println("The Month is July");
			break;
			case 8:System.out.println("The Month is August");
			break;
			case 9:System.out.println("The Month is September");
			break;
			case 10:System.out.println("The Month is October");
			break;
			case 11:System.out.println("The Month is November");
			break;
			case 12:System.out.println("The Month is December");
			break;
			}
		}
	}
}

//Write a java program that prompts the user to enter an integer and determines whether it is divisible by 5 and 6, whether it is divisible by 5 
//or 6, and whether it is divisible by 5 or 6, but not both.
//Here is a sample run of this program:
//Enter an integer: 10
//Is 10 divisible by 5 and 6? false
//Is 10 divisible by 5 or 6? true
//Is 10 divisible by 5 or 6, but not both? True

import java.util.Scanner;
class Q14
{
	public static void main(String args[])
	{
		try (Scanner sc = new Scanner(System.in))
		{
			int num;
			System.out.print("Enter An Integer:");
			num=sc.nextInt();
			if (num%5==0 && num%6==0)
			{
				System.out.println("Is "+num+" divisible by 5 and 6? True");
			}
			else
			{
				System.out.println("Is "+num+" divisible by 5 and 6? False");
			}
			if (num%5==0 || num%6==0)
			{
				System.out.println("Is "+num+" divisible by 5 or 6? True");
			}
			else
			{
				System.out.println("Is "+num+" divisible by 5 or 6? False");
			}
			if ((num%5==0||num%6==0) && (num%5!=0||num%6!=0))
			{
				System.out.println("Is "+num+" divisible by 5 or 6, but not both? True");
			}
			else
			{
				System.out.println("Is "+num+" divisible by 5 or 6, but not both? False");
			}
		}
	}
}

//Write a java program which displays an appropriate name for a person, using a combination of nested ifs and compound conditions. 
//Ask the user for a gender, first name, last name and age. If the person is female and 20 or over, ask if she is married. If so, display "Mrs." 
//in front of her name. If not, display "Ms." in front of her name. If the female is under 20, display her first and last name. 
//If the person is male and 20 or over, display "Mr." in front of his name. Otherwise, display his first and last name. Note that asking a person 
//if they are married should only be done if they are female and 20 or older, which means you will have a single if and else nested inside one of
// your if statements. Also, did you know that with an if statements (or else), the curly braces are optional when there is only one statement 
//inside?

//What is your gender (M or F): F
//First name: Gita
//Last name: Pattanayak
//Age: 32
//Are you married, Gita (y or n)? y
//Then I shall call you Mrs. Gita Pattanayak.
//What is your gender (M or F): F
//First name: Anjali
//Last name: Mishra
//Age: 48
//Are you married, Anjali (y or n)? n
//Then I shall call you Ms. Anjali.
//What is your gender (M or F): M
//First name: Ashok
//Last name: Mohanty
//Age: 23
//Then I shall call you Mr. Ashok.
//What is your gender (M or F): M
//First name: Rahul
//Last name: Pati
//Age: 15
//Then I shall call you Rahul Pati

import java.util.Scanner;
class Q15
{
	public static void main(String args[])
	{
		try (Scanner sc = new Scanner(System.in))
		{
			String gen,fname,lname;
			int age;
			char g;
			System.out.print("What is your gender (M or F): ");
			gen=sc.next();
			g=gen.charAt(0);
			if (g=='M')
			{
				System.out.print("First name: ");
				fname=sc.next();
				System.out.print("Last name: ");
				lname=sc.next();
				System.out.print("Age: ");
				age=sc.nextInt();
				if (age>=20)
				{
					System.out.print("Then I Shall Call You Mr."+fname);
				}
				else
				{
					System.out.print("Then I Shall Call You "+fname+" "+lname);
				}
			}
			else if (g=='F')
			{
				System.out.print("First name: ");
				fname=sc.next();
				System.out.print("Last name: ");
				lname=sc.next();
				System.out.print("Age: ");
				age=sc.nextInt();
				if (age>=20)
				{
					System.out.print("Then I Shall Call You Mrs."+fname);
				}
				else
				{
					System.out.print("Then I Shall Call You "+fname+" "+lname);
				}
			}
			else
			{
				System.out.print("Invalid");
			}
		}
	}
}


/*switch(gen)
{
case "M":
System.out.print("First name: ");
fname=sc.next();
System.out.print("Last name: ");
lname=sc.next();
System.out.print("Age: ");
age=sc.nextInt();
if (age>=20)
	System.out.print("Then I Shall Call You Mr."+fname);
else
	System.out.print("Then I Shall Call You "+fname+" "+lname);
break;
case "F":
System.out.print("First name: ");
fname=sc.next();
System.out.print("Last name: ");
lname=sc.next();
System.out.print("Age: ");
age=sc.nextInt();
if (age>=20)
	System.out.print("Then I Shall Call You Mrs."+fname);
else
	System.out.print("Then I Shall Call You "+fname+" "+lname);
break;*/