import java.util.*;
class Q2 {
    public static void main(String args[]) {
        try (Scanner Sc = new Scanner(System.in)) {
            System.out.print("Enter The Word : ");
            String Word = Sc.nextLine();
            char[] Letter = new char[Word.length()];
            for (int i = 0; i < Word.length(); i++) {
                Letter[i] = Word.charAt(i);
            }
            System.out.println("The Characters Include : " + Arrays.toString(Letter));
            char[] Vowels = new char[Word.length()];
            char[] Consonants = new char[Word.length()];
            char Vowel[] = {'A', 'E', 'I', 'O', 'U', 'a', 'e', 'i', 'o', 'u'};
            for (int j = 0; j < Word.length(); j++) {
                for (int K = 0; K < Vowel.length; K++) {
                    if (Letter[j] == Vowel[K]) {
                        Vowels[j] = Letter[j];
                        break;
                    }
                }
            }
            for (int l = 0; l < Letter.length; l++) {
                boolean isVowel = false;
                for (int m = 0; m < Vowel.length; m++) {
                    if (Letter[l] == Vowel[m]) {
                        isVowel = true;
                        break;
                    }
                }
                if (!isVowel && Character.isLetter(Letter[l])) {
                    Consonants[l] = Letter[l];
                }
            }
            System.out.print("The Vowel Set Is : ");
            for (int i=0;i<Vowels.length;i++){
                System.out.print(Vowels[i]+" ");
            }
            System.out.print("\nThe Consonants Set Is : ");
            for (int i=0;i<Consonants.length;i++){
                System.out.print(Consonants[i]+" ");
            }
        }
    }
}
