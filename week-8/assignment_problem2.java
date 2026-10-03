import java.util.Scanner;

public class assignment_problem2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0.0;
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            int hours = sc.nextInt();
            double charge;
            switch (type) {
                case "BIKE":
                    charge = hours * 10;
                    break;
                case "CAR":
                    if (hours <= 1) {
                        charge = 30;
                    } else {
                        charge = 30 + (hours - 1) * 20;
                    }
                    break;
                case "TRUCK":
                    charge = hours * 50;
                    if (charge < 100) charge = 100;
                    break;
                default:
                    charge = 0;
            }
            System.out.printf("%s: %.2f%n", type, charge);
            total += charge;
        }
        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
