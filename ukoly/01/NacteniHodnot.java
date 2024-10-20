import java.util.Scanner;

public class NacteniHodnot {

    public static short nacti_short(Scanner s) throws FormatException, NumberFormatException {

        try {
            String input = s.next();
            long hodnota = Long.parseLong(input);
            if (hodnota < Short.MIN_VALUE || hodnota > Short.MAX_VALUE) {
                throw new FormatException("Překročen rozsah údaje");
            }

            short hodnota_short = (short) hodnota;
            return hodnota_short;
        } catch (NumberFormatException e) {
            throw new FormatException("Špatný formát údaje");
        }   

    }

    // write method for each primitive type with names nacti_int, nacti_float, nacti_double, nacti_char a nacti_string
    // each method should throw FormatException with message "Špatný formát údaje" if the input is not in the correct format
    // and NumberFormatException if the input is in the correct format but the value is out of range
    public static int nacti_int(Scanner s) throws FormatException, NumberFlowException {
        try {
            String input = s.next(); 
            long hodnota = Long.parseLong(input);
            if (hodnota < Integer.MIN_VALUE || hodnota > Integer.MAX_VALUE) {
                throw new FormatException("Překročen rozsah údaje");
            }

            int hodnota_int = (int) hodnota;
            return hodnota_int;
        } catch (NumberFormatException e) {
            throw new NumberFlowException("Špatný formát údaje");
        }   
    }

    public static long nacti_long(Scanner s) throws FormatException, NumberFlowException {
        try {
            String input = s.next();
            long hodnota_long = Long.parseLong(input);
            if (hodnota_long < Long.MIN_VALUE || hodnota_long > Long.MAX_VALUE) {
                throw new FormatException("Překročen rozsah údaje");
            }

            return hodnota_long;
        } catch (NumberFormatException e) {
            throw new NumberFlowException("Špatný formát údaje");
        }   
    }

    public static float nacti_float(Scanner s) throws FormatException, NumberFlowException {
        try {
            String input = s.next();
            double hodnota = Double.parseDouble(input);
            if (hodnota < Float.MIN_VALUE || hodnota > Float.MAX_VALUE) {
                throw new FormatException("Překročen rozsah údaje");
            }

            float hodnota_float = (float) hodnota;
            return hodnota_float;
        } catch (NumberFormatException e) {
            throw new NumberFlowException("Špatný formát údaje");
        }   
    }

    public static double nacti_double(Scanner s) throws FormatException, NumberFlowException {
        try {
            String input = s.next();
            double hodnota_double = Double.parseDouble(input);
            if (hodnota_double < Double.MIN_VALUE || hodnota_double > Double.MAX_VALUE) {
                throw new FormatException("Překročen rozsah údaje");
            }

            return hodnota_double;
        } catch (NumberFormatException e) {
            throw new NumberFlowException("Špatný formát údaje");
        }   
    }

    public static char nacti_char(Scanner s) throws FormatException {
        String input = s.next();
        if (input.length() != 1) {
            throw new FormatException("Špatný formát údaje");
        }

        return input.charAt(0);
    }

    public static String nacti_string(Scanner s) {
        String input = s.next();
        System.out.println("Zadáno: " + input);
        return input;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while (true)
        try {
            System.out.println("Zadejte hodnotu short:");
            short male_cislo = nacti_short(s);
            System.out.println("Zadáno: " + male_cislo);

            System.out.println("Zadejte hodnotu int:");
            int cislo = nacti_int(s);
            System.out.println("Zadáno: " + cislo);

            System.out.println("Zadejte hodnotu float:");
            float hodnota_float = nacti_float(s);
            System.out.println("Zadáno: " + hodnota_float);

            System.out.println("Zadejte hodnotu double:");
            double hodnota_double = nacti_double(s);
            System.out.println("Zadáno: " + hodnota_double);

            System.out.println("Zadejte hodnotu char:");
            char hodnota_char = nacti_char(s);
            System.out.println("Zadáno: " + hodnota_char);

            System.out.println("Zadejte hodnotu string:");
            String hodnota_string = nacti_string(s);
            System.out.println("Zadáno: " + hodnota_string);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            s.close();
        }
        
    }
}

