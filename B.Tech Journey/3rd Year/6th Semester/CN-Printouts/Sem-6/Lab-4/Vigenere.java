import java.util.*;
public class Vigenere {
    static String generateKey(String text, String key) {
        StringBuilder newKey = new StringBuilder(key);
        for (int i = 0; newKey.length() < text.length(); i++) {
            newKey.append(key.charAt(i % key.length()));
        }
        return newKey.toString();
    }
    static String encrypt(String text, String key) {
        StringBuilder cipher = new StringBuilder();
        key = generateKey(text, key);

        for (int i = 0; i < text.length(); i++) {
            char x = (char) (((text.charAt(i) + key.charAt(i)) % 26) + 'A');
            cipher.append(x);
        }

        return cipher.toString();
    }
    static String decrypt(String cipher, String key) {
        StringBuilder text = new StringBuilder();
        key = generateKey(cipher, key);

        for (int i = 0; i < cipher.length(); i++) {
            char x = (char) (((cipher.charAt(i) - key.charAt(i) + 26) % 26) + 'A');
            text.append(x);
        }

        return text.toString();
    }
    public static void main(String[] args) {
        String text = "HELLOWORLD";
        String key = "KEY";
        String cipher = encrypt(text, key);
        System.out.println("Encrypted Text: " + cipher);
        String decrypted = decrypt(cipher, key);
        System.out.println("Decrypted Text: " + decrypted);
    }
}
