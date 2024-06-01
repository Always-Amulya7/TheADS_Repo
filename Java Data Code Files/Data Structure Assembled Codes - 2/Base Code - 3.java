//Write a Java program to read your lucky number from keyboard. Treat –ve no. as
//NumberFormatException. Write appropriate Exceptional handler.

import java.util.*;
import java.lang.*;
class Q1
{
    public static void main(String args[])
    {
        try(Scanner Sc=new Scanner(System.in))
        {
            System.out.print("Enter Your Lucky Number: ");
            int Number=Sc.nextInt();
            try
            {
                if (Number>0)
                System.out.println("Thala For A Reason: "+Number);
                else
                throw new NumberFormatException();
            }
            catch (NumberFormatException e)
            {
                System.out.println("Thik Se Input Kar");
            }
        }
    }
}

//Assign your favorite colors in an array. Identify 2 exceptions that may be generated & write
//exceptional handler in Java.

import java.util.*;
import java.lang.*;
class Q2
{
    public static void main(String args[])
    {
        try (Scanner Sc = new Scanner(System.in))
        {
            int[] Arr = { 1, 2, 3, 4, 0 };
            int[] Arr1 = null;
            try
            {
                System.out.println(Arr[2] / 0);
            }
            catch (Exception e) //ArithmeticException
            {
                System.out.println("Arithmetic Exception");
            }
            try
            {
                System.out.println(Arr1[5] + "");
            }
            catch (Exception e) //NullPointerException
            {
                System.out.println("Null Pointer Exception");
            }
            try
            {
                System.out.println(Arr[5]);
            }
            catch (Exception e) //ArrayIndexOutOfBoundsException
            {
                System.out.println("Out Of Bounds Exception");
            }
        }
    }
}

//Create a class Student & enter mark, name of the student. If mark is more than 100, create exception MarksOutOfBoundException & throw it using Java.

import java.util.*;
import java.lang.*;
class Q3
{
    public static void main(String args[])
    {
        try(Scanner Sc=new Scanner(System.in))
        {
            System.out.print("Enter The Marks: ");
            int Marks=Sc.nextInt();
            try
            {
                if (Marks<=100)
                System.out.print("The Marks Entered Was: "+Marks);
                else
                throw new MarksExceptionError("Thik Se Input Karo Bey");
            }
            catch(MarksExceptionError e)
            {
                System.out.println(e.getMessage());
            }
        }
    }
}
class MarksExceptionError extends Exception
{
    MarksExceptionError(String Message)
    {
        super(Message);
    }
}

//Write a simple main class in Java that contains an experiment that uses the generic Box<T> class to build boxes with different types and that verifies that this class
//works as advertised. Your experiment should include the following:
// Create a boxed String object and two variables that refer to that box. Change the contents of one and determine the effect on the other.
// Create a boxed Integer object and two variables that refer to that box. Change the contents of one and determine the effect on the other.
// Create a boxed Object object and two variables that refer to that box. Determine what happens if you put a string in the box. Determine what happens if you put an 
//integer inthe box.

class Box<T>
{
    T Store;
    Box(T Store)
    {
        this.Store=Store;
    }
    void SetVar(T Store)
    {
        this.Store=Store;
    }
    T GetVar()
    {
        return Store;
    }
}
public class Q4
{
    public static void main(String args[])
    {
        Box<String> Var1=new Box<>(null);
		Box<String> Var2=new Box<>(null);
        Var1.SetVar("Pahla Value");
        Var2.SetVar("Dusra Value");
        System.out.println("First Set Of Data: ");
        System.out.println(Var1.GetVar());
        System.out.println(Var2.GetVar());
        Box<Integer> Var3=new Box<>(null);
        Box<Integer> Var4=new Box<>(null);
        Var3.SetVar(10);
        Var4.SetVar(7);
        System.out.println("Second Set Of Data: ");
        System.out.println(Var3.GetVar());
        System.out.println(Var4.GetVar());
        Box<Object> Var5=new Box<>(null);
        Box<Object> Var6=new Box<>(null);
        Var5.SetVar("Saab Thik Hai Naa?");
        Var6.SetVar((double) 15);
        System.out.println("Third Set Of Data: ");
        System.out.println(Var5.GetVar());
        System.out.println(Var6.GetVar());
    }
}

//Write a java program to print an array of different type using a single Generic method. The signature of printArray method is given below.
//public static < E > void printArray( E[] inputArray)

