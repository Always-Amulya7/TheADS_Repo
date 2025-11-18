/*class Demo
{
    public static void main(String args[])
    {
        for (int i=0;i<=4;i++)
       {
        for (char j='A';j<='A'+i;j++)
        {
            System.out.print((char)j);
        }
        System.out.println();
       }
    }
}*/

/*class Demo
{
    public static void main(String[] args)
    {
        int rows = 5;
        for (int i = 1; i <= rows; i++)
        {
            for (int j = 1; j <= rows - i; j++)
            {
                System.out.print(" ");
            }
            for (int k = 1; k <= i; k++)
            {
                System.out.print(i);
            }
            System.out.println();
        }
    }
}*/

/*class Demo
{
    public static void main(String args[])
    {
        int i,j;
        for (i=1;i<=5;i++)
        {
            for (j=1;j<=5-i;j++)
            {
                System.out.print(" ");
            }
            for (int k=1;k<=i;k++)
            {
                System.out.print("* ");
            }
            System.out.println();
        }
        for (i=1;i<=4;i++)
        {
            for (j=1;j<=i;j++)
            {
                System.out.print(" ");
            }
            for (int k=4;k>=i;k--)
            {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}*/

/*import java.util.Scanner;
class Demo
{
    public static void main(String args[])
    {
        try(Scanner sc=new Scanner(System.in))
        {
            int arr[]={1,2,3,4,5,6,7,8,9,10};
            for (int i=0;i<=8;i++)
            {
                System.out.println(arr[i]);
            }
        }
    }
}*/

/*import java.util.Scanner;
class Demo
{
    public static void main(String args[])
    {
        try(Scanner sc=new Scanner(System.in))
        {
            int arr[]=new int[6];
            for (int i=0;i<=5;i++)
            {
                System.out.println("Enter Data To The Array:");
                arr[i]=sc.nextInt();
            }
            for (int j=0;j<=5;j++)
            {
                System.out.print(arr[j]+" ");
            }
        }
    }
}*/

/*import java.util.Scanner;
class Demo
{
	public static void main(String args[])
	{
		try(Scanner sc=new Scanner(System.in))
		{
			System.out.print("Enter A Number:");
		int num=sc.nextInt();
		String s="";
		for(int i=1;i<=num;)
		{
			s=s+ i++ +s;
			System.out.println(s);
		}
		}
	}
}*/

/*import java.util.Scanner;
class Demo
{
    String Name,accno,dob;
    static String combo;
    void input()
    {
        System.out.println("Account Data Extraction");
        try(Scanner sc=new Scanner(System.in))
        {
            System.out.println("Enter Your Name:");
            Name=sc.next();
            System.out.println("Enter Account Details:");
            accno=sc.next();
            System.out.println("Enter DOB:");
            dob=sc.next();
        }
    }
    void calc()
    {
        System.out.println("Name Of Customer : "+Name);
        System.out.println("Account Number : "+accno);
        System.out.println("Date Of Birth: "+dob);
    }
    public static void main(String args[])
    {
        try(Scanner sc=new Scanner(System.in))
        {
            Demo ob=new Demo();
            ob.input();
            ob.calc();
            int i=1;
            do
            {
                System.out.print("Enter A Valid Combination:");
                combo=sc.next();
                if(combo=="260105")
                {
                    ob.calc();
                }
                else
                {
                    System.out.print("False Input");
                }
                i++;
            }
            while(i<=3);
        }
    }
}*/

/*import java.io.*;
class Demo
{
    String Name,dob,accno;
    void calc()throws IOException
    {
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter Your Name:");
        Name=input.readLine();
        System.out.println("Enter Account Details:");
        accno=input.readLine();
        System.out.println("Enter DOB:");
        dob=input.readLine();
    }
    public static void main(String args[])throws IOException
    {
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        int i=1;
        do
        {
            System.out.println("Enter Password:");
            String password=input.readLine();
            if (password=="260105")
            {
                System.out.println("Name Of Customer : "+Name);
                System.out.println("Account Number : "+accno);
                System.out.println("Date Of Birth: "+dob);
                break;
            }
            i++;
        }
        while(i!=3);
        Demo ob=new Demo();
        ob.calc();
    }
}*/

/*class Demo
{
    public static void main(String args[])
    {
        System.out.println("Hello \"ITERIAN\"");
        System.out.print("Welcome to Siksha 'O' Anusandhan Family \n");
        System.out.println("Welcome to \"Introduction to Computer Laboratory\"");
        System.out.println("Java is fun for All!!");
    }
}*/

/*class Demo
{
    public static void main(String args[])
    {
        System.out.println("*******     *******");
        System.out.println("      *     *     *");
        System.out.println("      *******     *******");
    }
}*/

/*class Demo
{
    public static void main(String args[])
    {
        System.out.println("################################");
        System.out.println("##                            ##");
        System.out.println("##                            ##");
        System.out.println("##                            ##");
        System.out.println("##                            ##");
        System.out.println("################################");
    }
}*/

/*class Demo
{
    public static void main(String args[])
    {
        System.out.print("Amulya\n");
        System.out.print("Deep\n");
        System.out.print("Shrivastava");
    }
}*/

/*class Demo
{
    public static void main(String args[])
    {
        String Name="Amulya",Greeting="Good Morning!";
        System.out.print("Hey "+Name+", "+Greeting);
    }
}*/

/*class Demo
{
    public static void main(String args[])
    {
        long AccountNo=756836696811l;
        String Name="Amulya Shrivastava";
        float balance=7654.98f;
        System.out.print("\"My name is "+Name+" bearing account number "+AccountNo+" having balance "+balance+"\"");
    }
}*/

/*class Demo
{
    public static void main(String args[])
    {
        int x=10,y=20,Z;
        System.out.println("Value Of X And Y Are:"+x+" "+y);
        Z=x;
        x=y;
        y=Z;
        System.out.println("Value Of X And Y Are:"+x+" "+y);

    }
}*/

/*class Demo
{
    public static void main(String args[])
    {
        int x=10,y=20;
        //Swapping Values
        x = x + y;
        y = x - y;
        x = x - y;
        System.out.println("Value Of X And Y Are:"+x+" "+y);
    }
}*/

/*class Demo
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
}*/

/*class Demo
{
    public static void main(String args[])
    {
        String Ruler1="1";
        System.out.println(Ruler1);
        Ruler1=Ruler1+2+Ruler1;
        System.out.println(Ruler1);
        Ruler1=Ruler1+3+Ruler1;
        System.out.println(Ruler1);
        Ruler1=Ruler1+4+Ruler1;
        System.out.println(Ruler1);
    }
}*/

/*class Demo
{
    public static void main(String args[])
    {
        System.out.println(2+"bc");
        System.out.println(2+3+"bc");
        System.out.println((2+3)+"bc");
        System.out.println("bc"+(2+3));
        System.out.println("bc"+2+3);
    }
}*/

/*class Demo
{
    public static void main(String args[])
    {
        System.out.println('b');
        System.out.println('b'+'c');
        System.out.println((char)('a'+4));
    }
}*/

/*class Demo
{
    public static void main(String args[])
    {
    int a=2147483647;
    System.out.println(a);
    System.out.println(a+1);
    System.out.println(2-a);
    System.out.println(-3-a);
    System.out.println(a);
    System.out.println(2*a);
    System.out.println(4*a);
    }
}*/

/*class Demo
{
    public static void main(String args[])
    {
        double a=3.14159;
        System.out.println(a);
        System.out.println(a+1);
        System.out.println(8/(int)a);
        System.out.println(8/a);
        System.out.println((int )(8/a));
    }
}*/

/*class Demo
{
    public static void main(String args[])
    {
        int w=10,g=20,k=30,a=40,temp;
        System.out.println("Value Of W G K A Are: "+w+" "+g+" "+k+" "+a);
        //W To A
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
}*/

/*class Demo
{
    public static void main(String args[])
    {
        int w=10,g=20,k=30,a=40;
        System.out.println("Value Of W G K A Are: "+w+" "+g+" "+k+" "+a);
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
}*/

/*import java.util.Scanner;
class Demo
{
    public static void main(String args[])
    {
        try(Scanner sc=new Scanner(System.in))
        {
            double Fahrenhiet;
            System.out.print("Enter A Degree In Faherenhiet: ");
            Fahrenhiet=sc.nextInt();
            System.out.println(Fahrenhiet+" Fahrenhiet is "+((Fahrenhiet-32)*(5.0/9))+" Celsius");
        }
        
    }
}*/

/*import java.util.Scanner;
class Demo
{
    public static void main(String args[])
    {
        try(Scanner sc=new Scanner(System.in))
        {
            System.out.print("Enter The Distance:");
            double Distance=sc.nextInt();
            System.out.println(Distance+" km is "+Distance*1000+" meters");
            System.out.println(Distance+" km is "+Distance*3280.8399+" feet");
            System.out.println(Distance+" km is "+Distance*39370.0787+" inch");
            System.out.println(Distance+" km is "+Distance*100000+" centimetres");
        }
    }
}*/

/*import java.util.Scanner;
class Demo
{
    public static void main(String args[])
    {
        try(Scanner sc=new Scanner(System.in))
        {
            System.out.print("Enter Basic Salary:");
            float Salary=sc.nextFloat();
            float DearnessAllowance=(40*Salary)/100;
            float HouseRentAllowance=(20*Salary)/100;
            System.out.println("DA is "+DearnessAllowance);
            System.out.println("HRA is "+HouseRentAllowance);
            System.out.println("Gross Salary is "+(Salary+DearnessAllowance+HouseRentAllowance));
        }
    }
}*/

