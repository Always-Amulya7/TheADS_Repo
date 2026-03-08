import java.util.*;
class Q8 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter The Size Of The Array: ");
        int Size = sc.nextInt();
        int arr1[][] = new int[Size][2];
        int arr2[][] = new int[Size][2];
        System.out.println("Enter The Array Elements-1: ");
        for (int i = 0; i < Size; i++) {
            for (int j = 0; j < 2; j++) {
                if (j == 0) {
                    System.out.print("Enter The Key: ");
                    arr1[i][j] = sc.nextInt();
                } else {
                    System.out.print("Enter The Value: ");
                    arr1[i][j] = sc.nextInt();
                }
            }
        }
        System.out.println("Enter The Array Elements-2: ");
        for (int i = 0; i < Size; i++) {
            for (int j = 0; j < 2; j++) {
                if (j == 0) {
                    System.out.print("Enter The Key: ");
                    arr2[i][j] = sc.nextInt();
                } else {
                    System.out.print("Enter The Value: ");
                    arr2[i][j] = sc.nextInt();
                }
            }
        }
        int[][] res = new int[Size * 2][2];
        int index = 0;
        for (int i = 0; i < Size; i++) {
            boolean found = false;
            for (int j = 0; j < Size; j++) {
                if (arr1[i][0] == arr2[j][0]) {
                    res[index][0] = arr1[i][0];
                    res[index][1] = arr1[i][1] + arr2[j][1];
                    index++;
                    found = true;
                    break;
                }
            }
            if (!found) {
                res[index][0] = arr1[i][0];
                res[index][1] = arr1[i][1];
                index++;
            }
        }
        for (int i = 0; i < Size; i++) {
            boolean found = false;
            for (int j = 0; j < index; j++) {
                if (arr2[i][0] == res[j][0]) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                res[index][0] = arr2[i][0];
                res[index][1] = arr2[i][1];
                index++;
            }
        }
        for (int i = 0; i < index - 1; i++) {
            for (int j = 0; j < index - i - 1; j++) {
                if (res[j][0] > res[j + 1][0]) {
                    int tempKey = res[j][0];
                    int tempVal = res[j][1];
                    res[j][0] = res[j + 1][0];
                    res[j][1] = res[j + 1][1];
                    res[j + 1][0] = tempKey;
                    res[j + 1][1] = tempVal;
                }
            }
        }
        System.out.println("Merged Array (Key-Value Pairs):");
        for (int i = 0; i < index; i++) {
            System.out.println("Key: " + res[i][0] + ", Value: " + res[i][1]);
        }
        sc.close();
    }
}