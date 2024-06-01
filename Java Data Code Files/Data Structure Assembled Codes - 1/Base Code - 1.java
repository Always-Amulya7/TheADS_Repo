//Write a java program to display following messages.
//Hello “World”
//Welcome to World Family.
//Welcome to “Introduction to Java”
//Java is fun for All !!

class Q1
{
	public static void main(String args[])
	{
		System.out.println("Hello \"World\"");
		System.out.println("Welcome to World Family");
		System.out.println("Welcome to \"Introduction to Programming\"");
		System.out.println("Java is fun for All!!");
	}
}

//Write a complete Java program that shows the pattern similar to the following.

class Q2
{
	public static void main(String args[])
	{
		System.out.println('b');
		System.out.println('b'+'c');
		System.out.println((char)('a'+4));
	}
}

//Write a java program to print the following pattern using Hash (#).

class Q3
{
	public static void main(String args[])
	{
		System.out.println("###########################################");
		System.out.println("##                                       ##");
		System.out.println("##                                       ##");
		System.out.println("##                                       ##");
		System.out.println("##                                       ##");
		System.out.println("##                                       ##");
		System.out.println("###########################################");
	}
}

//Write a java program that will display your First, Middle and Last name in different lines without using the method println( ).

class Q4
{
	public static void main(String args[])
	{
		System.out.print("Amulya");
		System.out.print("\nDeep\n");
		System.out.println("Shrivastava");
	}
}

//Write a java program to greet someone. Your program stores person name and greeting message into two variables, 
//and displays their values on the screen. E.g. Hey Rishi, Good Morning!

class Q5
{
	public static void main(String args[]) 
	{
		String a="Rishi",b="Good Morning!";
		System.out.println("Hey "+a+", "+b);
	}
}

//Write a java program to store your Bank account no, name and balance in three different variables and display their value on the screen 
//as given: “My name is Amit Kumar bearing account number 123456 having balance 7654.98”

class Q6
{
	public static void main(String args[])
	{
		long acc= 158642125;
		String name="Amulya";
		double bal=125450.78;
		System.out.println("My name is "+name+" bearing account number "+acc+" having balance "+bal);
	}
}

//Write a java program to exchange the values of two variables of integer type X and Y using third temporary variable Z

class Q7
{
	public static void main(String args[])
	{
		int x=10;
		int y=20;
		int z;
		System.out.println("Value of X:"+x);
		System.out.println("Value of Y:"+y);
		z=x;
		x=y;
		System.out.println("After Exchange");
		System.out.println("x:"+x);
		System.out.println("y:"+z);
	}
}

//Write a java program to exchange the values of two variables of integer type X and Y without using third temporary variable.

class Q8
{
    public static void main(String[] args)
    {
        int x = 10;
        int y = 20;

        // Swapping the values of x and y without using an extra variable
        x = x + y;
        y = x - y;
        x = x - y;

        System.out.println("The new value of x is " + x);
        System.out.println("The new value of y is " + y);
    }
}

//What do each of the following print? 
//a) System.out.println(5); 
//b) System.out.println((float)25/6); 
//c) System.out.println(5+'6'); 
//d) System.out.println(5+7+'9'); 
//e) System.out.println("92"+7+5); 
//f) System.out.println(2+"9");

class Q9
{
	public static void main(String args[])
	{
		System.out.println(5);
		System.out.println((float)25/6);
		System.out.println(5+'6');
		System.out.println(5+7+'9');
		System.out.println("92"+7+5);
		System.out.println(2+"9");
	}
}

//Assume a string variable ruler1 contains “1” initially i.e. String ruler1=”1” Write a java program to print the following output using 
//string concatenation. (You can take extra string variables)
//1
//1 2 1
//1 2 1 3 1 2 1
//1 2 1 3 1 2 1 4 1 2 1 3 1 2 1

class QX
{
	public static void main(String args[])
	{
		String ruler1="1";
		String ruler2="2";
		String ruler3="3";
		String ruler4="4";
		System.out.println(ruler1);
		System.out.println(ruler1+ruler2+ruler1);
		System.out.println(ruler1+ruler2+ruler1+ruler3+ruler1+ruler2+ruler1);
		System.out.println(ruler1+ruler2+ruler1+ruler3+ruler1+ruler2+ruler1+ruler4+ruler1+ruler2+ruler1+ruler3+ruler1+ruler2+ruler1);
	}
}

