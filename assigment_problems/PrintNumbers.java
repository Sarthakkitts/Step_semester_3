package assigment_problems;

public class PrintNumbers {

    public static void main(String[] args) {
        printNumbersUpToN(5);
    }

    static void printNumbersUpToN(int n) {
        for (int i = 1; i <= n; i++) {
            System.out.println(i);
        }
    }
}
