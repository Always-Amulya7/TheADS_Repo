//Write a java program that plays the popular scissor-rock-paper game. (A scissor can cut a paper, a rock can knock a scissor, and a paper can wrap a rock.) The program randomly generates a number 0, 1, or 2 representing scissor, rock, and paper. The program prompts the user to enter a number 0, 1, or 2 and displays a message indicating whether the user or the computer wins, loses, or draws.
//Here are sample runs:
//scissor (0), rock (1), paper (2): 1
//The computer is scissor. You are rock. You won
//scissor (0), rock (1), paper (2): 2
//The computer is paper. You are paper too. It is a draw

import java.util.Scanner;
class Q1
{
	public static void main(String args[])
	{
		try (Scanner sc = new Scanner(System.in))
		 {
			System.out.print("Scissor (0), Rock (1), Paper (2):");
			int ch,cch;
			String nm="",nnm="";
			ch=sc.nextInt();
			cch=(int) (Math.random()*2);
			switch ((int)ch)
			{
			case 0:nm="Scissor";
			break;
			case 1:nm="Rock";
			break;
			case 2:nm="Paper";
			break;
			}
			switch ((int)cch)
			{
			case 0:nnm="Scissor";
			break;
			case 1:nnm="Rock";
			break;
			case 2:nnm="Paper";
			break;
			}
			if (cch==ch)
			{
				System.out.println("The computer is "+nnm+". You are "+nm+". It's A Draw");
			}
			else if (ch>cch)
			{
				System.out.println("The computer is "+nnm+". You are "+nm+". You Won");
			}
			else
			{
				System.out.println("The computer is "+nnm+". You are "+nm+". You Lost");
			}
		}
	}
}

/*switch ((int)ch)
		{
		case 0:nm="Scissor";
		break;
		case 1:nm="Rock";
		break;
		case 2:nm="Paper";
		break;
		}
		switch ((int)cch)
		{
		case 0:nnm="Scissor";
		break;
		case 1:nnm="Rock";
		break;
		case 2:nnm="Paper";
		break;*/