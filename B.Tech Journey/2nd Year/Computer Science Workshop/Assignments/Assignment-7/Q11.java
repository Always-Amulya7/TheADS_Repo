import java.util.Scanner;

public class Q11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter A Double As A String: ");
        String input = scanner.nextLine();
        double value = Double.parseDouble(input);
        System.out.println("Double Base Type: " + value);
    }
}
