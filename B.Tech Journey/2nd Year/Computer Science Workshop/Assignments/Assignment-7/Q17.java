import java.util.Scanner;
public class Q17 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter The Size Of The Array: ");
        int n = scanner.nextInt();
        int[] arr = new int[n];
        System.out.print("Enter The Elements: ");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        int min = arr[0], max = arr[0];
        for (int num : arr) {
            if (num < min) min = num;
            if (num > max) max = num;
        }
        System.out.println("Minimum: " + min);
        System.out.println("Maximum: " + max);
    }
}
