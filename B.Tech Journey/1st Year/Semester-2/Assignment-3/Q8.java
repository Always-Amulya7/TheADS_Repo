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