/*import java.io.*;
class Grade9
{
char ch;
String p;
void accept()throws IOException
{
BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
System.out.println("Enter an Alphabet:");
ch=input.readLine().charAt(0);
}
void calc()
{
p=(ch=='A'||ch=='a')?"Achitect":(ch=='B'||ch=='b')?"Banker":(ch=='C'||ch=='c')?"Camerman":(ch=='D'||ch=='d')?"Drummer":
(ch=='E'||ch=='e')?"Engineer":"Null";
}
void disp()
{
System.out.println("Profession:"+p);
}
public static void main(String args[])throws IOException
{
Grade9 ob=new Grade9();
ob.accept();
ob.calc();
ob.disp();
}
}*/
/*import java.io.*;
class Grade9
{
int a;
String s,g;
void accept()throws IOException
{
BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
System.out.println("Enter Gender And Age:");
g=input.readLine();
a=Integer.parseInt(input.readLine());
}
void calc()
{
switch (g)
{
case "Male":s=(a>=21)?"He Is Eligible For Marriage":"He Is Not Eligible For Marriage";
break;
case "Female":s=(a>=18)?"She Is Eligible For Marriage":"She Is Not Eligible For Marriage";
break;
}
}
void disp()
{
System.out.println(s);
}
public static void main(String args[])throws IOException
{
Grade9 ob=new Grade9();
ob.accept();
ob.calc();
ob.disp();
}
}*/
/*class Grade9
{
public static void Accept()
{
System.out.println("Humpy Dumpy Sat an a Wall");
System.out.println("Humpy Dumpy Had a Great Fall");
}
public static void main(String args[])
{
Accept();
}
}*/
/*class Grade9
{
void accept()
{
System.out.println("Humpy Dumpy Sat an a Wall");
System.out.println("Humpy Dumpy Had a Great Fall");
}
public static void main(String args[])
{
Grade9 ob=new Grade9();
ob.accept();
}
}*/
/*class Grade9
{
public static void calcspeed(double d,double t)
{
double s;
s=d/t;
System.out.println("Speed:"+s);
}
public static void calcacc(double s,double t)
{
double a;
a=s/t;
System.out.println("Accleration:"+a);
}
public static void main(String args[])
{
calcspeed(900.0,7.5);
calcacc(800.0,6.5);
}
}*/
/*class Grade9
{
void calcspeed(double d,double t)
{
double s;
s=d/t;
System.out.println("Speed="+s);
}
public static void main(String args[])
{
Grade9 ob=new Grade9();
ob.calcspeed(900.0,7.5);
}
}*/
/*import java.io.*;
class Grade9
{
void calcspeed(double d,double t)
{
double s;
s=d/t;
System.out.println("Speed="+s);
}
public static void main(String args[])throws IOException
{
BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
double d1,t1;
System.out.println("Enter The Distance and Time:");
d1=Double.parseDouble(input.readLine());
t1=Double.parseDouble(input.readLine());
Grade9 ob=new Grade9();
ob.calcspeed(d1,t1);
}
}*/
/*class Grade9
{
public static void calcSXD(double p,double r,double t)
{
double si;
si=(p*r*t)/100.0;
System.out.println("Simple Interest:"+si);
}
public static void main(String args[])
{
calcSXD(7000,8,6);
}
}*/
/*import java.io.*;
class Grade9
{
void calcSXD(double p,double r,double t)
{
double si;
si=(p*r*t)/100.0;
System.out.println("Simple Interest:"+si);
}
public static void main(String args[])throws IOException
{
BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
double p1,r1,t1;
System.out.println("Enter The Values:");
p1=Double.parseDouble(input.readLine());
r1=Double.parseDouble(input.readLine());
t1=Double.parseDouble(input.readLine());
Grade9 ob=new Grade9();
ob.calcSXD(p1,r1,t1);
}
}*/
/*class Grade9
{
double Grade9(long a,double r,int n)
{
double rs;
rs=a-(r*n)/100*a;
return rs;
}
public static void main(String args[])
{
Grade9 ob=new Grade9();
double res;
res=ob.Grade9(450000,7.5,3);
System.out.println("Depriciated Value:"+res);
}
}*/
/*import java.io.*;
class Grade9
{
public static double Grade9(long a,double r,int n)
{
double rs;
rs=a-(r*n)/100*a;
return rs;
}
public static void main(String args[])throws IOException
{
BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
long a1;
double r1;
int n1;
double res;
System.out.println("Enter Initial Amount,Rate and Time:");
a1=Long.parseLong(input.readLine());
r1=Double.parseDouble(input.readLine());
n1=Integer.parseInt(input.readLine());
Grade9 ob=new Grade9();
res=ob.Grade9(a1,r1,n1);
System.out.println("Depriciated Value:"+res);
}
}*/
/*class Grade9
{
double area(double s)
{
return s*s;
}
double area(double l,double b)
{
return l*b;
}
double area(double a,double b,double c)
{
double s,ar;
s=(a+b+c)/2;
ar=Math.sqrt(s*(s-a)*(s-b)*(s-c));
return ar;
}
public static void main(String args[])
{
Grade9 ob=new Grade9();
double rs1,rs2,rs3;
rs1=ob.area(12.0,7.5);
rs2=ob.area(10.0);
rs3=ob.area(10.0,8.0,12.5);
System.out.println("Area of Rectangle:"+rs1);
System.out.println("Area of Square:"+rs2);
System.out.println("Area of Triangle:"+rs3);
}
}*/
/*import java.io.*;
class Grade9
{
double area(double s)
{
return s*s;
}
double area(double l,double b)
{
return l*b;
}
double area(double a,double b,double c)
{
double s,ar;
s=(a+b+c)/2;
ar=Math.sqrt(s*(s-a)*(s-b)*(s-c));
return ar;
}
public static void main(String args[])throws IOException
{
BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
Grade9 ob=new Grade9();
double s1,l1,b1,x,y,z;
double rs1,rs2,rs3;
System.out.println("Enter The Sides Of A Square:");
s1=Double.parseDouble(input.readLine());
rs1=ob.area(s1);
System.out.println("Enter The Sides Of A Rectange:");
l1=Double.parseDouble(input.readLine());
b1=Double.parseDouble(input.readLine());
rs2=ob.area(l1,b1);
System.out.println("Enter The Sides Of A Triangle:");
x=Double.parseDouble(input.readLine());
y=Double.parseDouble(input.readLine());
z=Double.parseDouble(input.readLine());
rs3=ob.area(x,y,z);
System.out.println("Area Of Square:"+rs1);
System.out.println("Area Of Reactangle:"+rs2);
System.out.println("Area Of Triangle:"+rs3);
}
}*/
/*import java.io.*;
class Grade9
{
public static double area(double a)
{
return Math.sqrt(3)*a*a/4;
}
public static double area(double a,double b)
{
return (1.0/4)*b*Math.sqrt((4*a*a)-(b*b));
}
public static double area(double a,double b,double c)
{
return (a+b+c)/2;
}
public static void main(String args[])throws IOException
{
BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
double x,y,z,rs;
char ch;
System.out.println("Enter Initials For Cases:");
ch=input.readLine().charAt(0);
switch (ch)
{
case 'E':case 'e':System.out.println("Enter The Sides of Equi Triangle:");
x=Double.parseDouble(input.readLine());
rs=area(x);
System.out.println("Area of Equi Triangle:"+rs);
break;
case 'I':case 'i':System.out.println("Enter The Sides of Isco Triangle:");
x=Double.parseDouble(input.readLine());
y=Double.parseDouble(input.readLine());
rs=area(x,y);
System.out.println("Area of Isco Triangle:"+rs);
break;
case 'S':case 's':System.out.println("Enter The Sides of Scal Triangle:");
x=Double.parseDouble(input.readLine());
y=Double.parseDouble(input.readLine());
z=Double.parseDouble(input.readLine());
rs=area(x,y,z);
System.out.println("Area of Isco Triangle:"+rs);
break;
default:System.out.println("Invalid Entry");
}
}
}*/
/*import java.io.*;
class Grade9
{
int a,b,c;
void accept()throws IOException
{
BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
System.out.println("Enter The Three Numbers:");
a=Integer.parseInt(input.readLine());
b=Integer.parseInt(input.readLine());
c=Integer.parseInt(input.readLine());
}
void disp()
{
if (a<=b && b<=c)
System.out.println(a+"\t"+b+"\t"+c);
else if (a<=c && c<=b)
System.out.println(a+"\t"+c+"\t"+b);
else if (b<=a && a<=c)
System.out.println(b+"\t"+a+"\t"+c);
else if (b<=c && c<=a)
System.out.println(b+"\t"+c+"\t"+a);
else if (c<=a && a<=b)
System.out.println(c+"\t"+a+"\t"+b);
else if (c<=b && b<=a)
System.out.println(c+"\t"+b+"\t"+a);
}
public static void main(String args[])throws IOException
{
Grade9 ob=new Grade9();
ob.accept();
ob.disp();
}
}*/
/*import java.io.*;
class Grade9
{
String pan,n;
long s,t;
void accept()throws IOException
{
BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
System.out.println("Enter PAN Card Name,PAN Card Number,Salary:");
pan=input.readLine();
n=input.readLine();
s=Long.parseLong(input.readLine());
}
void calc()
{
if (s<=180000)
t=0;
else
t=((long)20.0/100*(s-180000));
}
void Heading()
{
System.out.println("PAN Name"+"\t\t"+"PAN Number"+"\t\t"+"Salary"+"\t\t"+"Tax");
}
void disp()
{
System.out.println(pan+"\t\t"+n+"\t\t"+s+"\t\t"+t);
}
public static void main(String args[])throws IOException
{
Grade9 e1=new Grade9();
Grade9 e2=new Grade9();
Grade9 e3=new Grade9();

e1.accept();
e2.accept();
e3.accept();

e1.calc();
e2.calc();
e3.calc();

e1.Heading();

e1.disp();
e2.disp();
e3.disp();
}

}*/
/*import java.io.*;
class Grade9
{
void mutable()throws IOException
{
BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
int n,i,r;
System.out.println("Enter The Number of Times:");
n=Integer.parseInt(input.readLine());
for (i=1;i<=10;i++)
{
r=n*i;
System.out.println(n+" x "+i+" = "+r);
}
}
public static void main(String args[])throws IOException
{
Grade9 ob=new Grade9();
ob.mutable();
}
}*/
/*import java.io.*;
class Grade9
{
void fact()throws IOException
{
BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
int n,i;
long f=1;
n=Integer.parseInt(input.readLine());
for (i=n;i>=1;i--)
{
f=f*i;
}
System.out.println("Factorial="+f);
}
public static void main(String args[])throws IOException
{
Grade9 ob=new Grade9();
ob.fact();
}
}*/
/*import java.io.*;
class Grade9
{
public static long fact(int x)
{
long f=1;
int i;
for (i=x;i>=1;i--)
{
f=f*i;
}
return f;
}
public static void main(String args[])throws IOException
{
BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
int n,r;
System.out.println("Enter The Value of n and r:");
n=Integer.parseInt(input.readLine());
r=Integer.parseInt(input.readLine());
fact(n);
System.out.println("Result="+(fact(n)/(fact(r)*(fact(n-r)))));
}
}*/
/*import java.io.*;
class Grade9
{
boolean check(int n)
{
int s=0,i;
for (i=1;i<n;i++)
{
if (n%i==0)
s=s+i;
}
if (s==n)
return true;
else
return false;
}
public static void main(String args[])throws IOException
{
BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
int x;
boolean b;
Grade9 ob=new Grade9();
System.out.println("Enter The Number:");
x=Integer.parseInt(input.readLine());
b=ob.check(x);
if (b==true)
System.out.println("Perfect Number");
else
System.out.println("Not a Perfect Number");
}
}*/
/*
import java.io.*;
class Grade9
{
public boolean check(int n)
{
int i,c=0;
if (n==1)
return false;
else
{
for (i=1;i<=n;i++)
{
if (n%i==0)
c++;
}
if (c==2)
return true;
else
return false;
}
}
public static void main(String args[])throws IOException
{
Grade9 ob=new Grade9();
boolean b;
int num;
BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
System.out.println("Enter The Number:");
num=Integer.parseInt(input.readLine());
b=ob.check(num);
if (b==true)
System.out.println("Prime Number");
else 
System.out.println("Not A Prime Number");
}
}*/
/*import java.io.*;
class Grade9
{
public static void main(String args[])throws IOException
{
BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
int n,p,s,d;
System.out.println("Enter The Number:");
n=Integer.parseInt(input.readLine());
s=0;
p=1;
while (n!=0)
{
d=n%10;
s=d+s;
p=p*d;
n=n/10;
}
if (s==p)
System.out.println("Spy Number");
else
System.out.println("Not a Spy Number");
}
}*/
/*import java.io.*;
class Grade9
{
public static void main(String args[])throws IOException
{
BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
String accno;
System.out.println("Enter The Account Number:");
accno=input.readLine();
int c=0,x;
do
{
System.out.println("Enter The OTP");
x=Integer.parseInt(input.readLine());
c++;
if(x==1001)
{
System.out.println("OTP Correct:"+accno);
break;
}
else
{
System.out.println("Error");
}
}
while (c!=3);
}
}*/
/*import java.io.*;
class Grade9
{
boolean Check(int n)
{
int s,p,d;
s=0;
p=1;
while (n!=0)
{
d=n%10;
s=s+d;
p=p*d;
}
if (s==p)
return true;
else
return false;
}
public static void main(String args[])throws IOException
{
int a,b,i;
BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
Grade9 ob=new Grade9();
System.out.println("Enter Values of A and B:");
a=Integer.parseInt(input.readLine());
b=Integer.parseInt(input.readLine());
for (i=a;i<=b;i++)
{
if (ob.Check(i)==true)
{
System.out.println(i);
}
}
}
}*/
/*class Grade9
{
public static void main(String args[])
{
int i,j;
for (i=1;i<=4;i++)
{
for (j=1;j<=4;j++)
{
System.out.print("x");
}
System.out.println();
}
}
}*/
/*import java.io.*;
class Grade9
{
    public static void main(String args[])throws IOException
    {
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        int i,j,x,y;
        System.out.println("Enter The Number:");
        x=Integer.parseInt(input.readLine());
        y=Integer.parseInt(input.readLine());
        for (i=1;i<=x;i++)
        {
            for (j=1;j<=y;j++)
            {
                System.out.print("?");
            }
            System.out.println();
        }
    }
}*/
/*class Grade9
{
    public static void main(String args[])
    {
        int i,j;
        for (i=1;i<=5;i++)
        {
            for (j=1;j<=i;j++)
            {
                System.out.print("@");
            }
            System.out.println();
        }
    }
}*/
/*import java.io.*;
class Grade9
{
    public static void main(String args[])throws IOException
    {
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        int i,j,n;
        System.out.println("Enter The Number:");
        n=Integer.parseInt(input.readLine());
        for (i=1;i<=10;i++)
        {
            for (j=1;j<=n;j++)
            {
                System.out.print("@");
            }
            System.out.println();
        }
    }
}*/
/*class Grade9
{
    public static void main(String args[])
    {
        int i,j;
        for (i=1;i<=6;i++)
        {
            for (j=1;j<=i;j++)
            {
                if (j%2==0)
                System.out.print("\t RNC \t");
            }
            System.out.println();
        }
    }
}*/
/*class Grade9
{
    public static void main(String args[])
    {
        int i,j;
        for (i=5;i<=1;i--)
        {
            for (j=1;j<=5-i;j++)
            {
                System.out.print(" ");
            }
            for (j=1;j<=i;j++)
            {
                System.out.print("x");
            }
            System.out.println();
        }
    }
}*/
/*class Grade9
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
            for (j=1;j<=i;j++)
            {
                System.out.print("x ");
            }
            System.out.println();
        }
    }
}*/
import java.io.*;
class Grade9
{
    public static void main(String args[])throws IOException
    {
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        int ch,j;
        char k;
        int nb=10,p;
        char Start='A';
        System.out.println("Enter Your Choice:");
        ch=Integer.parseInt(input.readLine());
        switch (ch)
        {
            case 1:for (j=1;j<=5;j++)
                   {
                       for(k='A';k<'A'+j;k++)
                       {
                           System.out.print((char) k);
                       }
                       System.out.println();
                   }
                   break;
            case 2:for (j=1;j<=5;j++)
                   {
                       for(p=1;p<=nb;p++)
                       {
                           System.out.print(" ");
                       }
                       for (k=Start;k<='E'+j;k++)
                       {
                           System.out.print(" ");
                       }
                       System.out.print(k);
                   }
                   System.out.println();
                   Start++;
                   nb++;
                   break;
            default:System.out.println("Invalid");
        }
    } 
}