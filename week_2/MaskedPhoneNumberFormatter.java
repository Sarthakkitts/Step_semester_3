public class MaskedPhoneNumberFormatter {
    public static void main(String[] args) {
        System.out.println(maskPhoneNumber("9876543210"));
        System.out.println(maskPhoneNumber("98765"));
    }

    static String maskPhoneNumber(String phone) {
        if (phone.length() != 10) {
            return "Invalid phone number";
        }

        for (int i = 0; i < phone.length(); i++) {
            if (!Character.isDigit(phone.charAt(i))) {
                return "Invalid phone number";
            }
        }

        StringBuilder maskedPhone = new StringBuilder("XXXXXX");
        maskedPhone.append(phone.substring(6));
        maskedPhone.insert(6, '-');
        return maskedPhone.toString();
    }
}