import java.util.*;
import java.lang.*;
class Q5
{
    public static <E> void printArray(E[] inputArray)
    {
        System.out.print("The Array To be Printed Is: ");
        for (E Elements: inputArray)
        {
            System.out.print(Elements+" ");
        }
    }
    public static void main(String args[])
    {
        Scanner Sc=new Scanner(System.in);
        System.out.print("Enter The Size Of The Array: ");
        int Number=Sc.nextInt();
        Integer Arr1[]=new Integer[Number];
        for(int i=0; i<Number; i++)
		{
			System.out.print("Enter For Postion Number "+i+" :");
			Arr1[i]=Sc.nextInt();
		}
		Q5.<Integer>printArray(Arr1);
        System.err.println();
        Double Arr2[]=new Double[Number];
        for(int i=0; i<Number; i++)
		{
			System.out.print("Enter For Postion Number "+i+" :");
			Arr2[i]=Sc.nextDouble();
		}
		Q5.<Double>printArray(Arr2);
    }
}

//Write a java method using Generics to count the occurrence of an element in an array of any type. The signature of count method is given below.
//public static <T> int count(T[] array, T item)

import java.util.*;
class Q6
{
	public static void main(String args[])
	{
		Scanner Sc=new Scanner(System.in);
		System.out.print("Enter The Size Of The Array: ");
		int Number=Sc.nextInt();
		Integer Store1[]=new Integer[Number];
		Double  Store2[]=new Double[Number];
		System.out.println("Enter The Integer Array: ");
		for (int i=0;i<Number;i++)
		{
			System.out.print("Enter The Number At "+(i+1)+" : ");
			Store1[i]=Sc.nextInt();
		}
		System.out.println("Enter The Double Array : ");
		for (int i=0;i<Number;i++)
		{
			System.out.print("Enter The Number At "+(i+1)+" : ");
			Store2[i]=Sc.nextDouble();
		}
		System.out.println("The Integer Array Is: ");
		for (int Element: Store1)
		{
			System.out.print(Element+" ");
		}
		System.out.println("\nThe Double Array Is: ");
		for (double Element: Store2)
		{
			System.out.print(Element+" ");
		}
		System.out.print("\nEnter The Element To Be Searched For 1: ");
		int Search1=Sc.nextInt();
		System.out.print("Enter The Element To Be Searched For 2: ");
		double Search2=Sc.nextDouble();
		System.out.println("The Result For The Array1 Is: "+Q6.<Integer>count(Store1, Search1));
		System.out.println("The Result For The Array2 Is: "+Q6.<Double>count(Store2, Search2));
	}
	public static <T> int count(T[] array, T item)
	{
		int count=0;
		for (int i = 0; i < array.length; i++)
		{
			if (item.equals(array[i]))
			{
				count=i;
			}
		}
		return count;
	  }
	  
}

//Write a recursive method in Java that computes the factorial of a given integer.

import java.util.*;
public class Q7 
{
	public static void main(String args[])
	{
		Scanner Sc = new Scanner(System.in);
		System.out.print("Enter The Number To Determine The Factorial Of: ");
		int  Number=Sc.nextInt();
		long Fact=Factorial(Number);
		System.out.println("Factorial= "+Fact);
	}
	public static long Factorial(long Number)
	{
		if(Number<=1)
			return 1;
		else
			return Number*Factorial(Number-1);
	}
}

//Write a recursive method in Java which, given real value x and a positive integer n, returns the value of x^n.

import java.util.*;
class Q8
{
    public static void main(String[] args)
    {
        try(Scanner Sc=new Scanner(System.in))
        {
            System.out.print("Enter The Base: ");
            int Base=Sc.nextInt();
            System.out.print("Enter The Power: ");
            int Power=Sc.nextInt();
            int Store=Result(Base,Power);
            System.out.println("The Resulting Value Is: "+Store);
        }    
    }
    public static int Result(int Base,int Power)
    {
        if(Power<=1)
			return Base;
		else
			return Base*Result(Base,Power-1);
    }
}

//Write a recursive method in Java which, given an integer n, print it with its digits reversed. For example , given 4735, it prints 5374.

import java.util.*;
class Q9
{
    public static void main(String args[])
    {
        Scanner Sc=new Scanner(System.in);
        System.out.print("Enter The Number: ");
        int Number=Sc.nextInt();
        System.out.println("The Reverse Number: "+Reversed(Number));
    }
    public static int Reversed(int Number)
	{
		if(Number<10)
        {
            return Number;
        }
		else
		{
			int Matrix=(int)(Math.log(Number)/Math.log(10));
			int Radix=Number%10;
			Radix=Radix*(int)Math.pow(10, Matrix);
			Number=Number/10;
			return Radix+Reversed(Number);
		}
    }
}