/*import java.util.Scanner;
class Demo
{
    public static void main(String args[])
    {
        try(Scanner sc=new Scanner(System.in))
        {
            System.out.println("Enter A Number between 0 and 1000: ");
            int Number=sc.nextInt();
            int a=Number%10;
            Number/=10;
            int c=Number%10;
            int d=Number/10;
            int e=a+c+d;
            System.out.println("The Sum Of Digits Is "+e);
        }
    }
}*/

/*import java.util.Scanner;
class Demo
{
    public static void main(String args[])
    {
        try(Scanner sc=new Scanner(System.in))
        {
            double Radius=7.0;
            System.out.println("Enter The Radius Of The Hemisphere:"+Radius);
            System.out.println("The Surface Area Of The Hemisphere is "+3*Math.PI*Radius*Radius);
            System.out.println("The Volume Area Of The Hemisphere is "+2.0/3*Math.PI*Radius*Radius*Radius);
        }
    }
}*/

/*import java.util.Scanner;
class Demo
{
    public static void main(String[] args)
    {
        try(Scanner sc=new Scanner(System.in))
        {
            System.out.print("Enter The Number Of Seconds:");
            float Second=sc.nextFloat();
            System.out.println("Distance Travelled:"+(1.0/2)*32.174*Second*Second);
        }
    }
}*/

/*import java.util.Scanner;
class Demo
{
    public static void main(String args[])
    {
        try(Scanner sc=new Scanner(System.in))
        {
            int a=1,b=2;
            System.out.println("A"+"\t"+"B"+"\t"+"Pow(A,B)");
            System.out.println(a+"\t"+b+"\t"+(int) Math.pow(a,b));
            System.out.println((++a)+"\t"+(++b)+"\t"+(int) Math.pow(a,b));
            System.out.println((++a)+"\t"+(++b)+"\t"+(int) Math.pow(a,b));
            System.out.println((++a)+"\t"+(++b)+"\t"+(int) Math.pow(a,b));
            System.out.println((++a)+"\t"+(++b)+"\t"+(int)Math.pow(a,b));
        }
    }
}*/

/*import java.util.Scanner;
class Demo
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
}*/

/*import java.util.Scanner;
class Demo
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
}*/

/*import java.util.Scanner;
class Demo
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
}*/

/*import java.util.Scanner;
class Demo
{
    public static void main(String args[])
    {
        try(Scanner sc=new Scanner(System.in))
        {
            System.out.print("Enter Your Age:");
            int Age=sc.nextInt();
            if (Age>=18)
            System.out.println("\"You Are Eligible To Vote\"");
            else
            System.out.println("Get The Hell Out Of Here Kido");
        }
    }
}*/

/*import java.util.Scanner;
class Demo
{
    public static void main(String args[])
    {
        try(Scanner sc=new Scanner(System.in))
        {
            System.out.print("Enter First Number:");
            int Num1=sc.nextInt();
            System.out.print("Enter Second Number:");
            int Num2=sc.nextInt();
            System.out.print("Enter Third Number:");
            int Num3=sc.nextInt();
            if (Num1>Num2 && Num1>Num3)
            System.out.println("Decreasing");
            else if (Num1<Num2 && Num1<Num3)
            System.out.println("Increasing");
            else
            System.out.println("Neither Increasing Nor Decreasing");
        }
    }
}*/

/*import java.util.Scanner;
class Demo
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in); 
        System.out.print("Enter The WaterLevel Consumed:");
        float WaterLevel=sc.nextFloat();
        if (WaterLevel>=5000)
        System.out.println("\"Yes, Alice is following doctor's advice\"");
        else
        System.out.println("\"No, Alice is not following doctor's advice\"");
    }
}*/

/*import java.util.Scanner;
class Demo
{
    public static void main(String args[])
    {
        try(Scanner sc=new Scanner(System.in))
        {
            System.out.print("Enter User Number:");
            int YourChoice=sc.nextInt();
            int ComputerChoice=(int) (Math.random()*9+1);
            System.err.println("Compter Guesses:"+ComputerChoice);
            if (YourChoice==ComputerChoice)
            System.out.println("\"You Got It Right!\"");
            else if(YourChoice==ComputerChoice-1)
            System.err.println("\"Almost Got It\"");
            else if(YourChoice==ComputerChoice+1)
            System.err.println("\"You Got It Wrong\"");
            else
            System.err.println("Wait Bhai Ruk Jaa");
        }
    }
}*/

/*import java.util.Scanner;
class Demo
{
    public static void main(String args[])
    {
        try(Scanner sc=new Scanner(System.in))
        {
            System.out.print("Input The Year: ");
            int Year=sc.nextInt();
            if ((Year%4==0 || Year%100==0))
            System.out.println(Year+" is a Leap Year: "+true);
            else
            System.out.println(Year+" is a Not Leap Year: "+false);
        }
    }
}*/

/*import java.util.Scanner;
class Demo
{
    public static void main(String args[])
    {
        try(Scanner sc=new Scanner(System.in))
        {
            System.out.print("Enter The Units Consumed:");
            double Units=sc.nextDouble();
            double Amount;
            if (Units<=50)
            Amount=3.0*Units;
            else if (Units>=51 && Units<=200)
            Amount=4.80*(Units-50)+3*50;
            else if (Units>=201 && Units<=400)
            Amount=5.80*(Units-200)+4.80*200;
            else
            Amount=6.20*(Units-400)+5.80*400;
            System.out.println("The Electricity Bill is: "+Amount);
        }
    }
}*/

/*import java.util.Scanner;
class Demo
{
    public static void main(String[] args)
    {
        try(Scanner sc=new Scanner(System.in))
        {
            System.out.print("No. Of Units Consumed: ");
            double Units=sc.nextDouble();
            System.out.print("Do You Want To Pay Online (Y/N): ");
            String ch=sc.next();
            double Amount=0.0,Discount=0.0,TotalAmt=0.0;
            if (Units<=50)
            Amount=3.0*Units;
            else if (Units>=51 && Units<=200)
            Amount=4.80*(Units-50)+3*50;
            else if (Units>=201 && Units<=400)
            Amount=5.80*(Units-200)+4.80*200;
            else
            Amount=6.20*(Units-400)+5.80*400;
            if (ch.charAt(0)=='Y')
            {
                Discount = 0.03*Amount;
            }
            else
            {
                Discount=0.0;
            }
            System.out.println("Total Amount: "+Amount);
            System.out.println("Discount: "+Discount);
            System.out.println("Amount Payable: "+(Amount-Discount));
        }
    }
}*/

/*import java.util.Scanner;
class Demo
{
    public static void main(String args[])
    {
        try(Scanner sc=new Scanner(System.in))
        {
            System.out.println("Enter The Co-Ordinates:");
            float x=sc.nextFloat();
            float y=sc.nextFloat();
            if (x>0 && y >0)
            System.out.println("( "+x+", "+y+") is in Quadrant-I");
            else if(x<0 && y>0)
            System.out.println("( "+x+", "+y+") is in Quadrant-II");
            else if(x>0 &&  y<0)
            System.out.println("( "+x+", "+y+") is in Quadrant-III");
            else if (x<0 && y<0)
            System.out.println("( "+x+", "+y+") is in Quadrant-IV");
            else if (x==0 && y==0)
            System.out.println("( "+x+", "+y+") is At Origin");
            else if (x==0)
            System.out.println("( "+x+", "+y+") is At Y-Axis");
            else
            System.out.println("( "+x+", "+y+") is At X-Axis");
        }
    }
}*/

/*import java.util.Scanner;
class Demo
{
    public static void main(String args[])
    {
        try(Scanner sc=new Scanner(System.in))
        {
            System.out.println("Enter The Values Of A,B And C:");
            int a=sc.nextInt();
            int b=sc.nextInt();
            int c=sc.nextInt();
            int LargestNo=a>b?(a>c?a:b):c;
            int secondLargest;
            System.out.println("Largest Number: "+LargestNo);
            if (a != LargestNo && b != LargestNo)
		    {
            secondLargest = Math.max(a, b);
            } 
		    else if (a != LargestNo && c != LargestNo) 
		    {
            secondLargest = Math.max(a, c);
            } 
		    else 
		    {
            secondLargest = Math.max(b, c);
            }
            System.out.println("Largest Number: "+secondLargest);
        }
    }
}*/

/*import java.util.Scanner;
class Demo
{
    public static void main(String args[])
    {
        try(Scanner sc=new Scanner(System.in))
        {
            System.out.println("Enter The Marks: ");
            int Marks=sc.nextInt();
            switch(Marks/10)
            {
                case 1:System.out.println("O");
                break;
                case 9:System.out.println("A");
                break;
                case 8:System.out.println("B");
                break;
                case 7:System.out.println("C");
                break;
                case 6:System.out.println("D");
                break;
                case 5:System.out.println("E");
                break;
                case 4:System.out.println("F");
                break;
                default:System.out.println("Enter Correct Value:");
                break;
            }
        }
    }
}*/

/*import java.util.Scanner;
class Demo
{
    public static void main(String args[])
    {
        try(Scanner sc=new Scanner(System.in))
        {
            System.out.println("Rules: Scissor-0  Rock-1   Paper-2");
            System.out.print("Enter Your Choice: ");
            int YourChoice=sc.nextInt();
            int ComputerChoice=(int)(Math.random()+2);
            String Store1="",Store2="";
            switch(YourChoice)
            {
                case 0:Store1="Scissors";
                break;
                case 1:Store1="Rock";
                break;
                case 2:Store1="Paper";
                break;
            }
            switch(ComputerChoice)
            {
                case 0:Store2="Scissors";
                break;
                case 1:Store2="Rock";
                break;
                case 2:Store2="Paper";
                break;
            }
            System.out.println("You Are:"+YourChoice);
            System.out.println("You Are:"+ComputerChoice);
            if (YourChoice>ComputerChoice)
            System.out.println("The Computer Is "+Store2+". You Are "+Store1+". You Won.");
            else if (YourChoice<ComputerChoice)
            System.out.println("The Computer Is "+Store2+". You Are "+Store1+". You Lost.");
            else if (YourChoice==ComputerChoice)
            System.out.println("The Computer Is "+Store2+". You Are "+Store1+" Too. It Is A Draw");
            else
            System.out.println();
        }
    }
}*/

