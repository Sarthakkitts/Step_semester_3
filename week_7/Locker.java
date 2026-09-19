// Problem 4: The Locker Code
// Design a Locker class where the combination can be changed, but never read back directly from outside the class.

public class Locker {
    // Private combination code - no getter at all (write-only)
    private String combination;

    // Final locker number, fixed at creation
    private final int lockerNumber;

    // Constructor: initializes the locker with a number and initial combination
    public Locker(int lockerNumber, String initialCombination) {
        if (lockerNumber <= 0) {
            throw new IllegalArgumentException("Locker number must be positive");
        }
        if (initialCombination == null || initialCombination.isEmpty()) {
            throw new IllegalArgumentException("Initial combination cannot be null or empty");
        }
        this.lockerNumber = lockerNumber;
        this.combination = initialCombination;
    }

    // Method to change the code that requires the current code to be entered correctly first
    // Returns true if successful, false if rejected
    public boolean changeCode(String currentCode, String newCode) {
        // Check the old code first, before touching the field at all
        // If the check fails, the method should do nothing else (as per hints)
        if (currentCode == null || newCode == null) {
            return false; // Reject if either code is null
        }

        if (currentCode.equals(combination)) {
            // Current code is correct, so we can change to the new code
            // Additional validation: new code shouldn't be empty
            if (!newCode.isEmpty()) {
                combination = newCode;
                return true; // Success
            }
        }
        // If we get here, the change was rejected (wrong current code or invalid new code)
        return false;
    }

    // Method to get the locker number (since it's final and should be accessible)
    public int getLockerNumber() {
        return lockerNumber;
    }

    // NOTE: There is NO getter for the combination code - it's write-only as required

    // Main method for testing (not required by problem but useful for demonstration)
    public static void main(String[] args) {
        Locker l = new Locker(101, "1234");
        System.out.println("Locker " + l.getLockerNumber() + " created with initial code");

        // Try to change code with correct current code
        boolean success1 = l.changeCode("1234", "5678");
        System.out.println("Change code with correct current code: " + success1); // Should be true

        // Try to change code with wrong current code
        boolean success2 = l.changeCode("0000", "9999");
        System.out.println("Change code with wrong current code: " + success2); // Should be false

        // Note: We cannot directly check the combination because there's no getter
        // In a real scenario, we would know it worked by observing behavior or through other means
        // For demonstration purposes in this main method, we'll assume the first change worked

        // Try another change to see if it works
        boolean success3 = l.changeCode("5678", "0000");
        System.out.println("Second change code: " + success3); // Should be true

        // Try to change with wrong code again
        boolean success4 = l.changeCode("1111", "2222");
        System.out.println("Change code with wrong current code again: " + success4); // Should be false
    }
}