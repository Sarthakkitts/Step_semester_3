import java.util.Scanner;

public class assignment_problem1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0.0;
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double amount = sc.nextDouble();
            double finalAmount;
            switch (type) {
                case "STUDENT":
                    finalAmount = amount * 0.9;
                    break;
                case "STAFF":
                    finalAmount = amount * 0.95;
                    break;
                case "GUEST":
                    finalAmount = amount + 10;
                    break;
                default:
                    finalAmount = 0;
            }
            System.out.printf("%s: %.2f%n", type, finalAmount);
            total += finalAmount;
        }
        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
