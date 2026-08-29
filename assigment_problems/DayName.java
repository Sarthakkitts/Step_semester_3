package assigment_problems;

public class DayName {
       public static void main(String[] args) {
        printDayName(3);
        printDayName(9);
    }

    static void printDayName(int dayNumber) {
        switch (dayNumber) {
            case 1: System.out.println("Monday"); break;
            case 2: System.out.println("Tuesday"); break;
            case 3: System.out.println("Wednesday"); break;
            case 4: System.out.println("Thursday"); break;
            case 5: System.out.println("Friday"); break;
            case 6: System.out.println("Saturday"); break;
            case 7: System.out.println("Sunday"); break;
            default: System.out.println("Invalid day number"); break;
        }
    }
    
}
