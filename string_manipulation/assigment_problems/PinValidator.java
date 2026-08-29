package assigment_problems;

public class PinValidator {
    public static void main(String[] args) {
        checkPinLength("482");
        checkPinLength("4820");
    }

    static void checkPinLength(String pin) {
        if (pin.length() == 4) {
            System.out.println("PIN length OK.");
        } else {
            System.out.println("Invalid PIN must be exactly 4 digits.");
        }
    }
}