/*import java.util.Scanner;
class Demo
{
    public static void main(String[] args)
    {
        try(Scanner sc=new Scanner(System.in))
        {
            System.out.println("Enter The Month Number:");
            int MonthNumber=sc.nextInt();
            switch(MonthNumber)
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
                default:System.out.println("Invalid Bhai");
                break;
            }
        }
    }
}*/

/*import java.util.Scanner;
class Demo
{
    public static void main(String args[])
    {
        try(Scanner sc=new Scanner(System.in))
        {
            System.out.print("Enter An Integer: ");
            int Integer=sc.nextInt();
            if (Integer%5==0 && Integer%6==0)
            System.out.println("Is "+Integer+" Divisible By 5 And 6? true");
            else
            System.out.println("Is "+Integer+" Divisible By 5 And 6? false");
            if (Integer%5==0 || Integer%6==0)
            System.out.println("Is "+Integer+" Divisible By 5 Or 6? true");
            else
            System.out.println("Is "+Integer+" Divisible By 5 Or 6? false");
            if ((Integer%5==0 || Integer%6==0) && (Integer%5!=0 || Integer%6!=0)  )
            System.out.println("Is "+Integer+" Divisible By 5 Or 6, But Not By Both? true");
            else
            System.out.println("Is "+Integer+" Divisible By 5 Or 6, But Not By Both? false");
        }
    }
}*/

/*import java.util.Scanner;
class Demo
{
    public static void main(String args[])
    {
        try(Scanner sc=new Scanner(System.in))
        {
            System.out.print("What is Your Gender: ");
            String sex=sc.next();
            char Gender=sex.charAt(0);
            System.out.print("First Name: ");
            String FirstName=sc.next();
            System.out.print("Second Name: ");
            String SecondName=sc.next();
            System.out.print("Enter Age: ");
            int Age=sc.nextInt();
            switch(Gender)
            {
                case 'F':
                if (Age>=20)
                {
                    System.out.print("Are You Married, "+FirstName+" ( Y Or N )?");
                    String Answer=sc.next();
                    char Result=Answer.charAt(0);
                    if (Result=='Y')
                    System.out.print("Then I Shall Call You Mrs."+FirstName+" "+SecondName);
                }
                else
                {
                    System.out.println("Then I Shall Call You Ms."+FirstName);
                }
                case 'M':
                if (Age>=20)
                {
                    System.out.print("Are You Married, "+FirstName+" ( Y Or N )?");
                    String Answer=sc.next();
                    char Result=Answer.charAt(0);
                    if (Result=='Y')
                    System.out.print("Then I Shall Call You Mr."+FirstName+" "+SecondName);
                }
                else
                {
                    System.out.println("Then I Shall Call You Mr."+FirstName);
                }
           
            }
        }
    }
}*/

/*import java.util.Scanner;
class Demo
{
    public static void main(String args[])
    {
        try(Scanner sc=new Scanner(System.in))
        {
            System.out.print("Enter Today's Day: ");
            int ThisDay=sc.nextInt();
            String Day="",Afterday="";
            switch(ThisDay)
            {
                case 0:Day="Sunday";
                break;
                case 1:Day="Monday";
                break;
                case 2:Day="Tuesday";
                break;
                case 3:Day="Wednesday";
                break;
                case 4:Day="Thursday";
                break;
                case 5:Day="Friday";
                break;
                case 6:Day="Saturday";
                break;
            }
            System.out.println("Enter The Number Of Days Elapsed Since Today: ");
            int DayElapsed=sc.nextInt();
            int futureDay = (ThisDay + DayElapsed) % 7;
            switch(futureDay)
            {
                case 0:Afterday="Sunday";
                break;
                case 1:Afterday="Monday";
                break;
                case 2:Afterday="Tuesday";
                break;
                case 3:Afterday="Wednesday";
                break;
                case 4:Afterday="Thursday";
                break;
                case 5:Afterday="Friday";
                break;
                case 6:Afterday="Saturday";
                break;
            }
            System.out.println("Today is "+Day+" And The Future Day Is "+Afterday);
        }
    }
}*/

/*import java.util.Scanner;
class Demo
{
    public static void main(String args[])
    {    
        Scanner sc=new Scanner(System.in);
        System.out.println("Menu: Addition Substraction Multiplication Division");
        System.out.println("Enter The Value Of A And B:");
        int a=sc.nextInt();
        int b=sc.nextInt();
        System.out.println("Enter Your Choice:");
        String Choice=sc.next();
        char choice=Choice.charAt(0);
            if (choice=='+')
            {
                int Result=(a+b);
                System.out.println("The Result: "+Result);
            }
            else if (choice=='-')
            {
                if (a>b)
                {
                    int Result=(b-a);
                    System.out.println("The Result: "+Result);
                }
                else
                {
                    int Result=(a-b);
                    System.out.println("The Result: "+Result);
                }
                
            }
            else if (choice=='*')
            {
                int Result=(a*b);
                System.out.println("The Result: "+Result);
            }
            else if (choice=='/')
            {
                if ((a>b || b>a) && b!=0.0)
                {
                    int Result=(a/b);
                    System.out.println("The Result: "+Result);
                }
                
            }
            else
            {
                System.out.println("Sooch Phir Se");
            }
    }
}*/

/*import java.util.Scanner;
class Demo
{
    public static void main(String args[])
    {
        try(Scanner sc=new Scanner(System.in))
        {
            System.out.print("Enter First Number: ");
            int n1=sc.nextInt();
            System.out.print("Enter Second Number: ");
            int n2=sc.nextInt();
            System.out.print("Enter Third Number: ");
            int n3=sc.nextInt();
            int sum=0;
            for (int i=n1;i<=n2;i+=n3)
            {
                System.out.print(i+" ");
                sum=sum+i;
            }
            System.out.print('\n');
            System.out.println("The Sum Of Number Displayed is "+sum);
        }
    }
}*/

/*import java.util.Scanner;
class Demo
{
    public static void main(String args[])
    {
        try(Scanner sc=new Scanner(System.in))
        {
            System.out.println("Enter The Number:");
            int Number=sc.nextInt();
            int i=1,sum=0,temp=Number;
            while(Number>0)
            {
                sum=sum+(Number%10);
                Number/=10;
                i++;
            }
            if (sum%9==0)
            System.out.println("The Number "+temp+" Is Divisible By 9");
            else
            System.out.println("The Number "+temp+" Is Not Divisible By 9");
        }
    }
}*/

/*import java.util.Scanner;
class Demo
{
    public static void main(String args[])
    {
        try(Scanner sc=new Scanner(System.in))
        {
            System.out.print("Enter A Number: ");
            int Num=sc.nextInt();
            int Random,Average=0;
            System.out.print("Random Numbers Generated Are: ");
            int i=1;
            do
            {
                Random=(int) (Math.random()*Num+1);
                Average=(Average+Random);
                System.out.print(Random+" ");
                i++;
            }
            while(i<=Num);
            System.out.println();
            System.out.println("The Average Is: "+Average/Num);
        }
    }
}*/

/*import java.util.Scanner;
class Demo
{
    public static void main(String args[])
    {
        try(Scanner sc=new Scanner(System.in))
        {
            System.out.print("Enter The First Number: ");
            int x=sc.nextInt();
            System.out.print("Enter The Second Number:");
            int y=sc.nextInt();
            int i=1;
            int Max=Math.max(x,y);
            int rem,gcd=1;
            do
            {
                if (y%x!=0)
                {
                    rem=y%x;
                    gcd=x%rem;
                }
                i++;
            }
            while(i<Max);
            System.out.println("GCD Of The Numbers Are:"+(int) gcd);
        }
    }
}*/

/*import java.util.Scanner;
class Demo
{
    public static void main(String args[])
    {
        try(Scanner sc=new Scanner(System.in))
        {
            System.out.println("Enter The Number: ");
            int num=sc.nextInt();
            int sum=0;
            System.out.print("(");
            for (int i=1;i<num;i++)
            {
                if (num%i==0)
                {
                    if (i<num)
                    {
                        System.out.print(i+"+");
                        sum=sum+i;
                    }
                }
            }
            System.out.print(")");
            System.out.println();
            if (sum==num)
            System.out.println("Perfect Number");
            else
            System.out.println("Not A Perfect Number");
        }
    }
}*/

/*import java.util.Scanner;
class Demo
{
    public static void main(String args[])
    {
        try(Scanner sc=new Scanner(System.in))
        {
            System.out.print("Enter The Base: ");
            int Base=sc.nextInt();
            System.out.print("Enter The Power:");
            int Power=sc.nextInt();
            int Value=1;
            for (int i=1;i<=Power;i++)
            {
                Value=Value*Base;
            }
            System.out.println(Base+" To The Power "+Power+" is: "+Value);
        }
    }
}*/

/*import java.util.Scanner;
class Demo
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter The Table For Printing: ");
        int TableOF=sc.nextInt();
        for (int i=1;i<=10;i++)
        {
            System.out.println(TableOF+" x "+i+" = "+TableOF*i);
        }
    }
}*/

