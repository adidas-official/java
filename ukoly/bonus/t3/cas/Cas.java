import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import static java.time.temporal.ChronoUnit.DAYS;
import java.util.Scanner;
import static java.lang.Math.abs;

public class Cas {

    // Napište kód, který vypíše aktuální datum a čas v různých formátech.
    public static String casTed() {

        LocalDate ted = LocalDate.now();
        DateTimeFormatter dmy = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        DateTimeFormatter ymd = DateTimeFormatter.ofPattern("yyyy-MM-d");
        DateTimeFormatter mdy = DateTimeFormatter.ofPattern("MM/d/yy");

        String output = "European format: " + ted.format(dmy) + "\nEast Asia format: " + ted.format(ymd) + "\nU.S. format: " + ted.format(mdy);

        return output;
    }

    // Vytvořte funkci, která vypočítá počet dní mezi dvěma daty.
    public static long dateDiff(LocalDate d1, LocalDate d2) {

        long diff = DAYS.between(d1, d2);
        return abs(diff);
    }

    public static LocalDate getDate(Scanner scanner) {
        System.out.println("Zadejte datum");
        System.out.print("Rok: ");
        int y = scanner.nextInt();
        System.out.print("Mesic: ");
        int m = scanner.nextInt();
        System.out.print("Den: ");
        int d = scanner.nextInt();
        return LocalDate.of(y, m, d);
    }

    public static void main(String[] args) {
        
        System.out.println("--- Format casu ---");
        System.out.println(Cas.casTed());
        System.out.println("--- ---");


        DateTimeFormatter dmy = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        Scanner scanner = new Scanner(System.in);
        LocalDate date1 = Cas.getDate(scanner);
        System.out.println("Zadali jste " + date1.format(dmy));

        LocalDate date2 = Cas.getDate(scanner);
        System.out.println("Zadali jste " + date2.format(dmy));

        System.out.println("Pocet dni mezi " + date1.format(dmy) + " a " + date2.format(dmy) + " je " + Cas.dateDiff(date1, date2));
        scanner.close();
    }

}