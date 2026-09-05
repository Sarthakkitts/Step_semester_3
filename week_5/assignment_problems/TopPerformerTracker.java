public class TopPerformerTracker {
    public static void main(String[] args) {
        int[] scores = {45, 82, 79, 90, 33, 90, 61};
        System.out.println(findMinMaxSpread(scores));
    }

    static String findMinMaxSpread(int[] scores) {
        int minimum = scores[0];
        int maximum = scores[0];

        for (int i = 1; i < scores.length; i++) {
            if (scores[i] < minimum) {
                minimum = scores[i];
            }
            if (scores[i] > maximum) {
                maximum = scores[i];
            }
        }
        return "Min: " + minimum + " | Max: " + maximum + " | Spread: " + (maximum - minimum);
    }
}