/*import java.util.Scanner;
class Demo
{
    public static void main(String args[])
    {
        try(Scanner sc=new Scanner(System.in))
        {
            while(true)
            {
               int ComputerGuess=(int) (Math.random()*9+1);
               System.out.println("Compter Guess :"+ComputerGuess);
               System.out.print("Your Guess:");
               int YourGuess=sc.nextInt();
               if(YourGuess<ComputerGuess)
               {
                    System.out.println("Too Low, Try Again");
               }
               
               else if(YourGuess>ComputerGuess)
               {
                    System.out.println("Too High, Try Again");
               }
               if (YourGuess==ComputerGuess)
                {
                    System.out.println("Good Guess");
                    break;
                }
            }
        }
    }
}*/

/*import java.util.Scanner;
class Demo
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter A Number: ");
        int Num=sc.nextInt();
        int count=0;
        for (int i=1;i<=Num;i++)
        {
            if (Math.pow(3,i)<=Num)
            count++;
        }
        System.out.println("The Largest Power Of 3 Less Than Or Equal To "+Num+" is "+(int)Math.pow(3,count));
    }
}*/

/*import java.util.Scanner;
class Demo
{
    public static void main(String[] args)
    {
        try(Scanner sc = new Scanner(System.in);)
        {
            System.out.print("Enter an integer: ");
            int input = sc.nextInt();
            int Number=0;
            while (input > 0)
            {
            int digit = input % 10;
            if (digit != 0)
            {
                Number=digit*10+digit;
            }
            else
            {
                input=input/10;
            }
            }
            System.out.println("The Number Is: "+Number);
        }
    }
}*/


/*import java.util.Scanner;
class Demo
{
    public static void main(String args[])
    {
        try(Scanner sc =new Scanner(System.in))
        {
            System.out.print("Enter The Number Range To: ");
            int Num=sc.nextInt();
            int Sum1=0,Sum2=00;
            for (int i=1;i<=Num;i++)
            {
                Sum1=Sum1+((int)Math.pow(i,2));
            }
            for (int j=1;j<=Num;j++)
            {
                Sum2=Sum2+j;
            }
            System.out.println("THE SUM1: "+Sum1);
            System.out.println("The SUM2: "+((int)Math.pow(Sum2,2)));
            System.out.println("THE Required SUM Is: "+(((int)Math.pow(Sum2,2)-Sum1)));
        }
    }
}*/

/*import java.util.Scanner;
class Demo
{
    public static void main(String args[])
    {
        try(Scanner sc=new Scanner(System.in))
        {
            int sum=0,count=0;
            System.out.print("(");
            for (int i=1;i<=1000;i++)
            {
                if (i%3==0 || i%5==0)
                {
                    System.out.print(i+" ");
                    sum+=i;
                    count++;
                    if (count % 5 == 0)
                    {
                       System.out.println();
                    }
                }
            } 
        System.out.println(")");
        System.out.println("THe SUm Is:"+sum);
        }
    }
}*/

/*class Demo
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
}*/

/*import java.util.Scanner;
class Demo
{
    public static void main(String args[])
    {
        try(Scanner sc=new Scanner(System.in))
        {
            System.out.print("Enter The Number Range: ");
            int Num=sc.nextInt();
            int esum=0,osum=01;
            for (int i=1;i<=Num;i++)
            {
                if (i%2==0)
                {
                    esum+=i;
                }
                if (i%2!=0)
                {
                    osum*=i;
                }
            }
            System.out.println("The Even Series Sum Is: "+esum);
            System.out.println("The Even Series Product Sum Is: "+osum);
        }
    }
}*/

/*import java.util.Scanner;
class Demo
{
    public static void main(String args[])
    {
        try(Scanner sc=new Scanner(System.in))
        {
            System.out.print("Enter The Number To: ");
            int Num=sc.nextInt();
            for (int i=1;i<=Num;i++)
            {
                System.out.print(i);
                int Value=i+ ++i +i;
                if (i==1)
                System.out.println();
                else
                System.out.println(Value);
            }
        }
    }
}*/

/*import java.util.Scanner;
class Demo
{
	public static void main(String[] args)
	{
		Scanner sc= new Scanner (System.in);
		System.out.println("Enter first number ");
		int x = sc.nextInt();
		System.out.println("Enter second nbumber");
		int y = sc.nextInt();
		int sumx = 0,sumy= 0;
		for (int i = 1;i<=x/2;i++)
		{
			if (x%i==0)
			sumx+=i;
		}
		for (int j = 1;j<= y/2;j++)
		{ 
			if (y%j==0) 
			sumy+=j;
		}
			if(sumx==y&&sumy==x)
			{
				System.out.println("The numbers "+x+" & "+y+" are amicable");
			}
			else
			{
				System.out.println("The numbers "+x+" & "+y+" are not amicable");
			}
	}	
}*/

/*import java.util.Scanner;
class Demo
{
    public static void main(String args[])
    {
        try(Scanner sc=new Scanner(System.in))
        {
            System.out.println("Enter The Number To Be Checked: ");
            int Number=sc.nextInt();
            int count1=0,Rev=0,count2=0;
            boolean flag1,flag2;
            for (int i=1;i<=Number;i++)
            {
                if (Number%i==0)
                {
                    count1++;
                }
            }
            if (count1==2)
            {
                flag1=true;
                System.out.println("Prime Hai");
            }
            else
            {
                flag1=false;
                System.out.println("Prime Nahi Hai");
            }
            while(Number>0)
            {
                Rev=Rev*10+Number%10;
                Number/=10;
            }
            System.out.println("The Reverse Number: "+Rev);
            for (int j=1;j<=Rev;j++)
            {
                if (Rev%j==0)
                {
                    count2++;
                }
            }
            if (count2==2)
            {
                flag2=true;
                System.out.println("Prime Hai");
            }
            else
            {
                flag2=false;
                System.out.println("Prime Nahi Hai");
            }
            {
                if (flag1=true && flag2==true)
                {
                    System.out.println("Twisted Prime Hai Bhai");
                }
                else
                System.out.println("Twisted Prime Nahi Hai");
            }
        }
    }
}*/

/*import java.util.Scanner;
class Demo
{
    public static void main(String args[])
    {
        try(Scanner sc=new Scanner(System.in))
        {
            System.out.print("Enter A Number1: ");
            int Num1=sc.nextInt();
            System.out.print("Enter A Number2: ");
            int Num2=sc.nextInt();
            int count1=0,count2=0,count3=0;
            String temp1="",temp2="",temm="";
            boolean flag=false;
            /*for (int i=1;i<=Num1;i++)
            {
                if (Num1%i==0)
                {
                    temp1=temp1+i+" ";
                    count1++;
                }
            }
            if (count1==2)
            {
                System.out.print(temp1+"\n");
                System.out.println("Prime Hai");
            }
            else
            {
                System.out.println("Prime Nahi Hai");
            }
            {
            for (int j=1;j<=Num2;j++)
            {
                if (Num2%j==0)
                {
                    temp2=temp2+j+" ";
                    count2++;
                }
            }
            if (count2==2)
            {
                System.out.print(temp2+"\n");
                System.out.println("Prime Hai");
            }
            else
            {
                System.out.println("Prime Nahi Hai");
            }
            }
        }
    }
}*/

/*import java.util.Scanner;
public class Demo
{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the first and second number
        System.out.print("Enter the first number: ");
        int firstNumber = scanner.nextInt();

        System.out.print("Enter the second number: ");
        int secondNumber = scanner.nextInt();

        // Display prime numbers between the given range
        System.out.println("Prime numbers between " + firstNumber + " and " + secondNumber + ":");
        printPrimeNumbers(firstNumber, secondNumber);
    }

    // Function to check if a number is prime
    private static boolean isPrime(int num)
    {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    // Function to print prime numbers in a given range
    private static void printPrimeNumbers(int start, int end) {
        for (int i = start; i <= end; i++) {
            if (isPrime(i)) {
                System.out.print(i + " ");
            }
        }
    }
}*/

/*import java.util.Scanner;
class Demo
{
    public static void main(String args[])
    {
        try(Scanner sc = new Scanner(System.in))
        {
            System.out.print("Enter A Number1: ");
            int Num1 = sc.nextInt();
            System.out.print("Enter A Number2: ");
            int Num2 = sc.nextInt();
            System.out.println("Prime Numbers in the Range " + Num1 + " to " + Num2 + ":");
            for (int i = Num1; i <= Num2; i++) 
            {
                if (isPrime(i))
                {
                    System.out.print(i + " ");
                }
            }
    // Function to check if a number is prime
           private static boolean isPrime(int num)
           {
            if (num <= 1) 
            {
                return false;
            }
           for (int i = 2; i <= Math.sqrt(num); i++) 
           {
                if (num % i == 0)
                {
                   return false;
                }
            }
            return true;
            }
        }
    }
}*/

/*import java.util.Scanner;
class Demo
{
    public static void main(String args[])
    {
        try(Scanner sc=new Scanner(System.in))
        {
            System.out.print("Enter The Value Of M:");
            int m=sc.nextInt();
            System.out.print("Enter The Value Of N:");
            int n=sc.nextInt();
            for (int i=m;i<=n;i++)
            {
                int fact=1;
                for (int j=1;j<=i;j++)
                {
                    fact*=j;
                }
                System.out.println("Factorial of "+i+" is: "+fact);
                m++;
            }
        }
    }
}*/

/*import java.util.Scanner;
class Demo
{
    public static void main(String args[])
    {
        try(Scanner sc=new Scanner(System.in))
        {
            System.out.print("Enter The Range Limit: ");
            int Range=sc.nextInt();
            for (int i=1;i<=Range;i++)
            {
                for (int j=1;j<=10;j++)
                {
                    System.out.println(i+" x "+j+" = "+i*j);
                }
                System.out.println();
            }
        }
    }
}*/

/*class Demo
{
    public static void main(String args[])
    {
        for (int i=1;i<=5;i++)
        {
            for (int j=1;j<=i;j++)
            {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}*/

/*class Demo
{
    public static void main(String args[])
    {
        for (int i=1;i<=5;i++)
        {
            for (int j=1;j<=i;j++)
            {
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }
}*/

