// Problem 3: The Nickname Tag
// Create an immutable NameTag class that takes a full name once and builds a nickname from it — first name plus the last name's initial.

public class NameTag {
    // Store the first name and last name initial as final fields (immutable)
    private final String firstName;
    private final String lastNameInitial;

    // Constructor: takes a full name and splits it into first and last name
    // Assumes the full name always has exactly one first name and one last name, separated by a single space
    public NameTag(String fullName) {
        if (fullName == null || fullName.trim().isEmpty()) {
            throw new IllegalArgumentException("Full name cannot be null or empty");
        }

        // Split the full name by space
        String[] nameParts = fullName.trim().split(" ");

        // Validate that we have exactly two parts (first and last name)
        if (nameParts.length != 2) {
            throw new IllegalArgumentException("Full name must contain exactly one first name and one last name separated by a single space");
        }

        this.firstName = nameParts[0];
        // Get the first character of the last name and add a period
        this.lastNameInitial = nameParts[1].substring(0, 1) + ".";
    }

    // Method that returns the nickname (first name plus last name's initial)
    // Since all fields are final and set in constructor, this method is thread-safe and immutable
    public String getNickname() {
        return firstName + " " + lastNameInitial;
    }

    // Optional: getters for the components (though the problem doesn't require them)
    public String getFirstName() {
        return firstName;
    }

    public String getLastNameInitial() {
        return lastNameInitial;
    }

    // Main method for testing (not required by problem but useful for demonstration)
    public static void main(String[] args) {
        NameTag tag = new NameTag("Maria Gomez");
        System.out.println("Nickname: " + tag.getNickname()); // Should be "Maria G."

        // Test with another name
        NameTag tag2 = new NameTag("John Doe");
        System.out.println("Nickname: " + tag2.getNickname()); // Should be "John D."

        // Demonstrate immutability: there's no way to change the name after creation
        // All fields are final and there are no setter methods
    }
}