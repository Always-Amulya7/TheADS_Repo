import java.util.*;
class Q14 {
    public static void main(String args[]) {
        try (Scanner Sc = new Scanner(System.in)) {
            System.out.print("Enter The Number To Be Checked: ");
            int Number = Sc.nextInt();
            if (Number <= 1) {
                System.out.println("No, It Is Not A Prime Number");
                return;
            }
            boolean isPrime = true;
            for (int i = 2; i <= Math.sqrt(Number); i++) {
                if (Number % i == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime)
                System.out.println("Yes, It Is A Prime Number");
            else
                System.out.println("No, It Is Not A Prime Number");
        }
    }
}
