import java.util.*;
import java.lang.Math;
class Program{
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter a number: ");
		int number=sc.nextInt();
		System.out.println("The number "+number+" is prime?"+((isPrime(number)==true)?" Yes it's prime":" No it's not prime"));
	}
	public static boolean isPrime(int number){
		if (number<=1)
			return false;
		int count=0;
		for (int i=2;i<Math.sqrt(number);i++){
			if (number%i==0)
			count++;
		}
		if (count==0)
			return true;
		else
			return false;
	}
}
