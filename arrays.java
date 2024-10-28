import java.io.IOException;
import java.util.ArrayList;

public class arrays {

    public static void ar1() {
        ArrayList<String> array1 = new ArrayList<String>();
        String[] array2 = new String[5];

        System.out.println("Array 1: " + array1);
        System.out.println("Array 2: " + array2);
    }

    public static String buffering() throws IOException {
        byte[] buffer = new byte[5];
        // access the input stream
        System.in.read(buffer); // precte prvych 5 bytu
        return new String(buffer);
    }

    public static void main(String[] args) {

        try {

            System.out.println("Zadajte text: ");
            String result;
            while ((result = buffering()) != null) {
                System.out.println("Vas text: " + result);
            }
            // exit the program
            System.out.println("Konec programu");
            System.exit(0);
            
        } catch (IOException e) {
            System.out.println("Chyba pri nacitani");
        }
    }
}
