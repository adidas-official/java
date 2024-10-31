import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Proud {

    public static void readFile(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Proud.readFile("file.txt");
    }
}