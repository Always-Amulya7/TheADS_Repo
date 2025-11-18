import java.util.Scanner;
public class Q19 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter The Size Of The Array: ");
        int n = scanner.nextInt();
        int[] arr = new int[n];
        System.out.print("Enter The Elements: ");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.print("Reversed Array: ");
        for (int i = n - 1; i >= 0; i--) {
            System.out.print(arr[i] + " ");
        }
    }
}
