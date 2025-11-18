import java.util.Scanner;

public class Q6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter A Float: ");
        String input = scanner.nextLine();
        Float obj = Float.valueOf(input);
        System.out.println("Float Object: " + obj);
    }
}
