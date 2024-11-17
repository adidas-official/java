package ukol5.knihovna;
import java.lang.Math;
import java.util.Scanner;

public class Knihovna {

    private int cislo;
    private double[] mocniny;
    private double[] odmocniny;

    public Knihovna(int cislo) {
        this.cislo = cislo;
        this.mocniny = new double[2];
        this.odmocniny = new double[2];
    }

    public void print_menu() {
        System.out.println("1. Zadej cislo");
        System.out.println("2. Mocniny cisla");
        System.out.println("3. Odmocniny cisla");
        System.out.println("4. Konec");
        System.out.println("Vyber moznost: ");  
    }

    public int get_user_input() {
        try (Scanner scanner = new Scanner(System.in)) {
            int user_input = scanner.nextInt();
            return user_input;
        }
    }

    public void run() {
        if (this.cislo == 0) {
            System.out.println("Cislo neni nastaveno. Ukonceni programu.");
            return;
        }
        int user_input = 0;
        while (user_input != 4) {
            print_menu();
            user_input = get_user_input();
            switch (user_input) {
                case 1:
                    System.out.println("Zadej cislo: ");
                    this.cislo = get_user_input();
                    break;
                case 2:
                    mocnina_cisla();
                    break;
                case 3:
                    odmocnina_cisla();
                    break;
                case 4:
                    System.out.println("Konec");
                    break;
                default:
                    System.out.println("Neplatna volba");
                    break;
            }
        }
    }

    public void mocnina_cisla() {
        for (int i = 0; i < 2; i++) {
            this.mocniny[i] = Math.pow(this.cislo, i+2);
        }
    }

    public void odmocnina_cisla() {
        this.odmocniny[0] = Math.sqrt(this.cislo);
        this.odmocniny[1] = Math.cbrt(this.cislo);
    }

    public String get_mocniny_table() {

        // return table of powers (mocniny) of the number
        // print the number itself in first column
        // print the power of 2 an 3 in the second column
        // then print the square root and cubic root of the number in the third column
        // return the table as a string

        String output = String.format("%-10s %-10s %-10s\n", "Cislo " + this.cislo, "Mocniny", "Odmocniny");
        for (int i = 0; i < 2; i++) {
            output += String.format("%-10s %-10.2f %-10.2f\n", "", this.mocniny[i], this.odmocniny[i]);
        }

        return output;

    }

    public static void main(String[] args) {
        int cislo = 27;
        Knihovna knihovna = new Knihovna(cislo);
        System.out.println(knihovna.get_mocniny_table());
    }


}