/*class Demo
{
    public static void main(String args[])
    {
        int count=1;
        for (int i=1;i<=5;i++)
        {
            for (int j=1;j<=i;j++)
            {
                System.out.print(count+" ");
                count++;
            }
            System.out.println();
        }
    }
}*/

/*class Demo
{
    public static void main(String args[])
    {
        for (int i=1;i<=5;i++)
        {
            for (int j=1;j<=i;j++)
            {
                System.out.print(j+" ");
            }
            System.out.println();
        }
    }
}*/

/*class Demo
{
    public static void main(String args[])
    {
        for (char i='A';i<='E';i++)
        {
            for (char j='A';j<=i;j++)
            {
                System.out.print(j+" ");
            }
            System.out.println();
        }
    }
}*/

/*class Demo
{
    public static void main(String args[])
    {
        for (int i=65;i<=69;i++)
        {
            for (int j=65;j<=i;j++)
            {
                System.out.print(((char) j)+(String)" ");
            }
            System.out.println();
        }
    }
}*/

/*class Demo
{
    public static void main(String args[])
    {
        for (int i=1;i<=5;i++)
        {
            for (int j=5;j>=i;j--)
            {
                System.out.print("$ ");
            }
            System.out.println();
        }
    }
}*/

/*class Demo
{
    public static void main(String args[])
    {
        for (int i=1;i<=5;i++)
        {
            for(int k=5-i;k>=1;k--)
            {
                System.out.print(" ");
            }
            for (int j=1;j<=i;j++)
            {
                System.out.print(i);
            }
            System.out.println();
        }
    }
}*/

/*import java.util.Scanner;
public class Demo
{
	public static void main(String[] args)
	{
		Scanner sc= new Scanner (System.in);
		System.out.print("Enter The Range:");
		int n = sc.nextInt();
		int sum = 0,count=2;
		int i,j;
		for( i = 1; i <=n;i++)
		{
			if(i!=1)
			System.out.print("(");
			for( j = 1; j<=i;j++)
			{
				System.out.print(j);	
				if (j+1<=i)
				System.out.print("+");
				sum +=j;
				count++;
			}
			if (i<n && i!=1)
			System.out.print(")+");
			else if(i!=1)
			System.out.print(")");
			else
				System.out.print("+");
		}
		System.out.println();
		System.out.println("Sum = "+sum);
	}
}*/

/*import java.util.Scanner;
class Demo
{
    public static void main(String args[])
    {
        try(Scanner sc=new Scanner(System.in))
        {
            double sum=0;
            System.out.print("Enter The Range: ");
            int Range=sc.nextInt();
            for (int i=1;i<=Range;i++)
            {
                sum=sum+(1/(double)Math.pow(i,2));
            }
            System.out.println("The Sum Of The Sequence Is: "+sum);
        }
    }
}*/

/*class Demo
{
    public static void main(String args[])
    {
        for (int i=1;i<=7;i++)
        {
            if (i%2!=0)
            {
            for(int k=7-i;k>=1;k--)
            {
                System.out.print(" ");
            }
            for (int j=1;j<=i;j++)
            {
                System.out.print("* ");
            }
            System.out.println();
            }
        }
    }
}*/

/*class Demo
{
    public static void main(String args[])
    {
        int row=5;
        for (int i=0;i<row;i++)
        {
            for (int j=5;j>0;j--)
            {
                if (j == i + 1 || i == row - 1)
                {
                    System.out.print("* ");
                } 
                else 
                {
                    System.out.print(j + " ");
                }
            }
            System.out.println();
        }
    }
}*/

/*class Demo
{
    public static void main(String args[])
    {
        System.out.println("The Shit Will Be Done: ");
        int X=Integer.parseInt(args[0]);
        int Y=Integer.parseInt(args[1]);
        System.out.println("The Quotient Is:"+X/Y);
        System.out.println("The Remainder Is:"+X%Y);
    }
}*/

/*class Demo
{
    public static void main(String args[])
    {
        System.out.println("The Shit Will Be Done More Properly: ");
        int X=Integer.parseInt(args[0]);
        int Y=Integer.parseInt(args[1]);
        System.out.println("The Result Is: "+(int)Math.pow(X,Y));
    }
}*/

/*class Demo
{
    public static void main(String args[])
    {
        System.out.println("The Shit Will Be Done More Properly: ");
        int X=(int)(Math.random()*6+1);
        int Y=(int)(Math.random()*6+1);
        System.out.println(X+" "+Y);
        System.out.println("The Result Is: "+(X+Y));
    }
}*/

/*class Demo
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
}*/

/*class Demo
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
}*/

/*class Demo
{
    public static void main(String args[])
    {
        System.out.println("The Shit Will Be Done More More More Properly: ");
        System.out.println("Enter The Value: ");
        char ch = args[0].charAt(0); 
        System.out.println("The ASCII Value The Letter Is: "+(int)ch);
    }
}*/

/*class Demo
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
}*/

/*class Demo
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
}*/

/*class Demo
{
    public static void main(String args[])
    {
        System.out.println("The Shit Will Be Done More More Properly: ");
        System.out.println("Enter The Values: ");
        double R=Double.parseDouble(args[1]);
        double H=Double.parseDouble(args[2]);
        System.out.println("The Surface Area Is: "+(Math.PI*Math.pow(R,2)+2*Math.PI*R*H));
    }
}*/

/*class Demo
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
        System.out.println("The Fucking Sum Will Be: "+(EndDigit+FirstDigit));
        System.out.println("7: Thala For A Reason");
    }
}*/

/*class Demo
{
    public static void main(String args[])
    {
        int count=1;
        for (int i=1;i<=5;i++)
        {
            for (int j=5;j>=i;j--)
            {
                System.out.print(count+"\t");
                count++;
            }
            System.out.println();
        }
    }
}*/

/*import java.util.Scanner;
class Demo
{
    public static void main(String args[])
    {
        try(Scanner sc=new Scanner(System.in))
        {
            System.out.print("Enter An Integer: ");
            int Number=sc.nextInt();
            int Reverse=0,NewNumber=0,i=1;
            if (Number>0)
            {
                System.out.println("Input Accepted");
                do
                {
                    if (Number%10!=0)
                    {
                        Reverse=Reverse*10+Number%10;
                        Number=Number/10;
                    }
                    else
                    {
                        Number=Number/10;
                    }
                }
                while(Number>0);
            }
            else
            {
                System.out.println("Aabe Lavde Thik Se Input De Naa BSDK");
            }
            do
            {
                NewNumber=NewNumber*10+Reverse%10;
                Reverse=Reverse/10;
            }
            while(Reverse>0);
            System.out.println("The Number Will Be: "+NewNumber);
        }
    }
}

/*class Demo
{
    public static void main(String args[])
    {
        int count=1;
        for (int i=1;i<=5;i++)
        {
            for (int j=5;j>=i;j--)
            {
                System.out.print(count+"\t");
                count++;
            }
            System.out.println();
        }
    }
}*/

/*import java.util.Scanner;
class Demo
{
    public static void main(String args[])
    {
        try(Scanner sc=new Scanner(System.in))
        {
            System.out.print("Enter An Integer: ");
            int Number=sc.nextInt();
            int Rev1=0,Rev2=0,i=1;
            if (Number>0)
            {
                System.out.println("Input Accepted");
                
                do
                {
                    if (Number%10==0)
                {
                    Number=Number/10;
                }
                else
                {
                    Rev1=Rev1*10+Number%10;
                    Number=Number/10;
                }
                }
                while(Number>0);
            }
            else
            {
                System.out.println("Nikal Bey BSDK");
            }
            do
            {
                Rev2=Rev2*10+Rev1%10;
                Rev1=Rev1/10;
                i++;
            }
            while(Rev1>0);
            System.out.println("The Number Will Be: "+Rev2);
        }
    }
}*/

/*import java.util.Scanner;
class Demo
{
    public static void main(String args[])
    {
        try(Scanner sc=new Scanner(System.in))
        {
            System.out.print("Enter The Range: ");
            int Range=sc.nextInt();
            int esum=0,osum=1;
            for (int i=1;i<=Range;i++)
            {
                if (i%2==0)
                esum+=i;
                else
                osum*=i;
            }
            System.out.println("The Even Sum Series Is: "+esum);
            System.out.println("The Odd Sum Series Is: "+osum);
        }
    }
}*/

/*import java.util.Scanner;
class Demo
{
    public static void main(String args[])
    {
        try(Scanner sc=new Scanner(System.in))
        {
            System.out.println("Haan Lavde Calculator Chalana Hai Tereko");
            System.out.println("BSDK Toh Calculator App Pe Chala Naa Idhar Kaha");
            System.err.println("Chal BC Kar Le Kaam");
            System.out.print("\n"+"Enter Two Operands: \n");
            double Num1=sc.nextDouble();
            double Num2=sc.nextDouble();
            System.out.println("Enter Your Choice");
            String Choice=sc.next();
            char ch=Choice.charAt(0);
            double result;
            switch(ch)
            {
                case '+':result=Num1+Num2;
                System.out.println("The Sum Is: "+result);
                break;
                case '-':
                if (Num1>=Num2)
                System.out.println("The Difference Is: "+(Num1-Num2));
                else
                System.out.println("The Difference Is: "+(Num2-Num1));
                break;
                case '*':result=Num1*Num2;
                System.out.println("The Product Is: "+result);
                break;
                case '/':
                if (Num2==0)
                System.out.println("Lavde Input Toh Thik Se De");
                else if (Num1>=Num2)
                System.out.println("The Division Is: "+Num1/Num2);
                break;
                default:System.out.println("Haan Lavde Do Lund Maango Burh BSDK");
            }
        }
    }
}*/

