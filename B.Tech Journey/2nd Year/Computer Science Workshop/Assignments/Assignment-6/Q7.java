import java.util.*;
class Q7 {
    public static void main(String args[]) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter The Base: ");
            int Base = sc.nextInt();
            System.out.print("Enter The Power: ");
            int Exponent = sc.nextInt();
            int Answer = 1;
            for (int i = 0; i < Exponent; i++) {
                Answer *= Base;
            }
            System.out.println("The Exponential Calculation Is: " + Answer);
        }
    }
}
