package ukol5.knihovna;
import java.lang.Math;
import java.util.Scanner;
import java.time.LocalDate;
import java.io.File;

public class Knihovna {

    private Scanner scanner;

    public Knihovna() {
        this.scanner = new Scanner(System.in);
    }

    public void print_menu() {
        System.out.println("1. Zadej cislo");
        System.out.println("2. Mocniny cisla");
        System.out.println("3. Odmocniny cisla");
        System.out.println("4. Konec");
        System.out.println("Vyber moznost: ");  
    }

    public int get_user_input() {
        return scanner.nextInt();
    }

    public String get_mocnina(double cislo, int mocnina) {
        return String.format("Mocnina (%d) cisla %.2f je %.2f", mocnina, cislo, mocnina_cisla(cislo, mocnina));
    }

    public String get_odmocnina(double cislo, int odmocnina) {
        return String.format("Odmocnina (%d) cisla %.2f je %.2f", odmocnina, cislo, odmocnina_cisla(cislo, odmocnina));
    }   

    public static double mocnina_cisla(double cislo, int mocnina) {
        return Math.pow(cislo, mocnina);
    }

    public static double odmocnina_cisla(double cislo, int odmocnina) {
        return Math.pow(cislo, 1.0/odmocnina);
    }

    public static void goniometricke_funkce(double uhel) {
        System.out.printf("%-15s%-15s%-15s%-15s%-15s%n", "Uhel", "Sinus", "Kosinus", "Tangens", "Cotangens");
        System.out.printf("%-15.2f%-15.2f%-15.2f%-15.2f%-15.2f%n", uhel, Math.sin(uhel), Math.cos(uhel), Math.tan(uhel), 1 / Math.tan(uhel));
    }

    public static void trojuhelnik_pravouhly(double a, double b) {
        System.out.println("\nPravouhly trojuhelnik");
        double prepona = Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
        double obvod = a + b + prepona;
        double obsah = (a * b) / 2;
        double u_a_prepona = Math.asin(a / prepona);
        double u_b_prepona = Math.asin(b / prepona);
        System.out.printf("%s%10s%10s%10s%10s\n", "Obvod" , "Obsah", "Prepona", "Uhel Alfa", "Uhel Beta");
        System.out.printf("%-10.2f%-10.2f%-10.2f%-10.2f%-10.2f\n", obvod, obsah, prepona, Math.toDegrees(u_a_prepona), Math.toDegrees(u_b_prepona));
    }

    public static void trojuhelnik_obecny(double a, double b, double c) {
        System.out.println("\nObecny trojuhelnik");
        double obvod = a + b + c;
        double s = obvod / 2;
        double obsah = Math.sqrt(s * (s - a) * (s - b) * (s - c));
        double u_a = Math.acos((Math.pow(b, 2) + Math.pow(c, 2) - Math.pow(a, 2)) / (2 * b * c));
        double u_b = Math.acos((Math.pow(a, 2) + Math.pow(c, 2) - Math.pow(b, 2)) / (2 * a * c));
        double u_c = Math.acos((Math.pow(a, 2) + Math.pow(b, 2) - Math.pow(c, 2)) / (2 * a * b));
        System.out.printf("%-20s%-20s%-20s%-20s%-20s%n", "Strana a", "Strana b", "Strana c", "Obvod", "Obsah");
        System.out.printf("%-20.2f%-20.2f%-20.2f%-20.2f%-20.2f%n", a, b, c, obvod, obsah);
        System.out.printf("%-20s%-20s%-20s%n", "Uhel Alfa", "Uhel Beta", "Uhel Gama");
        System.out.printf("%-20.2f%-20.2f%-20.2f%n", Math.toDegrees(u_a), Math.toDegrees(u_b), Math.toDegrees(u_c));
    }

    public static void platnost_datumu(int den, int mesic, int rok) {
        System.out.println(isDateValid(den, mesic, rok));
    }

