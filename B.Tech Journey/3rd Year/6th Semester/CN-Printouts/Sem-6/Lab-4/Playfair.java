import java.util.*;
public class Playfair {
    static char[][] matrix = new char[5][5];
    static void generateMatrix(String key) {
        boolean[] used = new boolean[26];
        key = key.toUpperCase().replace("J", "I");
        StringBuilder sb = new StringBuilder();
        for (char c : key.toCharArray()) {
            if (!used[c - 'A']) {
                sb.append(c);
                used[c - 'A'] = true;
            }
        }
        for (char c = 'A'; c <= 'Z'; c++) {
            if (c != 'J' && !used[c - 'A']) {
                sb.append(c);
                used[c - 'A'] = true;
            }
        }
        int index = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                matrix[i][j] = sb.charAt(index++);
            }
        }
    }
    static int[] findPosition(char c) {
        if (c == 'J') c = 'I';
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (matrix[i][j] == c) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }
    static String prepareText(String text) {
        text = text.toUpperCase().replace("J", "I").replaceAll("[^A-Z]", "");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            sb.append(text.charAt(i));
            if (i + 1 < text.length() && text.charAt(i) == text.charAt(i + 1)) {
                sb.append('X');
            }
        }
        if (sb.length() % 2 != 0) sb.append('X');
        return sb.toString();
    }
    static String encrypt(String text) {
        text = prepareText(text);
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < text.length(); i += 2) {
            char a = text.charAt(i);
            char b = text.charAt(i + 1);
            int[] posA = findPosition(a);
            int[] posB = findPosition(b);
            if (posA[0] == posB[0]) {
                result.append(matrix[posA[0]][(posA[1] + 1) % 5]);
                result.append(matrix[posB[0]][(posB[1] + 1) % 5]);
            } else if (posA[1] == posB[1]) {
                result.append(matrix[(posA[0] + 1) % 5][posA[1]]);
                result.append(matrix[(posB[0] + 1) % 5][posB[1]]);
            } else {
                result.append(matrix[posA[0]][posB[1]]);
                result.append(matrix[posB[0]][posA[1]]);
            }
        }
        return result.toString();
    }
    static String decrypt(String text) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < text.length(); i += 2) {
            char a = text.charAt(i);
            char b = text.charAt(i + 1);
            int[] posA = findPosition(a);
            int[] posB = findPosition(b);
            if (posA[0] == posB[0]) {
                result.append(matrix[posA[0]][(posA[1] + 4) % 5]);
                result.append(matrix[posB[0]][(posB[1] + 4) % 5]);
            } else if (posA[1] == posB[1]) {
                result.append(matrix[(posA[0] + 4) % 5][posA[1]]);
                result.append(matrix[(posB[0] + 4) % 5][posB[1]]);
            } else {
                result.append(matrix[posA[0]][posB[1]]);
                result.append(matrix[posB[0]][posA[1]]);
            }
        }
        return result.toString();
    }
    public static void main(String[] args) {
        String key,text;
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter The Text: ");
        text=sc.nextLine();
        System.out.print("Enter The Key: ");
        key=sc.nextLine();
        generateMatrix(key);
        String encrypted = encrypt(text);
        System.out.println("Encrypted: " + encrypted);
        String decrypted = decrypt(encrypted);
        System.out.println("Decrypted: " + decrypted);
        sc.close();
    }
}
