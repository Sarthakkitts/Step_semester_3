public class BmiCalculator {
    public static void main(String[] args) {
        double[] heights = {1.75, 1.60, 1.82, 1.68};
        double[] weights = {70, 90, 75, 52};
        printWellnessReport(heights, weights);
    }

    static String getBmiStatus(double bmi) {
        if (bmi < 18.5) {
            return "Underweight";
        }
        if (bmi < 25) {
            return "Normal";
        }
        if (bmi < 30) {
            return "Overweight";
        }
        return "Obese";
    }

    static void printWellnessReport(double[] heights, double[] weights) {
        System.out.printf("%-8s %-12s %-12s %-8s %s%n", "Person", "Height (m)", "Weight (kg)", "BMI", "Status");
        int people = Math.min(heights.length, weights.length);

        for (int i = 0; i < people; i++) {
            double bmi = weights[i] / (heights[i] * heights[i]);
            System.out.printf("%-8d %-12.2f %-12.1f %-8.2f %s%n", i + 1, heights[i], weights[i], bmi, getBmiStatus(bmi));
        }
    }
}
