import java.util.Scanner;
class Q1
{
	public static void main(String[] args)
	{
        try (Scanner input = new Scanner(System.in))
        {
            System.out.print("Enter the number of minutes: ");
            long minutes = input.nextLong();
            long years = minutes/(60*24*365);
            int days = (int) ((minutes % (60*24*365)) / 1440);

            System.out.println(minutes + " minutes is approximately " + years + " years and " + days + " days.");
        }
    }
}