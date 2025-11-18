import java.util.*;
class Q6 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter The Dividend: ");
            int Dividend = sc.nextInt();
            System.out.print("Enter The Divisor: ");
            int Divisor = sc.nextInt();
            if ((Divisor == 0) || (Divisor<0)) {
                System.out.println("Division by zero is not allowed.");
            } else {
                int result = divide(Dividend, Divisor);
                System.out.println("The Division of " + Dividend + " / " + Divisor + " = " + result);
            }
        }
    }
    public static int divide(int Dividend, int Divisor) {
        int Quotient = 0;
        while (Dividend >= Divisor) {
            Dividend -= Divisor;
            Quotient++;
        }
        return Quotient;
    }
}
