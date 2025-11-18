import java.util.Scanner;
class Q8
{
    public static void main(String[] args)
    {
        try(Scanner sc=new Scanner(System.in))
        {
            while(true)
            {
                int random_number = (int) ((Math.random()*9)+1);
                int guess;
                System.out.print("User Guess:");
                guess=sc.nextInt();
                System.out.println("Computer Guess:"+random_number);
                if(guess>random_number)
                {
                    System.out.println("Too high, try again.");
                }
                else if (guess < random_number)
                {
                    System.out.println("Too low, try again.");
                }
                else if (guess==random_number)
                {
                    System.out.println("Good guess! You got it!");
                    break;
                }
            }
        }
    }
}