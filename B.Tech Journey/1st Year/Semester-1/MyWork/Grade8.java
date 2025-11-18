/*class Grade8
{
    public static void main(String args[])
    {
        System.out.println("Hello");
        System.out.println("World");
    }
}*/
/*class Grade8
{
    public static void main(String args[])
    {
        System.out.print("Hello");
        System.out.print("World");
        System.out.print("It's Robo");
    }
}*/
/*class Grade8
{
    public static void main(String args[])
    {
        System.out.println("John");
        System.out.print("Johnny");
        System.out.print("Janardhan");
        System.out.println("Akbar");
    }
}*/
/*class Grade8
{
    public static void main(String args[])
    {
        int a,b,s,p;
        a=25;
        b=66;
        s=a+b;
        p=a*b;
        System.out.println("Sum="+s);
        System.out.println("Product="+p);
    }
}*/
/*class Grade8
{
    public static void main(String args[])
    {
        double p,r,t,si,amt;
        p=642;
        r=10;
        t=5;
        si=(p*r*t)/100;
        amt=p+si;
        System.out.println("Simple Interest="+si);
        System.out.println("Amount="+amt);
    }
}*/
/*class Grade8
{
    public static void main(String args[])
    {
        double cel,fah;
        fah=97.8;
        cel=5*(fah-32)/9;
        System.out.println("Celsius value="+cel);
    }
}*/
/*class Grade8
{
    public static void main(String args[])
    {
        double cel,fah;
        cel=44.2;
        fah=9*(cel-32)/5;
        System.out.println("Fahereniet value="+fah);
    }
}*/
/*class Grade8
{
    public static void main(String args[])
    {
        double cp,sp,pr,pp;
        cp=55.8;
        sp=92.4;
        pr=sp-cp;
        pp=pr/cp*100;
        System.out.println("Profit%="+pp);
    }
}*/
/*class Grade8
{
    public static void main(String args[])
    {
        double a,b,gm;
        a=25;
        b=16;
        gm=Math.sqrt(a*b);
        System.out.println("Geometrical Mean="+gm);
    }
}*/
/*class Grade8
{
    public static void main(String args[])
    {
        double a,b,gm;
        a=25.3;
        b=42.6;
        gm=Math.sqrt(a*b);
        System.out.println("Geometrical Mean="+gm);
    }
}*/
/*class Grade8
{
    public static void main(String args[])
    {
        double t,l,g;
        l=47.6;
        g=9.8;
        t=2*3.14*Math.sqrt(l/g);
        System.out.println("Time Period="+t);
    }
}*/
/*class Grade8
{
    public static void main(String args[])
    {
        double days,yrs,weeks,hrs,mth;
        days=7489;
        yrs=days/365;
        mth=days/30;
        hrs=days*24;
        weeks=days/7;
        System.out.println("Years="+yrs);
        System.out.println("Months="+mth);
        System.out.println("Weeks="+weeks);
        System.out.println("Hours="+hrs);
    }
}*/
/*class Grade8
{
    public static void main(String args[])
    {
        double cp,sp,p,pr;
        cp=642;
        sp=912;
        p=sp-cp;
        pr=p/cp*100;
        System.out.println("Profit="+p);
        System.out.println("Profit%="+pr);
    }
}*/
/*class Grade8
{
    public static void main(String args[])
    {
        double a,x,b;
        a=4;
        b=13;
        System.out.println(Math.pow(a,b));
    }
}*/
/*class Grade8
{
    public static void main(String args[])
    {
        double r,v;
        r=8.6;
        v=4/3*3.14*r*r*r;
        System.out.println("Volume="+v);
    }
}*/
/*class Grade8
{
    public static void main(String args[])
    {
        double r1,r2,x;
        r1=4.6;
        r2=9.8;
        x=Math.sqrt((r1*r2))/(r1+r2);
        System.out.println("Value="+x);
    }
}*/
/*class Grade8
{
    public static void main(String args[])
    {
        double a,x,b,m;
        a=4;
        b=3;
        m=5;
        x=Math.pow(a+b,m);
        System.out.println("Value="+x);
    }
}*/
/*class Grade8
{
    public static void main(String args[])
    {
        double a,p,r,n;
        p=466;
        r=8.5;
        n=4;
        a=p*(Math.pow(1+r/100,n));
        System.out.println("Amount="+a);
    }
}*/
/*import java.io.*;
class Grade8
{
    public static void main(String args[])throws IOException
    {
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        int a,b;
        System.out.println("Enter Two Numbers=");
        a=Integer.parseInt(input.readLine());
        b=Integer.parseInt(input.readLine());
        if(a>b)
        System.out.println(a+"is bigger");
        else if(b>a)
        System.out.println(b+"is bigger");
        else
        System.out.println("Both Numbers are Same");
    }
}*/
/*import java.io.*;
class Grade8
{
    public static void main(String args[])throws IOException
    {
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        //InputStreamReader input=new InputStreamReader(System.in);
        System.out.println("Enter A Number=");
        int x=Integer.parseInt(input.readLine());
        if (x%2==0)
        System.out.println("Even");
        else
        System.out.println("Odd");
    }
}*/
/*import java.io.*;
class Grade8
{
    public static void main(String args[])throws IOException
    {
        //BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        InputStreamReader inp=new InputStreamReader(System.in);
        int x;
        x=Integer.parseInt(inp.readLine());
        System.out.println("Enter A Number=");
        if (x%2==0)
        System.out.println("Even");
        else
        System.out.println("Odd");
    }
}*/
/*import java.io.*;
class Grade8
{
    public static void main(String args[])throws IOException
    {
        BufferedReader ADS=new BufferedReader(new InputStreamReader(System.in));
        int x=Integer.parseInt(ADS.readLine());
        int y=Integer.parseInt(ADS.readLine());
        if (x%y==0)
        System.out.println("Factor");
        else
        System.out.println("Not A Factor");
    }
}*/
/*import java.io.*;
class Grade8
{
    public static void main(String args[])throws IOException
    {
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        int x;
        System.out.println("Enter A Number=");
        x=Integer.parseInt(input.readLine());
        if (x>0)
        System.out.println("Positive");
        else if (x<0)
        System.out.println("Negative");
        else
        System.out.println("Zero");
    }
}*/
/*import java.io.*;
class Grade8
{
    public static void main(String args[])throws IOException
    {
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        int mk;
        System.out.println("Enter Marks:");
        mk=Integer.parseInt(input.readLine());
        if (mk>=90)
        System.out.println("A");
        else if (mk>=75 && mk<=89)
        System.out.println("B");
        else if (mk>=60 && mk<=74)
        System.out.println("C");
        else if (mk>=40 && mk<=59)
        System.out.println("D");
        else
        System.out.println("E");
    }
}*/
/*import java.io.*;
class Grade8
{
    public static void main(String args[])throws IOException
    {
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        int sr;
        System.out.println("Enter Star Rating:");
        sr=Integer.parseInt(input.readLine());
        if (sr==1)
        System.out.println("Flop");
        else if (sr==2)
        System.out.println("Semi Hit");
        else if (sr==3)
        System.out.println("Hit");
        else if (sr==4)
        System.out.println("Super Hit");
        else if (sr==5)
        System.out.println("Block Buster");
    }
}*/
/*import java.io.*;
class Grade8
{
    public static void main(String args[])throws IOException
    {
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        int dist,amt=0;
        System.out.println("Enter Distance=");
        dist=Integer.parseInt(input.readLine());
        if (dist<=5)
        amt=100;
        else
        amt=100+(dist-5)*10;
        System.out.println("Amount="+amt);
    }
}*/
/*import java.io.*;
class Grade8
{
    public static void main(String args[])throws IOException
    {
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        double p,r,si,amt;int t;
        System.out.println("Enter Principal and Time:");
        p=Integer.parseInt(input.readLine());
        t=Integer.parseInt(input.readLine());
        if (t==1)
        r=5;
        else if (t==2)
        r=6;
        else if (t==3)
        r=8;
        else
        r=10;
        si=(p*r*t)/100;
        amt=p+si;
        System.out.println("Simple Interest="+si);
        System.out.println("Amount="+amt);
    }
}*/
/*import java.io.*;
class Grade8
{
    public static void main(String args[])throws IOException
    {
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        double par,dis=0.0,net=0.0;
        par=Double.parseDouble(input.readLine());
        if (par<=1000)
        dis=par*5/100;
        else if (par>=1001 && par<=3000)
        dis=par*7/100;
        else if(par>=3001 && par<=8000)
        dis=par*9/100;
        else
        dis=par*12/100;
        net=par-dis;
        System.out.println("Discount="+dis);
        System.out.println("Net Value="+net);
    }
}*/
/*import java.io.*;
class Grade8
{
    public static void main(String args[])throws IOException
    {
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        int n,t=0;
        System.out.println("Enter Number of Questions Solved:");
        n=Integer.parseInt(input.readLine());
        if (n<=5)
        t=n*1;
        else if (n>=6 && n<=10)
        t=5+(n-5)*2;
        else if (n>=11 && n<=20)
        t=5+5*2+(n-10)*3;
        else
        t=5+5*2+10*3+(n-20)*4;
        System.out.println("Number of Toffees="+t);
    }
}*/
/*import java.io.*;
class Grade8
{
    public static void main(String args[])throws IOException
    {
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        double inc,tax=0.0;
        System.out.println("Enter Income:");
        inc=Double.parseDouble(input.readLine());
        if (inc<=250000)
        tax=0.0;
        else if (inc<=500000)
        tax=(inc-250000)*5/100;
        else if (inc<=1000000)
        tax=+12250+(inc-500000)*20/100;
        else
        tax=12250+(inc-1000000)*30/100;
        System.out.println("tax="+tax);
    }
}*/
/*import java.io.*;
class Grade8
{
    public static void main(String args[])throws IOException
    {
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter Day Number:");
        int dn=Integer.parseInt(input.readLine());
        switch (dn)
        {
            case 1: System.out.println("Monday");
            break;
            case 2: System.out.println("Tuesday");
            break;
            case 3: System.out.println("Wednesday");
            break;
            case 4: System.out.println("Thursday");
            break;
            case 5: System.out.println("Friday");
            break;
            case 6: System.out.println("Saturday");
            break;
            case 7: System.out.println("Sunday");
            break;
            default:
            System.out.println("Invaild Day Number");
        }
    }
}*/
/*import java.io.*;
class Grade8
{
    public static void main(String args[])throws IOException
    {
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter A Number:");
        int dn=Integer.parseInt(input.readLine());
        switch (dn)
        {
            case 1: System.out.println("AAA");
            break;
            case 2: System.out.println("BBB");
            break;
            case 3: System.out.println("CCC");
            break;
            case 4: System.out.println("DDD");
            break;
            case 5: System.out.println("EEE");
            break;
            default:
            System.out.println("Invaild");
        }
     }
}*/
/*import java.io.*;
class Grade8
{
    public static void main(String args[])throws IOException
    {
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        char c=input.readLine().charAt(0);
        switch (c)
        {
            case 'a': System.out.println("A");
            break;
            case 'b': System.out.println("B");
            break;
            default:
            System.out.println("C");
        }
    }
}*/
/*import java.io.*;
class Grade8
{
    public static void main(String args[])throws IOException
    {
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        double p,r,si;
        int t;
        System.out.println("Enter Principal and Time");
        p=Integer.parseInt(input.readLine());
        t=Integer.parseInt(input.readLine());
        switch (t)
        {
            case 1:r=5;
            break;
            case 2:r=5.5;
            break;
            case 3:r=6;
            break;
            default:r=8;
        }
        System.out.println((p*r*t)/100+"=Simple Interest");
    }
}*/
/*import java.io.*;
class Grade8
{
    public static void main(String args[])throws IOException
    {
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter Month Number:");
        int mn=Integer.parseInt(input.readLine());
        switch (mn)
        {
            case 1:System.out.println("January");
            break;
            case 2:System.out.println("February");
            break;
            case 3:System.out.println("March");
            break;
            case 4:System.out.println("April");
            break;
            case 5:System.out.println("May");
            break;
            case 6:System.out.println("June");
            break;
            case 7:System.out.println("July");
            break;
            case 8:System.out.println("August");
            break;
            case 9:System.out.println("September");
            break;
            case 10:System.out.println("October");
            break;
            case 11:System.out.println("November");
            break;
            case 12:System.out.println("December");
            break;
            default:
            System.out.println("Invalid Number");
        }
    }
}*/
/*import java.io.*;
class Grade8
{
    public static void main(String args[])throws IOException
    {
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter Month Number:");
        int mn=Integer.parseInt(input.readLine());
        switch (mn)
        {
            case 1:case 3:case 5:case 7:case 8:case 10:System.out.println("31 Days");
            break;
            case 4:case 6:case 9:case 11:System.out.println("30 Days");
            break;
            case 2:System.out.println("28 Days");
            break;
            default:
            System.out.println("Wrong Month Number");
        }
    }
}*/
/*class Grade8
{
    public static void main(String args[])
    {
        int a=10;
        System.out.println(a%2==0?"Even":"Odd");
    }
}*/
/*import java.io.*;
class Grade8
{
    public static void main(String args[])throws IOException
    {
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        int N;
        System.out.println("Enter a Number:");
        N=Integer.parseInt(input.readLine());
        System.out.println(N%2==0?"Even":"Odd");
    }
}*/
/*import java.io.*;
class Grade8
{
    public static void main(String args[])throws IOException
    {
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        int mk;
        System.out.println("Enter Marks:");
        mk=Integer.parseInt(input.readLine());
        System.out.println(mk>=32?"Pass":"Fail");
    }
}*/
/*import java.io.*;
class Grade8
{
    public static void main(String args[])throws IOException
    {
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        int x,y;
        System.out.println("Enter Two Numbers:");
        x=Integer.parseInt(input.readLine());
        y=Integer.parseInt(input.readLine());
        System.out.println(x%y==0?"Factor":"Not A Factor");
    }
}*/
/*import java.io.*;
class Grade8
{
    public static void main(String args[])throws IOException
    {
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        int x,y;
        System.out.println("Enter Two Numbers:");
        x=Integer.parseInt(input.readLine());
        y=Integer.parseInt(input.readLine());
        System.out.println(x>y?x+" is Bigger":y+" is Bigger");
    }
}*/
/*import java.io.*;
class Grade8
{
    public static void main(String args[])throws IOException
    {
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        int n,p,amt;;
        System.out.println("Enter Number Of Pens Bought:");
        n=Integer.parseInt(input.readLine());
        p=n>=50?20:25;
        System.out.println("Amount="+p);
    }
}*/
/*import java.io.*;
class Grade8
{
    public static void main(String args[])throws IOException
    {
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        int a,b,c,mx;
        System.out.println("Enter Three Numbers:");
        a=Integer.parseInt(input.readLine());
        b=Integer.parseInt(input.readLine());
        c=Integer.parseInt(input.readLine());
        mx=a>b?(a>c?a:c):(b>c?b:c);
        System.out.println("Max Number="+mx);
    }
}*/
/*import java.io.*;
class Grade8
{
    public static void main(String args[])throws IOException
    {
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        char cc;
        System.out.println("Enter Colour Code:");
        cc=input.readLine().charAt(0);
        System.out.println(cc=='R'?"Red":cc=='G'?"Green":"Blue");
    }
}*/
/*import java.io.*;
class Grade8
{
    public static void main(String args[])throws IOException
    {
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        char cc;
        System.out.println("Enter Direction Initial:");
        cc=input.readLine().charAt(0);
        System.out.println(cc=='N'?"North":cc=='S'?"South":cc=='E'?"East":"West");
    }
}*/
/*import java.io.*;
class Grade8
{
    public static void main(String args[])throws IOException
    {
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        int n;
        System.out.println("Enter A Number:");
        n=Integer.parseInt(input.readLine());
        for (int i=0;i<=n;i++)
        {
            for (int j=0;j<=i;j++)
            {
                System.out.print("#");
            }
            System.out.println(" ");
        }
    }
}*/
/*class Grade8
{
    public static void main(String args[])
    {
        for (int i=1;i<=3;++i)
        {
            System.out.println("JAVA");
        }
    }
}*/
/*class Grade8
{
    public static void main(String args[])
    {
        for (int i=1;i<=3;i++)
        {
            System.out.println(i+"SXD");
        }
    }
}*/
/*class Grade8
{
    public static void main(String args[])
    {
        int i=1;
        while (i<=3)
        {
            System.out.println(i);
            i++;
        }
    }
}*/
/*class Grade8
{
    public static void main(String args[])
    {
        int i=1;
        do
        {
            System.out.println(i);
            i++;
        }
        while (i<=3);
    }
}*/
/*class Grade8
{
    public static void main(String args[])
    {
        int i;
        for (i=2;i<=30;i+=2)
        {
            System.out.println(i);
        }
    }
}*/
/*class Grade8
{
    public static void main(String args[])
    {
        int i;
        for (i=5;i<=50;i+=5)
        {
            System.out.print(i+" ");
        }
    }
}*/
/*class Grade8
{
    public static void main(String args[])
    {
        int i;
        for (i=10;i<=50;i*=10)
        {
            System.out.println(i);
        }
    }
}*/
/*import java.io.*;
class Grade8
{
    public static void main(String args[])throws IOException
    {
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter Values:");
        int x,y,z,i,s=0;
        x=Integer.parseInt(input.readLine());
        y=Integer.parseInt(input.readLine());
        z=Integer.parseInt(input.readLine());
        for (i=x;i<=y;i++)
        {
            if (i%z==0)
            {
                System.out.println(i);
                s=s+i;
            }
        }
        System.out.println("Sum="+s);
    }
}*/
/*class Grade8
{
    public static void main(String args[])
    {
        int i,s=0;
        for (i=1;i<=20;i++)
        {
          s=s+i;  
        }
        System.out.println("Sum="+s);
    }
}*/
/*class Grade8
{
    public static void main(String args[])
    {
        int i,s=0;
        for (i=30;i<=50;i++)
        {
          s=s+i;  
        }
        System.out.println("Sum="+s);
    }
}*/
/*import java.io.*;
class Grade8
{
    public static void main(String args[])throws IOException
    {
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        int i,s=0;
        for (i=1;i<=30;i++)
        {
            if (i%2!=0)
            {
                s=s+i;  
            }
        }
        System.out.println("Sum="+s);
    }
}*/
/*import java.io.*;
class Grade8
{
    public static void main(String args[])throws IOException
    {
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        int i,s=0;
        for (i=1;i<=30;i++)
        {
            if (i%2==0)
            {
                s=s+i;  
            }
        }
        System.out.println("Sum="+s);
    }
}*/
/*import java.io.*;
class Grade8
{
    public static void main(String args[])throws IOException
    {
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        int i,s=0;
        System.out.println("Enter A Number:");
        n=Integer.parseInt(input.readLine());
        for (i=1;i<=n;i++)
        {
            s=s+i;
        }
        System.out.println("Sum="+s);
    }
}*/
/*import java.io.*;
class Grade8
{
    public static void main(String args[])throws IOException
    {
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        int i,x,y,s=0;
        System.out.println("Enter The Number:");
        x=Integer.parseInt(input.readLine());
        y=Integer.parseInt(input.readLine());
        for (i=x;i<=y;i++)
        {
            s=s+i;
        }
        System.out.println("Sum="+s);
    }
}*/
/*import java.io.*;
class Grade8
{
    public static void main(String args[])throws IOException
    {
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        int i,x,y,s=0;
        System.out.println("Enter The Number:");
        x=Integer.parseInt(input.readLine());
        y=Integer.parseInt(input.readLine());
        for (i=x;i<=y;i++)
        {
            if (i%2!=0)
            {
                s=s+i;
            }
        }
        System.out.println("Sum="+s);
    }
}*/
/*import java.io.*;
class Grade8
{
    public static void main(String args[])throws IOException
    {
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        int i,x,y,s=0;
        System.out.println("Enter The Number:");
        x=Integer.parseInt(input.readLine());
        y=Integer.parseInt(input.readLine());
        for (i=x;i<y;i++)
        {
            if (i%2==0)
            {
                s=s+i;
            }
        }
        System.out.println("Sum="+s);
    }
}*/
/*import java.io.*;
class Grade8
{
    public static void main(String args[])throws IOException
    {
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        int i,x;
        System.out.println("Enter A Number:");
        x=Integer.parseInt(input.readLine());
        for (i=1;i<=x;i++)
        {
            if (x%i==0)
            {
                System.out.print(i+",");
            }
        }
    }
}*/
/*import java.io.*;
class Grade8
{
    public static void main(String args[])throws IOException
    {
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        int i,x,c=0;
        System.out.println("Enter A Number:");
        x=Integer.parseInt(input.readLine());
        for (i=1;i<=x;i++)
        {
            if (x%i==0)
            {
                c=c+i;
                if (c==2)
                System.out.println("Prime");
                else
                System.out.println("Not Prime");
            }
        }
    }
}*/
/*import java.io.*;
class Grade8
{
    public static void main(String args[])throws IOException
    {
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        int i,x;
        System.out.println("Enter A Number:");
        x=Integer.parseInt(input.readLine());
        for (i=1;i<=10;i++)
        {
            System.out.println(x+" x "+i+" = "+(x*i));
        }
    }
}*/
/*import java.io.*;
class Grade8
{
    public static void main(String args[])throws IOException
    {
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        int i,n,s=0;
        System.out.println("Enter A Number:");
        n=Integer.parseInt(input.readLine());
        for (i=1;i<=n;i++)
        {
            s=s+i;
        }
        System.out.println("Sum="+s);
    }
}*/
/*import java.io.*;
class Grade8
{
    public static void main(String args[])throws IOException
    {
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        int i,n,s=0;
        System.out.println("Enter A Number:");
        n=Integer.parseInt(input.readLine());
        for (i=1;i<=n;i++)
        {
            s=s+i*i;
        }
        System.out.println("Sum="+s);
    }
}*/
/*import java.io.*;
class Grade8
{
    public static void main(String args[])throws IOException
    {
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        int i,n,s=0;
        System.out.println("Enter A Number:");
        n=Integer.parseInt(input.readLine());
        for (i=1;i<=n;i++)
        {
            s=s+i*(i+1);
        }
        System.out.println("Sum="+s);
    }
}*/
/*import java.io.*;
class Grade8
{
    public static void main(String args[])throws IOException
    {
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        int i,n;
        double s=0.0;
        System.out.println("Enter A Number:");
        n=Integer.parseInt(input.readLine());
        for (i=1;i<=n;i++)
        {
            s=s+i/i+1;
        }
        System.out.println("Sum="+s);
    }
}*/
/*import java.io.*;
class Grade8
{
    public static void main(String args[])throws IOException
    {
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        int i,n,s=0;
        System.out.println("Enter A Number:");
        n=Integer.parseInt(input.readLine());
        for (i=1;i<=n;i++)
        {
            s=s+i*(i+1)*(i+2);
        }
        System.out.println("Sum="+s);
    }
}*/
/*import java.io.*;
class Grade8
{
    public static void main(String args[])throws IOException
    {
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        int i,n,s=0;
        for (i=2;i<=10;i+=2)
        {
            System.out.print(i+",");
            System.out.print(i);
        }
    }
}*/
/*import java.io.*;
class Grade8
{
    public static void main(String args[])throws IOException
    {
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        int i,n=10,m=5;
        for (i=2;i<=5;i+=2)
        {
            m++;n--;
            System.out.println(m+" "+n+" "+i);
        }
    }
}*/
/*import java.io.*;
class Grade8
{
    public static void main(String args[])throws IOException
    {
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        int i,j=2;
        for (i=5;i<=30;i+=5)
        {
            System.out.println(i+".Java");
            System.out.println(j+".BlueJ");
            j*=2;
        }
    }
}*/
/*import java.io.*;
class Grade8
{
    public static void main(String args[])throws IOException
    {
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        int i,a=0,b=0,c=0;
        for (i=1;i<=4;i++)
        {
            switch (i)
            {
                case 1:a++;
                case 2:b++;
                case 3:c++;
                default:c++;
            }
        }
        System.out.println(i+" "+a+" "+b+" "+c);
    }
}*/
import java.io.*;
class Grade8
{
    public static void main(String args[])throws IOException
    {
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        int n;
        System.out.println("Enter A Number:");
        n=Integer.parseInt(input.readLine());
        for (int i=0;i<=n;i++)
        {
            for (int j=0;j<=i;j++)
            {
                System.out.print("#");
            }
            System.out.println(" ");
        }
    }
}