/*import java.util.Scanner;
class Demo
{
    public static void main(String args[])
    {
        try(Scanner sc=new Scanner(System.in))
        {
            System.out.print("Enter The Units Consumed: ");
            double Units,Amount;
            Units=sc.nextDouble();
            System.out.print("Enter The Choice: ");
            String Choice=sc.next();
            char ch=Choice.charAt(0);
            if (Units <= 50)
            {
                Amount = Units * 3.0;
            } 
            else if (Units <= 200)
            {
                Amount = 50 * 3.0 + (Units - 50) * 4.8;
            } 
            else if (Units <= 400) 
            {
                Amount = 50 * 3.0 + 150 * 4.8 + (Units - 200) * 5.8;
            } 
            else 
            {
                Amount = 50 * 3.0 + 150 * 4.8 + 200 * 5.8 + (Units - 400) * 6.2;
            }
            switch(ch)
            {
                case 'Y':
                System.out.println("Total Amount: "+Amount);
                System.out.println("Discount: "+(Amount*((double)3/100)));
                break;
                case 'N':
                System.out.println("Total Amount: "+Amount);
                break;
            }
        }
    }
}*/

/*class Demo
{
    public static void main(String[] args)
    {
        int totalStudents = 90;
        int boys = 45;
        int totalGradeO = (int) (totalStudents * 0.5);
        int boysWithGradeO = 20;
        int girlsWithGradeO = totalGradeO - boysWithGradeO;
        // Display the result
        System.out.println("Total number of girls getting Grade \"O\": " + girlsWithGradeO);
    }
}*/

/*class Demo
{
    public static void main(String args[])
    {
        int Num=10,count=1;
        System.out.println("A\tB\tPow(A,B)");
        for (int i=3;i<=Num;i++)
        {
            if (i%2!=0)
            {
                System.out.println(i+"\t"+count+"\t"+(int)Math.pow(i,count));
                count++;
            }
        }
    }
}*/

/*class Demo
{
    public static void main(String args[])
    {
        double Num1=Double.parseDouble(args[0]);
        double Num2=Double.parseDouble(args[1]);
        if (Num1%Num2==0)
        System.out.println((int)Num1+" Is Divisible by "+(int)Num2+" : "+true);
        else
        System.out.println((int)Num1+" Is Divisible by "+(int)Num2+" : "+false);
    }
}*/

/*import java.util.Scanner;
class Demo
{
    public static void main(String args[])
    {
        try(Scanner sc=new Scanner(System.in))
        {
            System.out.print("Enter The Units Consumed: ");
            double Units,Amount;
            Units=sc.nextDouble();
            if (Units <= 50)
            {
                Amount = Units * 3.0;
            } 
            else if (Units >= 51 && Units<=200)
            {
                Amount = 50 * 3.0 + (Units - 50) * 4.8;
            } 
            else if (Units >= 2001 && Units<=400) 
            {
                Amount = 50 * 3.0 + 150 * 4.8 + (Units - 200) * 5.8;
            } 
            else 
            {
                Amount = 50 * 3.0 + 150 * 4.8 + 200 * 5.8 + (Units - 400) * 6.2;
            }
            System.out.println("The Electricity Bill Is: "+Amount);
        }
    }
}*/

/*class Demo
{
    public static void main(String args[])
    {
        int a=5+7-6*8/2%10;
        int b=a+2-9%6/3+(-7);
        System.out.println(a+" "+b);
        boolean p=(++a>61 && --b<13);
        System.out.println(p);
        System.out.println(b>>5);
    }
}*/

/*class Demo
{
    public static void main(String args[])
    {
        int z=-4;
        int k=z++ + ++z+ ++z;
        System.out.println(z+" "+k);
        int t=--k +k++ +z++;;
        int p=t++ -(t%5)+ (p=t);
        System.out.println(z+" "+k+" "+t+" "+p);
    }
}*/

/*class Demo
{
    public static void main(String args[])
    {
        int a=Integer.MAX_VALUE;
        System.out.println(a);
        System.out.println(a+9);
        System.out.println(-a-8);
        System.out.println(a*3);
        System.out.println(a>>24);
    }
}*/

/*import java.util.Scanner;
class Demo
{
    public static void main(String args[])
    {
        try(Scanner sc=new Scanner(System.in))
        {
            System.out.print("Enter A Number: ");
            int Number=sc.nextInt();
            int count=0,sum=0,j=1;
            String Temp="";
            for (int i=1;i<=Number;i++)
            {
                if (i%j==0)
                {
                    count++;
                    if (count==2)
                    {
                        System.out.print(j+"+");
                    }
                    j++;
                }
            }
        }
    }
}*/


/*import java.util.Scanner;
public class Demo
{

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = scanner.nextInt();
        if (isSumOfTwoPrimes(number))
        {
            System.out.println(number + " can be expressed as the sum of two prime numbers.");
        } 
        else
        {
            System.out.println(number + " cannot be expressed as the sum of two prime numbers.");
        }

        scanner.close();
    }

    public static boolean isSumOfTwoPrimes(int num)
    {
        for (int i = 2; i <= num / 2; ++i)
        {
            if (isPrime(i) && isPrime(num - i))
            {
                return true;
            }
        }
        return false;
    }

    public static boolean isPrime(int n) 
    {
        if (n <= 1)
        {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); ++i)
        {
            if (n % i == 0)
            {
                return false;
            }
        }
        return true;
    }
}*/

/*class Demo
{
    public static void main(String args[])
    {
        System.out.print("Hello World\n");
        System.out.print("Amulya"+"\n");
        System.out.print("Shri");
        int a=5000_00;
        System.out.println(a-1000_00);
    }
}*/

/*class Demo
{
    public static void main(String args[])
    {
        System.out.println("My Name Is Amulya Shrivastava");
        System.out.println("B.Tech CSE"+"\t"+"\"Bhak\"");
    }
}*/

/*class Demo
{
    public static void main(String args[])
    {
        int Var1,Var2,Sum,Difference;
        Var1=5;
        Var2=10;
        Sum=Var1+Var2;
        Difference=Var2-Var1;
        System.out.println("Variable1: "+Var1);
        System.out.println("Variable2: "+Var2);
        System.out.println("Sum: "+Sum);
        System.out.println("Difference: "+Difference);
    }
}*/

/*class Demo
{
    public static void main(String args[])
    {
        String Name;
        double V1,V2,Avg;
        Name="Amulya Shrivastava";
        V1=95;
        V2=95;
        Avg=(V1+V2)/2;
        System.out.println(Name+" Has Secured "+V1+" In Subject1 And "+V2+" In Subject2 \n And Has The Average Of "+Avg);
    }
}*/

/*class Demo
{
    public static void main(String args[])
    {
        System.out.println(5);
        System.out.println('1');
        System.out.println(2+'3');
        System.out.println(2+"3"+5);
        System.out.println("2"+3+5);
        System.out.println((int)5/6);
        System.out.println((float)(5/6));
        System.out.println('2'+'3');
    }
}*/

/*class Demo
{
    public static void main(String args[])
    {
        final int A=5;
        System.out.print(A);
    }
}*/

/*class Demo
{
    public static void main(String args[])
    {
        final int A=056;
        System.out.print(A);
    }
}*/

/*class Demo
{
    public static void main(String args[])
    {
        final double A=5.63E-7;
        System.out.print(A);
    }
}*/

/*class Demo
{
    public static void main(String args[])
    {
        byte b=56;
        short s;
        s=b;
        System.out.println(s);
    }
}*/

/*class Demo
{
    public static void main(String args[])
    {
        byte b=56;
        short s=56;
        b=(byte)s;
        System.out.println(b);
    }
}*/

/*class Demo
{
    public static void main(String args[])
    {
        int a=5,b=10,c;
        c=a+b;
        System.out.print(c+" ");
        c=-a;
        System.out.print(c+" ");
        c=+c;
        System.out.print(c+" ");
        c=-c;
        System.out.print(c+" ");
    }
}*/

/*class Demo
{
    public static void main(String args[])
    {
        int a=5,b=10,c;
        double d=1.0,e;
        c=a/b;
        System.out.print(c+" ");
        e=a/b;;
        System.out.print(e+" ");
        e=d*5.5;
        System.out.print(e+" ");
        e=d*(a/b);
        System.out.print(e+" ");
    }
}*/

/*class Demo
{
    public static void main(String args[])
    {
        int a=5;a++;
        System.out.println(a);
        System.out.println(++a);
        System.out.println(a--);
        System.out.println(--a);
        System.out.println(++a);
    }
}*/

/*class Demo
{
    public static void main(String args[])
    {
        int a=5;;
        System.out.println(a++ + ++a + a++);
    }
}*/

/*class Demo
{
    public static void main(String args[])
    {
        int a=5,b=10;
        System.out.println(a>b);
        System.out.println(a<=b);
        System.out.println(a==b);
        System.out.println(a==b/2);
    }
}*/

/*class Demo
{
    public static void main(String args[])
    {
        boolean a=true,b=false;
        System.out.println(a&b);
        System.out.println(a|b);
        System.out.println(a^b);
        System.out.println(!b);
        System.out.println(!a);
        System.out.println(a&&b);
        System.out.println(a||b);
    }
}*/

/*class Demo
{
    public static void main(String args[])
    {
        int a=6,b=3;
        System.out.println(~b);
        System.out.println(~a);
        System.out.println(a&b);
        System.out.println(a|b);
        System.out.println(a^b);
        System.out.println(a<<2);
        System.out.println(b>>2);
        System.out.println(a>>>2);
    }
}*/

/*class Demo
{
    public static void main(String args[])
    {
        int a=5;
        boolean b=a>5&a++>6;
        System.out.println(b);
        boolean c=a>5&&a++>6;
        System.out.println(c);
    }
}*/

