import java.util.Scanner;
public class Q6 
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