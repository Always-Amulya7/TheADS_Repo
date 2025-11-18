/*class Code1
{
	public static void main(String args[])
	{
		long A=5371853718l;
		System.out.println(A);
	}
}*/

/*class Code1
{
	public static void main(String args[])
	{
		byte b1=60;
		byte b2=60;
		byte b3=(byte)(b1*b2);
		System.out.println(b3);
	}
}*/
/*class Code1
{
	public static void main(String args[])
	{
		int i = 0;
		if( i++ + i>=1)
		System.out.println(true);
		else System.out.println(false);
	}
}*/

/*import java.util.Scanner;
class Code1
{
	public static double Calculate(int P,int R,int T)
	{
		double SI=(P*R*T)/100;
		double Amt=P+SI;
		System.out.println(SI);
		System.out.println(Amt);
		return 0;
	}
	public static void main(String args[])
	{
		try(Scanner sc=new Scanner(System.in))
		{
			System.out.println("Enter The Principle,Rate And Time:");
			int P=sc.nextInt();
			int R=sc.nextInt();
			int T=sc.nextInt();
			System.out.println("The Simple Interest And Amount Is: ");
			Calculate(P,R,T);
		}
	}
}*/

/*class Code1
{
	static void printHello()
	{
		System.out.println("HEllo World");
	}
	public static void main(String args[])
	{
		printHello();
	}
}*/

/*import java.util.Scanner;
class Code1
{
	static void printGreetings(String Name)
	{
		System.out.println("Good Morning "+Name);
	}
	public static void main(String args[])
	{
		try(Scanner sc=new Scanner(System.in))
		{
			System.out.print("Enter The Name:");
			String Name=sc.nextLine();
			printGreetings(Name);
		}
	}
}*/

/*class Code1
{
	public static Long Reverse(Long Number)
	{
		Long Reverse=0l;
		while(Number!=0)
		{
			Reverse=Reverse*10+Number%10;
			Number/=10;
		}
		return Reverse;
	}
	public static void main(String args[])
	{
		System.out.println("The Reverse Of The Number Is: "+Reverse(5678l));
	}
}*/

/*import java.util.Scanner;
class Code1
{
	static long reverse(long Number)
	{
		long reverse=0;
		while(Number!=0)
		{
			reverse*=10+Number/10;
			Number/=10;
		}
		return reverse;
	}
	static boolean isPalindrome(long Number)
	{
		if (Number==reverse(Number))
		return false;
		else
		return true;
	}
	public static void main(String args[])
	{
		try(Scanner sc=new Scanner(System.in))
		{
			System.out.print("Enter A Number: ");
			Long input=sc.nextLong();
			if (isPalindrome(input))
			System.out.println("Yes Babu");
			else
			System.out.println("No Babu");
		}
	}
}*/

/*import java.util.Scanner;
class Code1
{
	static int Terms(int Terms)
	{
		int n,m,res=0;
		n=0;
		m=1;
		if (Terms==1)
		return n;
		else if (Terms==2)
		return m;
		else
		{
			for (int i=3;i<=Terms;i++)
			{
				res=n+m;
				n=m;
				m=res;
			}
		}
		return res;
	}
	public static void main(String args[])
	{
		int Term;
		try(Scanner sc=new Scanner(System.in))
		{
			System.out.print("Enter The Range:");
			Term=sc.nextInt();
			System.out.println("The Fibonacci Series Is: ");
			for (int i=1;i<=Term;i++)
			{
				System.out.print(Terms(i)+" ");
			}
		}
	}
}*/

/*import java.util.Scanner;
class Code1
{
	public static void main(String args[])
	{
		try(Scanner sc=new Scanner(System.in))
		{
			System.out.println("Enter The Length OF The Array: ");
			int Length=sc.nextInt();
			int[] Arr=new int[Length];
			System.out.println("The Array Length Is: "+Arr.length);
			for (int i=0;i<Arr.length;i++)
			{
				System.out.print("Enter The Data To Be Stored: ");
				Arr[i]=sc.nextInt();
			}
			System.out.print("The Corresponding Array Is: ");
			for (int j=0;j<Arr.length;j++)
			{
				System.out.print(Arr[j]+" ");
			}
		}
	}
}*/

/*import java.util.Scanner;
class Code1
{
	public static void main(String args[])
	{
		try(Scanner sc=new Scanner(System.in))
		{
			System.out.println("Enter The Number OF The Subject: ");
			int Length=sc.nextInt();
			int[] Arr=new int[Length];
			System.out.println("The Array Length Is: "+Arr.length);
			for (int i=0;i<Arr.length;i++)
			{
				System.out.print("Enter The Data To Be Stored: ");
				Arr[i]=sc.nextInt();
			}
			System.out.print("The Corresponding Marks In The Subject Are: ");
			for (int j=0;j<Arr.length;j++)
			{
				System.out.print(Arr[j]+" ");
			}
			System.out.println("\nThe Average Marks IS:"+Average(Arr));
		}
	}
	static double Average(int Arry[])
	{
		int Sum=0,Avg;
		for (int i=0;i<Arry.length;i++)
		{
			Sum=Sum+Arry[i];
		}
		Avg=Sum/(Arry.length);
		return Avg;
	}
}*/

/*class Code1
{
    public static void main(String args[])
	{
        int m_days[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String monthNames[] = {"January", "February", "March", "April", "May", "June",
                                "July", "August", "September", "October", "November", "December"};
        for (int i = 0; i < m_days.length; i++) {
            System.out.println(m_days[i] + " " + monthNames[i]);
        }
    }
}*/