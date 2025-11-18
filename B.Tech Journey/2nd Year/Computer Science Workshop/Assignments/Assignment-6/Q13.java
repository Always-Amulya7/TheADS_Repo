import java.util.*;
class Q13 {
    public static void main(String[] args) {
        try (Scanner Sc = new Scanner(System.in)) {
            System.out.print("Enter The Number To Be Checked : ");
            int Number = Sc.nextInt();
            int Count = 0;
            int Temp = Number;
            while (Temp > 0) {
                Count++;
                Temp = Temp / 10;
            }
            int[] Arr = new int[Count];
            Temp = Number;
            for (int i = Arr.length - 1; i >= 0; i--) {
                Arr[i] = Temp % 10;
                Temp = Temp / 10;
            }
            System.out.println("The Array Is : " + Arrays.toString(Arr));
            int[] FrequencyArray = Frequency(Arr);
            for (int i = 0; i < Arr.length; i++) {
                if (FrequencyArray[i] > 0) {
                    System.out.println("The Frequency Of " + Arr[i] + " Is : " + FrequencyArray[i]);
                    for (int j = i + 1; j < Arr.length; j++) {
                        if (Arr[j] == Arr[i]) {
                            FrequencyArray[j] = 0;
                        }
                    }
                }
            }
        }
    }
    public static int[] Frequency(int[] Arr) {
        int[] FreArray = new int[Arr.length];
        for (int i = 0; i < Arr.length; i++) {
            int Digit = Arr[i];
            int Count = 0;
            for (int j = 0; j < Arr.length; j++) {
                if (Digit == Arr[j]) {
                    Count++;
                }
            }
            FreArray[i] = Count;
        }
        return FreArray;
    }
}
