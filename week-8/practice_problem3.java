import java.util.Scanner;

public class practice_problem3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0.0;
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double weight = sc.nextDouble();
            double distance = sc.nextDouble();
            double customsFee = 0;
            if (type.equals("INTERNATIONAL")) {
                customsFee = sc.nextDouble();
            }
            double fee;
            switch (type) {
                case "STANDARD":
                    fee = 5 + 0.5 * weight + 0.1 * distance;
                    break;
                case "EXPRESS":
                    fee = 15 + 1.0 * weight + 0.2 * distance;
                    break;
                case "INTERNATIONAL":
                    fee = 25 + 2.0 * weight + 0.5 * distance + customsFee;
                    break;
                default:
                    fee = 0;
            }
            System.out.printf("%s: %.2f%n", type, fee);
            total += fee;
        }
        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
