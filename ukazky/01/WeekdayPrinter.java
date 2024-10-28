public class WeekdayPrinter {
    public static void main(String[] args) {
        if(args.length > 0) {
            // Převedeme vstupní string na číslo
            try {
                int dayNumber = Integer.parseInt(args[0]);
                printDayOfTheWeek(dayNumber);
            } catch (NumberFormatException e) {
                System.out.println("Please provide a valid number.");
            }
        } else {
            System.out.println("Usage: java WeekdayPrinter [dayNumber]");
        }
    }

    public static void printDayOfTheWeek(int dayNumber) {
        // Použijeme switch statement k vypsání dne v týdnu
        switch(dayNumber) {
            case 1:
                System.out.println("Monday");
                break;
            case 2:
                System.out.println("Tuesday");
                break;
            case 3:
                System.out.println("Wednesday");
                break;
            case 4:
                System.out.println("Thursday");
                break;
            case 5:
                System.out.println("Friday");
                break;
            case 6:
                System.out.println("Saturday");
                break;
            case 7:
                System.out.println("Sunday");
                break;
            default:
                System.out.println("Invalid number. Please enter a number between 1 and 7.");
        }
    }
}
