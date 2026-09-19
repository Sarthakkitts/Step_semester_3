// Problem 2: The Quiz Scorecard
// Design a Scorecard class that stores each answer's result privately, and reveals only the final score — never the raw list of right/wrong answers.

public class Scorecard {
    // Private array to store results (true for correct, false for incorrect)
    private boolean[] results;

    // Counter to track how many answers have been recorded so far
    private int answersRecorded;

    // Total number of questions (fixed when scorecard is created)
    private final int totalQuestions;

    // Constructor: initializes the scorecard with a fixed number of questions
    public Scorecard(int totalQuestions) {
        if (totalQuestions <= 0) {
            throw new IllegalArgumentException("Total questions must be positive");
        }
        this.totalQuestions = totalQuestions;
        this.results = new boolean[totalQuestions];
        this.answersRecorded = 0;
    }

    // Method to record the next answer's result
    public void recordAnswer(boolean isCorrect) {
        // Only record if we haven't exceeded the total question count
        if (answersRecorded < totalQuestions) {
            results[answersRecorded] = isCorrect;
            answersRecorded++;
        }
        // If we've already recorded all answers, ignore additional ones (as per hints)
    }

    // Method to get the total score (count of correct answers)
    // This is the ONLY way to access the results - no getter for the array itself
    public int getScore() {
        int correctCount = 0;
        for (int i = 0; i < answersRecorded; i++) {
            if (results[i]) {
                correctCount++;
            }
        }
        return correctCount;
    }

    // Optional: getter for total questions
    public int getTotalQuestions() {
        return totalQuestions;
    }

    // Optional: getter for how many answers have been recorded
    public int getAnswersRecorded() {
        return answersRecorded;
    }

    // Main method for testing (not required by problem but useful for demonstration)
    public static void main(String[] args) {
        Scorecard sc = new Scorecard(4);
        sc.recordAnswer(true);  // Correct
        sc.recordAnswer(true);  // Correct
        sc.recordAnswer(false); // Incorrect
        sc.recordAnswer(true);  // Correct
        System.out.println("Score: " + sc.getScore()); // Should be 3

        // Try to record more answers than the fixed count - should be ignored
        sc.recordAnswer(true);
        sc.recordAnswer(false);
        System.out.println("Score after extra recordings: " + sc.getScore()); // Still 3

        System.out.println("Total questions: " + sc.getTotalQuestions()); // 4
        System.out.println("Answers recorded: " + sc.getAnswersRecorded()); // 4 (not 6)
    }
}