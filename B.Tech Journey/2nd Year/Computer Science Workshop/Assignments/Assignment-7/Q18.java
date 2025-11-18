import java.util.Arrays;
import java.util.Scanner;
public class Q18 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter The Size Of The Array: ");
        int n = scanner.nextInt();
        int[] arr = new int[n];
        System.out.print("Enter The Elements: ");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.print("Enter The Value Of K: ");
        int k = scanner.nextInt();
        Arrays.sort(arr);
        System.out.println("Kth Smallest: " + arr[k - 1]);
        System.out.println("Kth Largest: " + arr[n - k]);
    }
}
