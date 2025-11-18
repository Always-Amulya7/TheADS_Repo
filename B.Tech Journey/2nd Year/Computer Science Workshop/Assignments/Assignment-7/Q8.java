import java.util.Scanner;

public class Q8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter True/False: ");
        String input = scanner.nextLine();
        Boolean obj = Boolean.valueOf(input);
        System.out.println("Boolean Object: " + obj);
    }
}
