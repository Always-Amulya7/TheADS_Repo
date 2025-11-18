import java.util.*;
class Q1 {
    public static void main(String[] args) {
        Scanner Sc = new Scanner(System.in);
        System.out.print("Enter Your Registration Number: ");
        long Regd = Sc.nextLong();
        
        long Temp = Regd;
        int Count = 0;
        while (Temp > 0) {
            Temp /= 10;
            Count++;
        }
        long[] Digits = new long[Count];
        for (int i = Count - 1; i >= 0; i--) {
            Digits[i] = Regd % 10;
            Regd /= 10;
        }
        System.out.println("The Registration Array Is: " + Arrays.toString(Digits));
        int Even = 0, Odd = 0, Prime = 0;
        for (int j = 0; j < Count; j++) {
            if (Digits[j] % 2 == 0) {
                Even++;
            } else {
                Odd++;
            }
            if (isPrime((int) Digits[j])) {
                Prime++;
            }
        }
        System.out.println("The Number of Primes Are: " + Prime);
        System.out.println("The Number of Evens Are: " + Even);
        System.out.println("The Number of Odds Are: " + Odd);
    }
    public static boolean isPrime(int Number) {
        if (Number < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(Number); i++) {
            if (Number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
