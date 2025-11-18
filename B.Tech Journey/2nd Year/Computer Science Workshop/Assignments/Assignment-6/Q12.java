import java.util.*;
class Q12 {
    public static void main(String args[]) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter two numbers: ");
            int Num1 = sc.nextInt();
            int Num2 = sc.nextInt();
            String Val1 = Integer.toString(Num1);
            String Val2 = Integer.toString(Num2);
            if (Val1.length() < 2 || Val2.length() < 2) {
                System.out.println("Both Numbers Must Have At Least Two Digits");
            }
            String Number = Val1.substring(0, 2) + Val2.substring(Val2.length() - 2);
            System.out.println("The New Number Formed : " + Number);
        }
    }
}