//The sequence of numbers 1, 1, 2, 3, 5, 8, 13 etc are called Fibonacci numbers, each is the sum of the preceding two. Write a recursive method in Java which, given n,
//returns the nth Fibonacci number.

import java.util.*;
class QX
{
    public static void main(String args[])
    {
        Scanner Sc=new Scanner(System.in);
        System.out.print("Enter The Numbered Fibonacci Place: ");
        int Number=Sc.nextInt();
        System.out.println("The Fibonacci Number Is: "+Fibonacci(Number));
    }
    static int Fibonacci(int Number)
    {
        if (Number<2)
        return Number;
        return Fibonacci(Number-1)+Fibonacci(Number-2);
    }
}

//Write a recursive method in Java to return the greatest common divisor(gcd) of two integers m and n, given that in general, gcd(m,n)=gcd(n, m mod n).

import java.util.*;
public class Q11
{
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		System.out.print("Enter The First Value :");
		int m=in.nextInt();
		System.out.print("Enter The Second Value :");
		int n=in.nextInt();
		int ans=gcd(m,n);
		System.out.println("The GCD Is:"+ans);
	}
	public static int gcd(int m, int n)
	{
		if(Math.max(m, n)%Math.min(m, n)==0)
			return Math.min(m, n);
		else
			return gcd(Math.min(m,n),Math.max(m, n)%Math.min(m, n));
	}
}

//Write a recursive method in Java to search an element of an array using binary search.

import java.util.*;
public class Q12
{
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		System.out.print("Enter The Size Of The Array :");
		int n=in.nextInt();
		int arr[] = new int[n];
		System.out.println("Enter The Elements In The Array In Ascending Order :");
		for(int i=0; i<n; i++)
		{
			arr[i]=in.nextInt();
		}
		System.out.print("Enter The Element To Be Searched :");
		int e=in.nextInt();
		int s=search(arr,e,n/2);
		System.out.print("Element Found At "+s);
	}
	public static int search(int[] arr, int e, int m)
	{
		if(e==arr[m])
			return m;
		else
		{
			if(e>arr[m])
			{
				return search(arr, e, m+m/2);
			}
			else
			{
				return search(arr, e, m-m/2);
			}
		}
	}
}

//Write a recursive method in Java to find the binary equivalent of a positive decimal integer.

import java.util.*;
public class Q13
{
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		System.out.print("Enter The Decimal Number: ");
		int n=in.nextInt();
		int ans=dec2bin(n);
		System.out.println("The Converted Value Is: "+ans);
	}
	public static int dec2bin(int n)
	{
		if(n<=1)
			return n;
		else
			return dec2bin(n/2)*10+(n%2);
	}
}

//Write a recursive method in Java to find the product of 2 numbers.

import java.util.Scanner;
public class Q14
{
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		System.out.print("Enter The First Number: ");
		int a=in.nextInt();
		System.out.print("Enter The Second Number: ");
		int b=in.nextInt();
		int ans=mul(a,b);
		System.out.println("The Result Is: "+ans);
	}
	public static int mul(int a, int b)
	{
		if(b>0)
			return a+mul(a,b-1);
		else if(b<0)
			return mul(a,b+1)-a;
		else
			return 0;
	}
}

//Write a recursive Java method that takes a character string s and outputs its reverse. For example, the reverse of 'pots&pans' would be 'snap&stop'.

import java.util.Scanner;
public class Q15
{
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		System.out.print("Enter a String: ");
		String s=in.nextLine();
		String ans=rev(s);
		System.out.println("The Reversed String Is: "+ans);
	}
	public static String rev(String s)
	{
		if(s.length()==0)
			return "";
		else
			return s.charAt(s.length()-1)+rev(s.substring(0,s.length()-1));
	}
}

//Write a recursive Java method that determines if a string s is a palindrome, that is, it is equal to its reverse. Examples of palindromes include 'racecar' and
//'gohangasalamiimalasagnahog'.

import java.util.Scanner;
public class Q16 
{
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		System.out.print("Enter A String: ");
		String s=in.nextLine();
		boolean ans=pal(s);
		System.out.println("The Result Is: "+ans);
	}
	public static boolean pal(String s)
	{
		if(s.length()<=1)
			return true;
		else
			return s.charAt(s.length()-1)==s.charAt(0)&&pal(s.substring(1,s.length()-1));
	}
}

//Given an unsorted array, A, of integers and an integer k, write recursive program using Java for rearranging the elements in A so that all elements less than or equal 
//to k come before any elements larger than k.