/*class Demo
{
    public static void main(String args[])
    {
        int a=5;
        boolean b;
        System.out.println((boolean) ((a!=0) && (a)>0));
    }
}*/

/*class Demo
{
    public static void main(String args[])
    {
        int a=5,b=10,c;
        c=(a>b)?a:b;
        System.out.print(c);
        int d=1,e=2,f=3,g;
        d=e;
        System.out.println(d);
    }
}*/

/*class Demo
{
    public static void main(String args[])
    {
        int a=5,b;
        b=(83-77)+(55/5);
        float g=(float)(5/1.0);
        System.out.println(a+" "+b+" "+g);
    }
}*/

/*class Demo
{
    public static void main(String args[])
    {
        boolean a=false,b=false,c=false,d;
        d=(a=true)||(b==true)&&(c==true);
        System.err.println(d);
        int g=5;
        boolean h=false && (g++>5);
        System.err.println(h);
    }
}*/

/*import java.util.Scanner;
class Demo
{
    public static void main(String args[])
    {
        try(Scanner sc=new Scanner(System.in))
        {
            float base,gross,hra,perf,bonus=0;
            System.out.println("Enter The Details: ");
            base=sc.nextFloat();
            perf=sc.nextFloat();
            hra=(float) 0.2*base;
            if (perf>8)
            bonus=0.25f*base;
            gross=base+hra+bonus;
            System.out.println("Gross: "+gross);
        }
    }
}*/

/*class Demo
{
    public static void main(String args[])
    {
        int a=5,b=10;
        if (a>b);;;;;;;;;;;;
        a++;
        b++;
        System.err.println(a+" "+b);
    }
}*/

/*mport java.util.Scanner;
class Demo
{
    public static void main(String args[])
    {
        int Marks;
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter The Marks: ");
        Marks=sc.nextInt();
        if (Marks>=40)
        System.out.println("Pass Hai Lavde");
        else
        System.out.println("Fail Ho Gaya Lavde");
        if (Marks<40)
        System.out.println("Fail Ho Gaya Lavde");
    }
}*/

/*import java.util.Scanner;
class Demo
{
    public static void main(String args[])
    {
        try(Scanner sc=new Scanner(System.in))
        {
            System.out.println("Enter The Numbers: ");
            int a=sc.nextInt();
            int b=sc.nextInt();
            int c=sc.nextInt();
            if (a>b)
            {
                if (a>c)
                System.out.println(a+" Sabse bada hai Lavde");
                else
                System.out.println(c+" Sabse bada hai Lavde");
            }
            else
            {
                if (b>c)
                System.out.println(b+" Sabse bada hai Lavde");
                else
                System.out.println(c+" Sabse bada hai Lavde");
            }
        }
    }
}*/

/*import java.util.Scanner;
class Demo
{
    public static void main(String args[])
    {
        try(Scanner sc=new Scanner(System.in))
        {
            System.out.print("Enter The Day Number: ");
            int DayNumber=sc.nextInt();
            if (DayNumber==0)
            System.out.println("Sunday Hai Lavde Soo Jaa");
            else if (DayNumber==1)
            System.out.println("Monday Hai Bhavde");
            else if (DayNumber==2)
            System.out.println("Tuesday Hai Bhavde");
            else if (DayNumber==3)
            System.out.println("Wednesday Hai Bhavde");
            else if (DayNumber==4)
            System.out.println("Thursday Hai Bhavde");
            else if (DayNumber==5)
            System.out.println("Friday Hai Bhavde");
            else if (DayNumber==6)
            System.out.println("Saturday Hai Bhavde");
        }
    }
}*/

/*import java.util.Scanner;
class Demo
{
    public static void main(String args[])
    {
        try(Scanner sc=new Scanner(System.in))
        {
            System.out.print("Enter The Day Number: ");
            int DayNumber=sc.nextInt();
            switch(DayNumber)
            {
            case 0:
            System.out.println("Sunday Hai Lavde Soo Jaa");
            break;
            case 1:
            System.out.println("Monday Hai Bhavde");
            break;
            case 2:
            System.out.println("Tuesday Hai Bhavde");
            break;
            case 3:
            System.out.println("Wednesday Hai Bhavde");
            break;
            case 4:
            System.out.println("Thursday Hai Bhavde");
            break;
            case 5:
            System.out.println("Friday Hai Bhavde");
            break;
            case 6:
            System.out.println("Saturday Hai Bhavde");
            break;
            }
        }
    }
}*/

/*import java.util.Scanner;
class Demo
{
    public static void main(String args[])
    {
        try(Scanner sc=new Scanner(System.in))
        {
            System.out.print("Enter The Grade: ");
            String Grade=sc.next();
            switch(Grade)
            {
            case "A":
            System.out.println("90-100");
            break;
            case "B":
            System.out.println("80-90");
            break;
            case "C":
            System.out.println("70-80");
            break;
            case "D":
            System.out.println("60-70");
            break;
            case "E":
            System.out.println("50-60");
            break;
            case "F":
            System.out.println("40-50");
            break;
            default:System.out.println("Fail");
            break;
            }
        }
    }
}*/

/*class Demo
{
    public static void main(String aargs[])
    {
        int i=1;
        while(i<=10)
        {
            System.out.print(i+" ");
            i++;
        }
    }
}*/

/*class Demo
{
    public static void main(String aargs[])
    {
        for (int i=1,count=1;i<=10;i++)
        {
            System.out.print(count+" ");
            count++;
        }
    }
}*/

/*class Demo
{
    public static void main(String aargs[])
    {
        int i=10;
        while(i<=20)
        {
            System.out.print((i+1)+" ");
            i++;
        }
    }
}*/

/*class Demo
{
    public static void main(String aargs[])
    {
        int i=10;
        while(i>=1)
        {
            System.out.print(i+" ");
            i--;
        }
    }
}*/

/*class Demo
{
    public static void main(String aargs[])
    {
        int i=1;
        do
        {
            System.out.print(i+" ");
            i++;
        }
        while(i<=10);
    }
}*/

/*import java.util.Scanner;
class Demo
{
    public static void main(String aargs[])
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int i=1;
        do
        {
            System.out.print(i+" ");
            i++;
        }
        while(i<=n);
    }
}*/

/*import java.util.Scanner;
class Demo
{
    public static void main(String aargs[])
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int i=1,sum=0;
        while(i<=n)
        {
            sum+=i;
            i++;
        }
        System.err.println(sum);
    }
}*/

/*import java.util.Scanner;
class Demo
{
    public static void main(String aargs[])
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int i=1,sum=0;
        while(i<=n)
        {
            if (i%2!=0)
            sum+=i;
            i++;
        }
        System.err.println(sum);
    }
}*/

/*import java.util.Scanner;
class Demo
{
    public static void main(String args[])
    {
        try(Scanner sc=new Scanner(System.in))
        {
            double a,b;
            String Choice;
            boolean flag=true;
            do
            {
                System.out.print("Enter The Two Integer: ");
                a=sc.nextInt();
                b=sc.nextInt();
                System.out.print("Enter Your Choice: ");
                Choice=sc.next();
                double Res;
                switch(Choice)
                {
                    case "+":
                    System.out.println("The Addition Is: "+(a+b));
                    break;
                    case "-":
                    if (a>b)
                    System.out.println("The Substarction Is: "+(a-b));
                    else
                    System.out.println("The Substraction Is: "+(b-a));
                    break;
                    case "*":
                    System.out.println("The Product Is: "+(a*b));
                    break;
                    case "/":
                    if (b!=0)
                    System.out.println("The Division Is: "+(a/b));
                    break;
                    default:
                    System.out.println("Naah Exit");
                    flag=!flag;
                    break;
                }
            }
            while(!flag);
        }
    }
}*/

/*import java.util.Scanner;
class Demo
{
    public static void main(String args[])
    {
        try(Scanner sc=new Scanner(System.in))
        {
            System.out.print("Enter The Number: ");
            int Number=sc.nextInt();
            int Sum=0;
            do
            {
                Sum+=Number%10;
                Number/=10;
            }
            while(Number>0);
            System.out.println("The Sum IS: "+Sum);
        }
    }
}*/

/*import java.util.Scanner;
class Demo
{
    public static void main(String args[])
    {
        try(Scanner sc=new Scanner(System.in))
        {
            System.out.print("Enter An Integer: ");
            int Number=sc.nextInt();
            int rev=0;
            while(Number>0)
            {
                rev=rev*10+Number%10;
                Number/=10;
            }
            System.out.println("Enter The Reverse Number: "+rev);

        }
    }
}*/

/*import java.util.Scanner;
class Demo
{
    public static void main(String args[])
    {
        try(Scanner sc=new Scanner(System.in))
        {
            int fact=1;
            System.out.print("Enter An Integer: ");
            int Number=sc.nextInt();
            for (int i=1;i<=Number;i++)
            {
                fact*=i;
            }
            System.out.println("The Factorial Of "+Number+" Is: "+fact);
        }
    }
}*/

/*class Demo
{
    public static void main(String args[])
    {
        int i,j;
        for (i=0,j=5;i<j,;i++,j--)
        {
            System.out.println(i+" "+j);
        }
    }
}*/

/*class Demo
{
    public static void main(String args[])
    {
        int i;
        for (i=1;i<=10;i++)
        {  
            System.out.println(i);
        }
    }
}*/

/*import java.util.Scanner;
class Demo
{
    public static void main(String args[])
    {
        try(Scanner sc=new Scanner(System.in))
        {
            int Number;
            System.out.println("Enter An Positive Integer: ");
            Number=sc.nextInt();
            int count=0;
            for (int i=1;i<=Number;i++)
            {
                if (Number%i==0)
                count++;
            }
            if (count==2)
            System.out.println("Prime Number");
            else
            System.out.println("Not A Prime Number");
        }
    }
}*/

