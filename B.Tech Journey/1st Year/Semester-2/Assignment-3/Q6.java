import java.util.*;
class Q6
{
	public static void main(String args[])
	{
		Scanner Sc=new Scanner(System.in);
		System.out.print("Enter The Size Of The Array: ");
		int Number=Sc.nextInt();
		Integer Store1[]=new Integer[Number];
		Double  Store2[]=new Double[Number];
		System.out.println("Enter The Integer Array: ");
		for (int i=0;i<Number;i++)
		{
			System.out.print("Enter The Number At "+(i+1)+" : ");
			Store1[i]=Sc.nextInt();
		}
		System.out.println("Enter The Double Array : ");
		for (int i=0;i<Number;i++)
		{
			System.out.print("Enter The Number At "+(i+1)+" : ");
			Store2[i]=Sc.nextDouble();
		}
		System.out.println("The Integer Array Is: ");
		for (int Element: Store1)
		{
			System.out.print(Element+" ");
		}
		System.out.println("\nThe Double Array Is: ");
		for (double Element: Store2)
		{
			System.out.print(Element+" ");
		}
		System.out.print("\nEnter The Element To Be Searched For 1: ");
		int Search1=Sc.nextInt();
		System.out.print("Enter The Element To Be Searched For 2: ");
		double Search2=Sc.nextDouble();
		System.out.println("The Result For The Array1 Is: "+Q6.<Integer>count(Store1, Search1));
		System.out.println("The Result For The Array2 Is: "+Q6.<Double>count(Store2, Search2));
	}
	public static <T> int count(T[] array, T item)
	{
		int count=0;
		for (int i = 0; i < array.length; i++)
		{
			if (item.equals(array[i]))
			{
				count=i;
			}
		}
		return count;
	  }
	  
}