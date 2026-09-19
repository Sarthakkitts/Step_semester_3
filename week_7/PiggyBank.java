// Problem 1: The Piggy Bank
// Create a PiggyBank class where money can only be added or removed through specific actions — never set directly to any amount.

public class PiggyBank {
    // Private savings amount - can only be changed through deposit/withdraw methods
    private double savings;

    // Final ID that's fixed the moment it's created
    private final String id;

    // Constructor: initializes savings to 0 and sets the ID
    public PiggyBank(String id) {
        this.savings = 0.0;
        this.id = id;
    }

    // Deposit method: adds exactly the specified amount
    public void deposit(double amount) {
        if (amount > 0) {
            savings += amount;
        }
        // Note: According to requirements, we only add positive amounts
        // Negative deposits could be treated as withdrawals or ignored
    }

    // Withdraw method: subtracts amount only if sufficient funds, otherwise rejects
    public void withdraw(double amount) {
        if (amount > 0 && amount <= savings) {
            savings -= amount;
        }
        // If amount > savings or amount <= 0, withdrawal is rejected (no change)
    }

    // Method to check current savings (but no way to set it directly)
    public double getSavings() {
        return savings;
    }

    // Optional: getter for the ID since it's final and should be accessible
    public String getId() {
        return id;
    }

    // Main method for testing (not required by problem but useful for demonstration)
    public static void main(String[] args) {
        PiggyBank pb = new PiggyBank("PB-1");
        System.out.println("Initial savings: " + pb.getSavings()); // 0.0

        pb.deposit(100);
        System.out.println("After deposit(100): " + pb.getSavings()); // 100.0

        pb.withdraw(30);
        System.out.println("After withdraw(30): " + pb.getSavings()); // 70.0

        pb.withdraw(500); // Should be rejected
        System.out.println("After withdraw(500): " + pb.getSavings()); // 70.0 (unchanged)

        // Attempt to deposit negative amount (should be ignored based on our implementation)
        pb.deposit(-50);
        System.out.println("After deposit(-50): " + pb.getSavings()); // 70.0 (unchanged)
    }
}