public class VowelConsonantCounter {
    public static void main(String[] args) {
        countVowelsAndConsonants("Java Programming");
    }

    static void countVowelsAndConsonants(String text) {
        int vowels = 0;
        int consonants = 0;

        for (int i = 0; i < text.length(); i++) {
            char current = Character.toLowerCase(text.charAt(i));

            if (current == ' ') {
                continue;
            }
            if (current == 'a' || current == 'e' || current == 'i' || current == 'o' || current == 'u') {
                vowels++;
            } else if (Character.isLetter(current)) {
                consonants++;
            }
        }

        System.out.println("Vowels: " + vowels + " | Consonants: " + consonants);
    }
}
