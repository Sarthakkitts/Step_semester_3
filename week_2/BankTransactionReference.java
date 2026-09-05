public class BankTransactionReference {
    public static void main(String[] args) {
        String reference = normalizeReference("  hdf03022600042  ");
        System.out.println(validateAndFormat(reference));
    }

    static String normalizeReference(String raw) {
        String trimmed = raw.trim();
        if (trimmed.length() < 3) {
            return trimmed;
        }
        return trimmed.substring(0, 3).toUpperCase() + trimmed.substring(3);
    }

    static String validateAndFormat(String reference) {
        if (reference.length() != 14) {
            return "Invalid: wrong length";
        }

        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(reference.charAt(i))) {
                return "Invalid: bank code must be 3 letters";
            }
        }

        for (int i = 3; i < reference.length(); i++) {
            if (!Character.isDigit(reference.charAt(i))) {
                return "Invalid: reference body must contain only digits";
            }
        }

        StringBuilder formatted = new StringBuilder();
        formatted.append('[').append(reference.substring(0, 3)).append("] DATE: ");
        formatted.append(reference, 3, 5).append('/').append(reference, 5, 7).append('/').append(reference, 7, 9);
        formatted.append(" | SEQ: ").append(reference.substring(9));
        return formatted.toString();
    }
}
