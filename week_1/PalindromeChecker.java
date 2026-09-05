public class PalindromeChecker {
    public static void main(String[] args) {
        String text = "madam";
        System.out.println("Iterative: " + getResult(isPalindromeIterative(text)));
        System.out.println("Recursive: " + getResult(isPalindromeRecursive(text)));
        System.out.println("Array Reversal: " + getResult(isPalindromeArrayReversal(text)));
    }

    static boolean isPalindromeIterative(String text) {
        String cleaned = text.replace(" ", "").toLowerCase();
        int left = 0;
        int right = cleaned.length() - 1;

        while (left < right) {
            if (cleaned.charAt(left) != cleaned.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    static boolean isPalindromeRecursive(String text) {
        String cleaned = text.replace(" ", "").toLowerCase();
        return checkRecursively(cleaned, 0, cleaned.length() - 1);
    }

    private static boolean checkRecursively(String text, int left, int right) {
        if (left >= right) {
            return true;
        }
        if (text.charAt(left) != text.charAt(right)) {
            return false;
        }
        return checkRecursively(text, left + 1, right - 1);
    }

    static boolean isPalindromeArrayReversal(String text) {
        String cleaned = text.replace(" ", "").toLowerCase();
        char[] characters = cleaned.toCharArray();
        char[] reversed = new char[characters.length];

        for (int i = 0; i < characters.length; i++) {
            reversed[i] = characters[characters.length - 1 - i];
        }
        return cleaned.equals(new String(reversed));
    }

    private static String getResult(boolean palindrome) {
        return palindrome ? "Palindrome" : "Not Palindrome";
    }
}
