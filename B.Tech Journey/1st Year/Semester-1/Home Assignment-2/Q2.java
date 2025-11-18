import java.util.Scanner;
class Q2
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
}