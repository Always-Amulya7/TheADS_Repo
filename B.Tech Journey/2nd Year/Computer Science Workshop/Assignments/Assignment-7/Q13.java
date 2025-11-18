import java.util.Scanner;

public class Q13 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter A Positive Integer: ");
        int Num = scanner.nextInt();
        System.out.println("Multiplication Table For " + Num);
        for (int i = 1; i <= 10; i++) {
            System.out.println(Num + " x " + i + " = " + (Num * i));
        }
    }
}
