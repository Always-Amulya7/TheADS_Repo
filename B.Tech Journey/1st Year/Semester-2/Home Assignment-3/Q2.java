import java.util.*;
public class Q2
{
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		System.out.print("Enter The Size Of The Array :");
		int n=in.nextInt();
		int arr[] = new int[n];
		System.out.println("Enter The Elements In The Array In Ascending Order :");
		for(int i=0; i<n; i++)
		{
			arr[i]=in.nextInt();
		}
		System.out.print("Enter The Element To Be Searched :");
		int e=in.nextInt();
		int s=search(arr,e,n/2);
		System.out.print("Element Found At "+s);
	}
	public static int search(int[] arr, int e, int m)
	{
		if(e==arr[m])
			return m;
		else
		{
			if(e>arr[m])
			{
				return search(arr, e, m+m/2);
			}
			else
			{
				return search(arr, e, m-m/2);
			}
		}
	}
}