import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class assignment_problem5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine(); // consume newline
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine().trim();
            if (line.isEmpty()) continue;
            String[] parts = line.split(" ");
            String type = parts[0];
            String name = parts[1];
            LocalDate startDate = LocalDate.parse(parts[2], formatter);
            int validity;
            switch (type) {
                case "BASIC":
                    validity = 30;
                    break;
                case "STANDARD":
                    validity = 90;
                    break;
                case "PREMIUM":
                    validity = 365;
                    break;
                default:
                    validity = 0;
            }
            LocalDate renewal = startDate.plusDays(validity);
            System.out.printf("%s: %s%n", name, renewal.format(formatter));
        }
        sc.close();
    }
}