    public static void aktualni_datum() {
        LocalDate today = LocalDate.now();
        String day = (today.getDayOfMonth() < 10 ? "0" : "") + today.getDayOfMonth();
        String month = (today.getMonthValue() < 10 ? "0" : "") + today.getMonthValue();
        String hour = (java.time.LocalTime.now().getHour() < 10 ? "0" : "") + java.time.LocalTime.now().getHour();
        String minute = (java.time.LocalTime.now().getMinute() < 10 ? "0" : "") + java.time.LocalTime.now().getMinute();
        String second = (java.time.LocalTime.now().getSecond() < 10 ? "0" : "") + java.time.LocalTime.now().getSecond();
        System.out.println(day + "." + month + "." + today.getYear() + " " + hour + ":" + minute + ":" + second);
    }   

    public static boolean isDateValid(int day, int month, int year) {
        if (year < 1 || month < 1 || month > 12 || day < 1 || day > 31) {
            return false;
        }
        if (month == 2) {
            if (isLeapYear(year)) {
                return day <= 29;
            } else {
                return day <= 28;
            }
        }
        if (month == 4 || month == 6 || month == 9 || month == 11) {
            return day <= 30;
        }
        return true;
    }

    private static boolean isLeapYear(int year) {
        if (year % 4 == 0) {
            if (year % 100 == 0) {
                return year % 400 == 0;
            }
            return true;
        }
        return false;
    }

    public static void listdir(String path) {
        File file = new File(path);
        if (!file.exists() || !file.isDirectory()) {
            System.out.println("The specified path does not exist or is not a directory.");
            return;
        }
        try {
            File[] files = file.listFiles();
            if (files == null) {
                System.out.println("Permission denied or an I/O error occurred.");
                return;
            }
            System.out.printf("%-13s%-13s%-13s%n", "Perm", "Size", "Name");
            for (File f : files) {
                String permissions = (f.canRead() ? "r" : "-") + (f.canWrite() ? "w" : "-") + (f.canExecute() ? "x" : "-");
                System.out.printf("%-13s%-13d%-13s%n", permissions, f.length(), f.getName());
            }
        } catch (SecurityException e) {
            System.out.println("Permission denied to read the directory.");
        }
    }

    public static void edit(String source, String destination, String mode, boolean overwrite) {
        File sourceFile = new File(source);
        File destinationFile = destination != null ? new File(destination) : null;

        if (!sourceFile.exists()) {
            System.out.println("The source file or folder does not exist.");
            return;
        }

        if ("d".equals(mode)) {
            delete(sourceFile);
        } else if (destinationFile != null && destinationFile.exists() && !overwrite) {
            System.out.println("The destination file or folder already exists.");
            return;
        } else if ("c".equals(mode)) {
            copy(sourceFile, destinationFile);
        } else if ("m".equals(mode)) {
            move(sourceFile, destinationFile);
        } else {
            System.out.println("Invalid mode.");
        }
    }

    // Overloaded methods with default values for the arguments
    public static void edit(String source, String destination, String mode) {
        edit(source, destination, mode, false);
    }

    public static void edit(String source, String mode) {
        edit(source, null, mode, false);
    }

    private static void copy(File source, File destination) {
        if (source.isDirectory()) {
            if (!destination.exists()) {
                destination.mkdirs();
            }

            String[] children = source.list();
            if (children != null) {
                for (String child : children) {
                    copy(new File(source, child), new File(destination, child));
                }
            }
        } else {
            try (java.io.FileInputStream fis = new java.io.FileInputStream(source);
                 java.io.FileOutputStream fos = new java.io.FileOutputStream(destination);
                 java.nio.channels.FileChannel sourceChannel = fis.getChannel();
                 java.nio.channels.FileChannel destChannel = fos.getChannel()) {
                destChannel.transferFrom(sourceChannel, 0, sourceChannel.size());
            } catch (java.io.IOException e) {
                System.out.println("Error copying file: " + e.getMessage());
            }
        }
    }

    private static void move(File source, File destination) {
        if (!source.renameTo(destination)) {
            System.out.println("Error moving file or directory.");
        }
    }

    private static void delete(File file) {
        if (file.isDirectory()) {
            String[] children = file.list();
            if (children != null) {
                for (String child : children) {
                    delete(new File(file, child));
                }
            }
        }
        if (!file.delete()) {
            System.out.println("Error deleting file or directory.");
        }
    }

    public static void main(String[] args) {
        Knihovna.goniometricke_funkce(30);
        Knihovna.trojuhelnik_pravouhly(3, 4);
        Knihovna.trojuhelnik_obecny(3, 4, 5);
        Knihovna.aktualni_datum();
    }

}