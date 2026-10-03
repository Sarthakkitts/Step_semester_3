import java.util.Scanner;

public class practice_problem1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0.0;
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double amount = sc.nextDouble();
            double adjusted;
            switch (type) {
                case "CARD":
                    adjusted = amount * 1.02;
                    break;
                case "WALLET":
                    adjusted = amount * 1.01;
                    break;
                case "BANKTRANSFER":
                    adjusted = amount;
                    break;
                default:
                    adjusted = 0;
            }
            System.out.printf("%s: %.2f%n", type, adjusted);
            total += adjusted;
        }
        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