//What do each of the following print?
//a) System.out.println(2 + "bc");
//b) System.out.println(2 + 3 + "bc");
//c) System.out.println((2+3) + "bc");
//d) System.out.println("bc" + (2+3));
//e) System.out.println("bc" + 2 + 3);

class Q11
{
	public static void main(String args[])
	{
		System.out.println(2+"bc");
		System.out.println(2+3+"bc");
		System.out.println((2+3)+"bc");
		System.out.println("bc"+(2+3));
		System.out.println("bc"+2+3);
	}
}

//What do each of the following print?
//a) System.out.println('b');
//b) System.out.println('b' + 'c');
//c) System.out.println((char) ('a' + 4));

class Q12
{
	public static void main(String args[])
	{
		System.out.println('b');
		System.out.println('b'+'c');
		System.out.println((char)('a'+4));
	}
}

//Suppose that a variable a is declared as int a = 2147483647 (or equivalently, Integer.MAX_VALUE ). What do each of the following print?
//a) System.out.println(a);
//b) System.out.println(a+1);
//c) System.out.println(2-a);
//d) System.out.println(-2-a)
//e) System.out.println(2*a);
//f) System.out.println(4*a);

class Q13
{
	public static void main(String args[])
	{
		int a=2147483647;
		System.out.println(a);
		System.out.println(a+1);
		System.out.println(2-a);
		System.out.println(-2-a);
		System.out.println(2*a);
		System.out.println(4*a);
	}
}

//Suppose that a variable a is declared as double a = 3.14159. What do each of the following print?
//a) System.out.println(a);
//b) System.out.println(a+1);
//c) System.out.println(8/(int) a);
//d) System.out.println(8/a);
//e) System.out.println((int) (8/a));

class Q14
{
	public static void main(String args[])
	{
		double a=3.14159;
		System.out.println(a);
		System.out.println(a+1);
		System.out.println(8/(int)a);
		System.out.println(8/a);
		System.out.println((int)8/a);
	}
}

//Write a java program to exchange the value of 4 variables W,G,K,A such that the value of W will move to A, A to K, K to G and finally G to W.
//Exchange using with and without using extra variables

//With Extra Variable

class Q15
{
	public static void main(String args[])
	{
        int w = 10,g = 20,k = 30,a = 40;

        int temp;

        // Swapping the values of w and a
        temp = w;
        w = a;
        a = temp;

        // Swapping the values of a and k
        temp = a;
        a = k;
        k = temp;

        // Swapping the values of k and g
        temp = k;
        k = g;
        g = temp;

        // Swapping the values of g and w
        temp = g;
        g = w;
        w = temp;

        System.out.println("The new value of w is " + w);
        System.out.println("The new value of g is " + g);
        System.out.println("The new value of k is " + k);
        System.out.println("The new value of a is " + a);
    }
}

//Without Extra Variable

class Q15
{
    public static void main(String[] args)
    {
        int w = 10;
        int g = 20;
        int k = 30;
        int a = 40;

        // Swapping the values of w and a
        w = w + a; // w = 10 + 40 = 50
        a = w - a; // a = 50 - 40 = 10
        w = w - a; // w = 50 - 10 = 40

        // Swapping the values of a and k
        a += k; // a = 10 + 30 = 40
        k = a - k; // k = 40 - 30 = 10
        a -= k; // a = 40 - 10 = 30

        // Swapping the values of k and g
        k += g; // k = 10 + 20 = 30
        g = k - g; // g = 30 - 20 = 10
        k -= g; // k = 30 - 10 = 20

        // Swapping the values of g and w
        g += w; // g = 10 + 40 = 50
        w = g - w; // w = 50 - 40 = 10
        g -= w; // g = 50 - 10 = 40

        System.out.println("The new value of w is " + w);
        System.out.println("The new value of g is " + g);
        System.out.println("The new value of k is " + k);
        System.out.println("The new value of a is " + a);
    }
}