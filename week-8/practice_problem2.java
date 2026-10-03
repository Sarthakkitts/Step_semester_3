import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class practice_problem2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine(); // consume newline
        LocalDate currentDate = LocalDate.of(2023, 10, 26);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine().trim();
            if (line.isEmpty()) continue;
            // split by space, but title may be quoted and contain spaces? Assume no spaces for simplicity.
            String[] parts = line.split(" ");
            String type = parts[0];
            // Reconstruct title from remaining parts, stripping quotes
            StringBuilder titleBuilder = new StringBuilder();
            for (int j = 1; j < parts.length; j++) {
                if (j > 1) titleBuilder.append(" ");
                titleBuilder.append(parts[j]);
            }
            String title = titleBuilder.toString().replace("\"", "");
            int days;
            switch (type) {
                case "BOOK":
                    days = 14;
                    break;
                case "DVD":
                    days = 7;
                    break;
                case "MAGAZINE":
                    days = 3;
                    break;
                default:
                    days = 0;
            }
            LocalDate dueDate = currentDate.plusDays(days);
            System.out.printf("%s: %s%n", title, dueDate.format(formatter));
        }
        sc.close();
    }
}
