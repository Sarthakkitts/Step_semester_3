import java.util.Scanner;

public class assignment_problem4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0.0;
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            double salary = sc.nextDouble();
            double bonus;
            switch (type) {
                case "FULLTIME":
                    bonus = salary * 0.10;
                    break;
                case "PARTTIME":
                    bonus = salary * 0.05;
                    break;
                case "INTERN":
                    bonus = 2000.0;
                    break;
                default:
                    bonus = 0;
            }
            System.out.printf("%s: %.2f%n", name, bonus);
            total += bonus;
        }
        System.out.printf("Total Bonus: %.2f%n", total);
        sc.close();
    }
}
