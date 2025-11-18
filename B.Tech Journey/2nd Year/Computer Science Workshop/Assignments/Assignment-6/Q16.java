import java.util.*;

class Q16 {
    public static void main(String args[]) {
        try (Scanner Sc = new Scanner(System.in)) {
            System.out.print("Enter The Range For Primes : ");
            int Lower = Sc.nextInt();
            int Upper = Sc.nextInt();
            if (Lower > Upper) {
                System.out.println("Invalid Range");
            }
            System.out.print("The Prime Numbers In The Range Are: ");
            for (int i = Lower; i <= Upper; i++) {
                if (isPrime(i)) {
                    System.out.print(i + " ");
                }
            }
        }
    }
    public static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int j = 2; j <= Math.sqrt(num); j++) {
            if (num % j == 0) {
                return false;
            }
        }
        return true;
    }
}
