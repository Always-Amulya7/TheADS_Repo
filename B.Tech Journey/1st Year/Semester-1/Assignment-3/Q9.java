//Write a program to input 3 integer number a, b, c. Find the largest number among 3. Also find the 2nd largest number among 3. 

//Here is the sample output:
//Enter the value of a, b, c:10 30 50
//Largest number: 50
//2nd largest number: 30

import java.util.Scanner;
class Q9
{
	public static void main(String args[])
	{
		try(Scanner sc=new Scanner(System.in))
		{
		System.out.print("Enter the value of a, b, c:");
		int a,b,c ,largest,secondLargest;
		a=sc.nextInt();
		b=sc.nextInt();
		c=sc.nextInt();
		largest=Math.max(Math.max(a, b), c);
		if (a != largest && b != largest)
		{
           secondLargest = Math.max(a, b); // Find the second largest number
        } 
		else if (a != largest && c != largest) 
		{
            secondLargest = Math.max(a, c);
        } 
		else 
		{
            secondLargest = Math.max(b, c);
        }
		System.out.println("Largest number: "+largest);
		System.out.println("2nd Largest number: "+secondLargest);
		}
	}
}