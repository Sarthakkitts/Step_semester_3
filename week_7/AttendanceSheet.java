// Problem 5: The Attendance Sheet
// Design an AttendanceSheet class that stores present students internally but only reveals a count and a yes/no lookup — never the full list.

public class AttendanceSheet {
    // Private array to store present student names
    // Using a fixed size array - assuming a maximum class size (we'll use 100 as a reasonable default)
    private static final int MAX_CLASS_SIZE = 100;
    private String[] presentStudents;

    // Counter to track how many unique students are present
    private int presentCount;

    // Constructor: initializes the attendance sheet
    public AttendanceSheet() {
        this.presentStudents = new String[MAX_CLASS_SIZE];
        this.presentCount = 0;
    }

    // Alternative constructor that allows specifying maximum class size
    public AttendanceSheet(int maxClassSize) {
        if (maxClassSize <= 0) {
            throw new IllegalArgumentException("Max class size must be positive");
        }
        this.presentStudents = new String[maxClassSize];
        this.presentCount = 0;
    }

    // Method to mark a student present
    // Before adding a name, check whether it's already in the array — that's what avoids counting the same student twice
    public void markPresent(String studentName) {
        // Validate input
        if (studentName == null || studentName.trim().isEmpty()) {
            return; // Ignore null or empty names
        }

        String trimmedName = studentName.trim();

        // Check if the student is already marked present (to avoid duplicates)
        for (int i = 0; i < presentCount; i++) {
            if (presentStudents[i].equalsIgnoreCase(trimmedName)) {
                // Student is already present, do nothing
                return;
            }
        }

        // If not already present and we have space, add the student
        if (presentCount < presentStudents.length) {
            presentStudents[presentCount] = trimmedName;
            presentCount++;
        }
        // If array is full, we could either ignore or throw an exception
        // For simplicity, we'll ignore additional students when the array is full
    }

    // Method that returns how many students are present
    public int getPresentCount() {
        return presentCount;
    }

    // Method that checks whether one specific name is present
    // Returns true if the student is present, false otherwise
    public boolean isPresent(String studentName) {
        if (studentName == null || studentName.trim().isEmpty()) {
            return false;
        }

        String trimmedName = studentName.trim();

        // Search through the present students array
        for (int i = 0; i < presentCount; i++) {
            if (presentStudents[i].equalsIgnoreCase(trimmedName)) {
                return true; // Found the student
            }
        }
        return false; // Not found
    }

    // NOTE: There is NO method that returns the whole array of names - as required

    // Main method for testing (not required by problem but useful for demonstration)
    public static void main(String[] args) {
        AttendanceSheet sheet = new AttendanceSheet(30); // Using 30 as in the example

        sheet.markPresent("Ana");
        sheet.markPresent("Ben");
        sheet.markPresent("Ana"); // Duplicate - should not increase count
        System.out.println("Present count: " + sheet.getPresentCount()); // Should be 2

        System.out.println("isPresent(\"Ben\"): " + sheet.isPresent("Ben")); // Should be true
        System.out.println("isPresent(\"Chen\"): " + sheet.isPresent("Chen")); // Should be false

        // Test case insensitivity
        sheet.markPresent("bEn"); // Should be treated as same as "Ben"
        System.out.println("Present count after marking 'bEn': " + sheet.getPresentCount()); // Should still be 2
        System.out.println("isPresent(\"BEN\"): " + sheet.isPresent("BEN")); // Should be true

        // Add a few more students
        sheet.markPresent("Chen");
        sheet.markPresent("David");
        System.out.println("Present count after adding Chen and David: " + sheet.getPresentCount()); // Should be 4
        System.out.println("isPresent(\"Chen\"): " + sheet.isPresent("Chen")); // Should be true
    }
}