import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class Proud {

    public static void readFile(String filename) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            System.out.println(ois.readObject());
        }
    }

    public static void main(String[] args) {
        Proud.readFile("file.txt");
        int cislo3 = 20;
        byte cislo4 = (byte) cislo3;
        byte cislo2 = 20;
        byte cislo5 = (byte)20;
        int cislo6=cislo5;
        byte cislo8 = cislo3;
        byte cislo1 = (byte) 20;
    }
}