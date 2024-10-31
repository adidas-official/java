import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class test6a {
    

    public static void main(String[] args) {
        String s1 = "java Java";

        String s2 = s1.substring(s1.indexOf("J")).toUpperCase();
        System.out.println(s2);

        String a = "abc";
        System.out.println(a.toUpperCase());
        System.out.println(a.substring(a.length()-1));

        boolean comp = a == a.toUpperCase().toLowerCase();
        System.out.println(comp);

        String b = "java";
        String c = "java";

        int d = b.compareTo(c);
        System.out.println(d);

        // String data = "5;4;3;2;1";
        // int[] cisla = data.split(";");

        String s8 = "java Java java";
        String s0 = s8.substring(s8.indexOf(' ') + 1, s8.lastIndexOf(' '));
        System.out.println(s0);

        String text = "java";
        System.out.println(text.charAt(text.length() -1));

        String text2 = "   abc efg";
        int i = text2.trim().indexOf(' ');

        // save value 123 to binary file

        int value = 123;
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream("file.dat"))) {
            dos.writeInt(value);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
