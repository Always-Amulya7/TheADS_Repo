import java.util.Scanner;
class Q5
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