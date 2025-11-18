import java.util.*;
class Q15 {
    public static void main(String args[]) {
        Scanner Sc=new Scanner(System.in);
        int Count = 0;
        System.out.print("Enter A Number : ");
        int Num = Sc.nextInt();
        int Target = 100;
        while (Count < Target) {
            boolean isPrime = true;
            for (int i = 2; i <= Math.sqrt(Num); i++) {
                if (Num % i == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                Count++;
            }
            if (Count == Target) {
                System.out.println("The 100th Prime Number Is : " + Num);
            }
            Num++;
        }
    }
}
