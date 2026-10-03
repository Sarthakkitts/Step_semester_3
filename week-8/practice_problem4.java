import java.util.Scanner;

public class practice_problem4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine(); // consume newline
        double total = 0.0;
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine().trim();
            if (line.isEmpty()) continue;
            // Split by double quote
            String[] parts = line.split("\"");
            // Expected format: QType  "QText"  "Correct"  "Student"  Points
            // After split: [0] = QType + space, [1] = QText, [2] = space, [3] = Correct, [4] = space, [5] = Student, [6] = space, [7] = Points
            // Actually there may be spaces around.
            String qtype = parts[0].trim();
            String questionText = parts[1]; // not needed
            String correctAnswer = parts[3];
            String studentAnswer = parts[5];
            String pointsStr = parts[7].trim();
            int points = Integer.parseInt(pointsStr);
            double score;
            switch (qtype) {
                case "MCQ":
                case "TF":
                    score = studentAnswer.equals(correctAnswer) ? points : 0;
                    break;
                case "ESSAY":
                    // correctAnswer is comma-separated keywords
                    String[] keywords = correctAnswer.split(",");
                    int matchCount = 0;
                    String studentLower = studentAnswer.toLowerCase();
                    for (String k : keywords) {
                        String keyword = k.trim().toLowerCase();
                        if (studentLower.contains(keyword)) {
                            matchCount++;
                        }
                    }
                    if (matchCount >= 2) {
                        score = points * 0.75;
                    } else if (matchCount == 1) {
                        score = points * 0.5;
                    } else {
                        score = 0;
                    }
                    break;
                default:
                    score = 0;
            }
            System.out.printf("%s: %.2f%n", qtype, score);
            total += score;
        }
        System.out.printf("Total Score: %.2f%n", total);
        sc.close();
    }
}
