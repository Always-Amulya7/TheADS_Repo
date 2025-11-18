import java.util.Scanner;
class Q3
{
	public static void main(String[] args) 
	{
        int cinp= (int) (Math.random()*9)+1;
        try (Scanner sc = new Scanner(System.in))
        {
            System.out.print("Enter user number: ");
            int yinp= sc.nextInt();
            System.out.println("Computer guessses: "+cinp);
            if (yinp==cinp) 
            {
            	System.out.println("You got it right!"); 
            }
            else if (yinp+1==cinp)
            {
                System.out.println("Almost got it");
            }
            else if (yinp-1==cinp)
            {
            	System.out.println("You got it wrong");
            }
        }
	}
}