/*import java.util.Scanner;
class Demo
{
    public static void main(String args[])
    {
        try(Scanner sc=new Scanner(System.in))
        {
            int Number;
            System.out.println("Enter An Positive Integer: ");
            Number=sc.nextInt();
            int count=0;
            for (int i=2;i<=Number/2;i++)
            {
                if (Number%i==0)
                count++;
            }
            if (count==0)
            System.out.println("Prime Number");
            else
            System.out.println("Not A Prime Number");
        }
    }
}*/

/*import java.util.Scanner;
class Demo
{
    public static void main(String args[])
    {
        try(Scanner sc=new Scanner(System.in))
        {
            int Number;
            System.out.println("Enter An Positive Integer: ");
            Number=sc.nextInt();
            boolean flag=true;
            int count=0;
            for (int i=2;i<=Number/2;i++)
            {
                if (Number%i==0)
                {
                    flag=false;
                    break;
                }
                
            }
            if (flag)
            System.out.println("Prime Number");
            else
            System.out.println("Not A Prime Number");
        }
    }
}*/

/*import java.util.Scanner;
class Demo
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int input,Sum=0;
        do
        {
            System.out.println("Enter A Number: ");
            input=sc.nextInt();
            if (input!=0)
            Sum+=Sum+input;
            else
            break;
        }
        while(input!=0);
        System.out.println("Sum: "+Sum);
    }
}*/

/*import java.util.Scanner;
class Demo
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int input,Sum=0;
        while(true)
        {
            System.out.println("Enter A Number: ");
            input=sc.nextInt();
            if (input!=0)
            Sum+=Sum+input;
            else
            break;
        }
        System.out.println("Sum: "+Sum);
    }
}*/

/*import java.util.Scanner;
class Demo
{
    public static void main(String args[])
    {
        try(Scanner sc=new Scanner(System.in))
        {
            int Sum=0;
            for (;;)
            {
                System.out.println("Enter An Integer: ");
                int Input=sc.nextInt();
                if (Input!=0)
                Sum+=Input;
                else
                break;
            }
            System.out.println("The Sum Is: "+Sum);
        }
    }
}*/

/*class Demo
{
    public static void main(String args[])
    {
        for (int i=0;i<=4;i++)
        {
            System.out.println('*');
        }
    }
}*/

/*class Demo
{
    public static void main(String args[])
    {
        for (int i=0;i<=4;i++)
        {
            for (int j=0;j<=i;j++)
            {
                System.out.print('*');
            }
            System.out.println();
        }
    }
}*/

/*class Demo
{
    public static void main(String args[])
    {
        int count=1;
        for (int i=1;i<=5;i++)
        {
            for (int j=1;j<=i;j++,count++)
            {
                System.out.print(count +"\t");
            }
            System.out.println();
        }
    }
}*/

/*class Demo
{
    public static void main(String args[])
    {
        for (int i=1;i<=5;i++)
        {
            for (int j=5;j>=i;j--)
            {
                System.out.print(j+" ");
            }
            System.out.println();
        }
    }
}*/

/*class Demo
{
    public static void main(String args[])
    {
        for (int i=0;i<=4;i++)
        {
            
            for (int j=4;j>=i;j--)
            {
                System.out.print(" ");
            }
            for (int k=5;k>=5-i;k++)
            {
                System.out.print(k);
            }
            System.out.println();
        }
    }
}*/

/*import java.util.Scanner;
class Demo
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter An Integer: ");
        int Number=sc.nextInt();
        int i=1;
        while(Number>=0)
        {
            System.out.println(Number+" x "+i+" = "+i*Number);
            i++;
            if (i==11)
            break;
        }
    }
}*/

/*import java.util.Scanner;
class Demo
{
    public static void main(String args[])
    {
        try(Scanner sc=new Scanner(System.in))
        {
            System.out.println("Enter The Range: ");
            int m=sc.nextInt();
            int n=sc.nextInt();
            int count=0,temp=0;
            for (int i=m;i<=n;i++)
            {
                for (int j=1;j<=n;j++)
                {
                    if(i%j==0)
                    {
                        temp=temp+i;
                        count++;
                    }
                    if (count==2)
                    System.out.println(temp+" ");
                }
            }
        }
    }
}*/

/*class Demo
{
    public static void main(String args[])
    {
        for (int i=1;i<=10;i++)
        {
            boolean flag=true;
            for(int j=2;j<=5;j++)
            {
                if (i%j==0)
                {
                    flag=false;
                    break;
                }
            }
            if (flag)
            System.out.println(i+" ");
        }
    }
}*/

/*class Demo
{
    public static void main(String args[])
    {
        int Sum1=0,Sum2=0;
        for (int i=0;i<=3;i++)
        {
            int fact=1;
            for (int j=1;j<=i;j++)
            {
                if (i%j==0)
                {
                    fact*=j;
                    Sum1+=fact;
                }
                else
                {
                    fact*=j;
                    Sum2+=fact;
                }
            }       
        }
        System.out.println("The Result Is: "+(Sum1-Sum2));
    }
}*/

/*class Demo
{
    public static void main(String args[])
    {
        for (int i=1;i<=10;i++)
        {
            for (int j=1;j<=10;j++)
            {
                System.out.print(j+" ");
            }
            System.out.println();
        }
    }
}*/

/*class Demo
{
    public static void main(String args[])
    {
        outer:for (int i=1;i<=10;i++)
        {
            inner:for (int j=1;j<=10;j++)
            {
                System.out.print(" "+j);
                if (j>=i)
                {
                    System.out.println();continue outer;
                }
            }
        }
    }
}*/

/*public class Demo
 {
    public static void main(String[] args) 
    {
        for (int i = 5; i >= 1; i--) 
        {
            for (int j=4; j >5-i; j--)
            {
                System.out.print(" ");
            }
            for (int k = i; k <= 5; k++)
            {
                System.out.print(k);
            }
            System.out.println();
        }
    }
}*/

/*public class Demo
{
    public static void main(String[] args)
    {
        int count = 0;
        int num = 2,sum=0;
        while (count < 10)
        {
            boolean isPrime = true;
            // Check for divisibility from 2 to the square root of num
            for (int i = 2; i<=num/2; i++)
            {
                if (num % i == 0)
                {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime)
            {
                sum=sum+num;
                System.out.print(num + " ");
                count++;
            }
            num++;
        }
        System.out.println();
        System.out.println("Sum: "+sum);
    }
}*/

/*class Demo
{
    public static void main(String args[])
    {
        char direction = 'N';
switch(direction)
{
case 'N':
System.out.println("North");
break;
case 'E':
System.out.println("East");
break;
case 'W':
System.out.println("West");
break;
case 'S':
System.out.println("South");
}
}
}*/

/*class Code1
{
    public static void main(String args[])
    {
    	int a = 5;
int b = 10;
boolean c=false;
if (a == b >> 1 || c==true)
{
System.out.println("ITER");
}
else
{
System.out.println("SOA");
}
    }
}*/

/*class Demo
{
    public static void main(String args[])
    {
        int a=-13-2*5-4;
        int b=a/8*4%5+6;
        System.out.println(a+" "+b);
        a&=~a;
        b=-a--;
        System.out.println(a+" "+b);
    }
}*/

/*class Demo
{
    public static void main(String args[])
    {
        int a=2,b=5,c=7;
       System.out.println(a<b&&a++<c);
       System.out.println(a++ +b-- *c);
        System.out.println(c++ -b +a);
    }
}*/

/*class Demo
{
    public static void main(String args[])
    {
        int x=-7,a=5,b=5;
        boolean k;
        System.out.println (x>>1);
        System.out.println("Hello" + 10 + 15);
        k=(a<b)&&(+ +b==a);
        System.out.println(b+" "+k);
    }
}*/



/*public class Demo
{
    public static void main(String[] args)
    {
        int count = 0;
        int num = 2,sum=0;
        while (count < 10)
        {
            boolean isPrime = true;
            // Check for divisibility from 2 to the square root of num
            for (int i = 2; i<=num/2; i++)
            {
                if (num % i == 0)
                {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime)
            {
                sum=sum+num;
                System.out.print(num + " ");
                count++;
            }
            num++;
        }
        System.out.println();
        System.out.println("Sum: "+sum);
    }
}*/

/*import java.util.Scanner;
class Demo
{
    public static void main(String args[])
    {
        try(Scanner sc=new Scanner(System.in))
        {
           System.out.println("Enter A Number: ");
           int Num=sc.nextInt(); 
           int count=0,sum=0;
           for (int i=2;i<Num/2;i++)
           {
               if (Num%i==0)
               {
                  sum+=i;
                  count++;
               }
           }
           if (count==0)
           System.out.println("Prime "+sum);
           else
           System.out.println("Not Prime");
        }
    }
}*/

/*class Demo
{
    public static void main(String args[])
    {
        for (int i=1;i<=5;i++)
        {
            for (int j=4;j>=i;j--)
            {
                System.out.print(" ");
            }
            for (int k=1;k<=i;k++)
            {
                System.out.print("$");
            }
            System.out.println();
        }
    }
}*/

/*class Demo
{
    public static void main(String args[])
    {
        int a,b,c;
        a=-13+2*7-14;
        b=a++ +--a;
        System.out.println(a+" "+b);
        c=a>>2*b-- +b++;
        System.out.println(a+" "+b+" "+c);
    }
}*/

class Demo
{
    public static void main(String args[])
    {
        int a,b;
        a=12+21*3-9/2;
        b=14-32*4+175/8-3;
        if (++a>71 && --b<20)
        {
            System.out.println("a="+a+"b="+b);
        }
        if (b--==-97 || a--<100)
        {
            System.out.println("a="+a+"b="+b);
        }
    }
}