import java.util.*;
public class Q17
{
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		System.out.print("Enter The Size Of The Array: ");
		int n=in.nextInt();
		int arr[] = new int[n];
		System.out.println("Enter The Elements In The Array: ");
		for(int i=0; i<n; i++)
		{
			System.out.print("Enter The Element At "+(i+1)+" : ");
			arr[i]=in.nextInt();
		}
		System.out.print("\nEnter The Pivot Element :");
		int p=in.nextInt();
		int p1=0, p2=n-1;
		int[] s=quicksort(arr, p, p1, p2);
		for(int i=0; i<n; i++)
		{
			System.out.print(arr[i]);
		}
	}
	public static int[] quicksort(int arr[], int p, int p1, int p2 ) 
	{
		if(p1<p2)
		{ 
			if(arr[p1]<p) 
				p1++; 
			else
			{
				if(arr[p2]>p) 
					p2--; 
				else if(arr[p1]==arr[p2]) 
					p1++; 
				else 
				{ 
					int t=arr[p1]; 
					arr[p1]=arr[p2]; 
					arr[p2]=t; 
				}
			}
			return quicksort(arr,p,p1,p2); 
		}
		else
			return arr;
	} 
}

//In the Towers of Hanoi puzzle, we are given a platform with three pegs, a, b, and c, sticking out of it. On peg a is a stack of n disks, each larger than the next, so 
//that the smallest is on the top and the largest is on the bottom. The puzzle is to move all the disks from peg a to peg c, moving one disk at a time, so that we never 
//place a larger disk on top of a smaller one. See Figure 1 for an example of the case n = 4. Write a recursive program using Java for solving the Towers of Hanoi puzzle 
//for arbitrary n. (Hint: Consider first the subproblem of moving all but the nth disk from peg a to another peg using the third as “temporary storage.”)

import java.util.*;
public class Q18
{
	public static void main(String args[])
	{
		queue arr[] = new queue[3];
		Scanner in = new Scanner(System.in);
		System.out.print("Enter The Number Of Rings: ");
		int n=in.nextInt();
		for(int i=0; i<3; i++)
		{
			arr[i]= new queue(n, "Queue "+i);
		}
		for(int i=n; i>=1; i--)
		{
			arr[0].push(i);
			System.out.println(arr[0]);
		}
		set(n, arr, 0, 1, 2);
	}
	public static void set(int i, queue[] arr, int q1, int q2, int q3)
	{
		if(i>0)
		{
			set(i-1, arr, q1, q3, q2);
			swapDisk(q1, q2, arr);
			for(queue t:arr)
			{
				System.out.println(t.getName()+" :"+t);
			}
			set(i-1, arr, q3, q2, q1);
		}
	}
	public static void swapDisk(int q1, int q2, queue[] arr)
	{
		int t=arr[q1].peek();
		if(t>0)
		{	
			arr[q2].push(t);
			arr[q1].pop();
		}
	}
}
class queue
{
	private int arr[];
	private String name;
	int top;
	queue(int n, String name)
	{
		this.name=name;
		top=-1;
		arr = new int[n];
	}
	String getName()
	{
		return name;
	}
	void pop()
	{
		if(top==-1)
		{
			try
			{
				throw new StackUnderflowException("Queue is already Empty");
			}
			catch(StackUnderflowException e)
			{
				e.printStackTrace();
			}
		}
		else
			top--;
	}
	int peek()
	{
		if(top!=-1)
		{
			return arr[top];
		}
		else
		{
			System.out.print("Queue is Empty, Nothing to show");
			return -1;
		}
	}
	void push(int i)
	{
		if(top==arr.length)
		{
			try
			{
				throw new StackOverflowException("Queue is already full");
			}
			catch(StackOverflowException e)
			{
				e.printStackTrace();
			}
		}
		else
		{
			top++;
			arr[top]=i;
		}
	}
	int[] show()
	{
		if(top==-1)
		{			
				return null;
		}
		else
		{
			int rt[] = new int[top+1];
			for(int i=0; i<=top; i++)
			{
				rt[i]=arr[i];
			}
			return rt;
		}
	}
	public String toString()
	{
		if(show()!=null)
		{
			int[] rt=show();
			String s="[";
			for(int i:rt)
			{
				s=s+i+", ";
			}
			s=s+"]";
			return s;
		}
		else
			return "[ ]";
	}
}
class StackUnderflowException extends Exception
{
	StackUnderflowException(String s)
	{
		super(s);
	}
}
class StackOverflowException extends Exception
{
	StackOverflowException(String s)
	{
		super(s);
	}
}
