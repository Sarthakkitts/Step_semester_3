import java.util.Scanner;

public class practice_problem5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0.0;
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double distance = sc.nextDouble();
            double peakFactor = 1.0;
            if (type.equals("METRO")) {
                peakFactor = sc.nextDouble();
            }
            double fare;
            switch (type) {
                case "BUS":
                    fare = 2 + 0.1 * distance;
                    if (fare > 10) fare = 10;
                    break;
                case "TRAIN":
                    fare = 3 + 0.15 * distance;
                    break;
                case "METRO":
                    fare = (1.5 + 0.2 * distance) * peakFactor;
                    break;
                default:
                    fare = 0;
            }
            System.out.printf("%s: %.2f%n", type, fare);
            total += fare;
        }
        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
