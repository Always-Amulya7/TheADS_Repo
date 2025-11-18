import java.util.Scanner;
public class Q7
{
    public static void main(String[] args)
    {
        try(Scanner scanner = new Scanner(System.in)){
        System.out.print("Enter Number Of Elements Of Array: ");
        int n = scanner.nextInt();
        int[] array = new int[n];
        System.out.println("Enter Elements of The Array:\n");
        int max = array[0];
        int min = array[0];
        int maxCount = 1;
        int minCount = 1;
        int maxPosition = 0;
        int minPosition = 0;
        for (int i = 0; i < n; i++)
        {
            System.out.print("Enter The Element At "+(i+1)+" Is: ");
            array[i] = scanner.nextInt();
            if (i == 0)
            {
            max = array[i];
            min = array[i];
            }
        }
        for (int i = 1; i < n; i++)
        {
            if (array[i] > max)
            {
                max = array[i];
                maxCount = 1;
                maxPosition = i + 1;
            } 
            else if (array[i] == max)
            {
                maxCount++;
            }
            if (array[i] < min)
            {
                min = array[i];
                minCount = 1;
                minPosition = i + 1;
            } 
            else if (array[i] == min)
            {
                minCount++;
            }
        }
        System.out.println("Maximum Element Of Array Is " + max + " And Occurs " + maxCount + " Times.");
        System.out.println("Minimum Element Of Array Is " + min + " And Occurs " + minCount + " Times.");
        System.out.println("First Occurrence Of Maximum Element Is At Position " + maxPosition + ".");
        System.out.println("Last Occurrence Of Minimum Element Is At Position " + minPosition + ".");}
    }
}