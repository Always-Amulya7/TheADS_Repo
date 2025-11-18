import java.util.*;
class Q5 {
    public static void main(String args[]) {
        try (Scanner Sc = new Scanner(System.in)) {
            System.out.print("Enter The First Number: ");
            double Num1 = Sc.nextDouble();
            System.out.print("Enter The Second Number: ");
            double Num2 = Sc.nextDouble();
            int intNum2 = (int) Num2;
            System.out.println("The Multiplicative Product Is: " + Multiply(Num1, intNum2));
        }
    }
    public static double Multiply(double Num1, int Num2) {
        double Product = 0;
        for (int i = 1; i <= Num2; i++) {
            Product += Num1;
        }
        return Product;
    }
}