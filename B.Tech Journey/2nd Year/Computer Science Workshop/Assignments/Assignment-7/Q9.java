import java.util.Scanner;

public class Q9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Int, Float, Double, And Boolean : ");
        int intVal = Integer.valueOf(scanner.next());
        float floatVal = Float.valueOf(scanner.next());
        double doubleVal = Double.valueOf(scanner.next());
        boolean boolVal = Boolean.valueOf(scanner.next());

        System.out.println("Integer Object: " + intVal);
        System.out.println("Float Object: " + floatVal);
        System.out.println("Double Object: " + doubleVal);
        System.out.println("Boolean Object: " + boolVal);
    }
}
