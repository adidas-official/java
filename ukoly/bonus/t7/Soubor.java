import java.io.File;
import java.util.Scanner;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Soubor {

    // Implementujte jednoduchou aplikaci pro práci s textovými soubory: uživatel může zadat text,
    // který bude uložen do souboru, a následně může být zobrazen.
    private String input;

    // Zepta se usera na input; ulozi do promenne
    public String getUserInput() {
        System.out.println("Napiste text, ktery chcete ulozit");
        Scanner scanner = new Scanner(System.in);
        String content = scanner.nextLine() + '\n'; 
        scanner.close();
        return content;
    }

    public void saveToFile(String file_output) throws IOException {

        File outputFile = new File(file_output);

        FileWriter fileWriter = null;
        
        try {
            fileWriter = new FileWriter(outputFile);
            fileWriter.write(this.input);

        } catch (IOException e) {
            System.err.println("File not found");
        } finally {
            fileWriter.close();
        }

    }

    public void readFile(String file_input) throws IOException {
        File inputFile = new File(file_input);

        FileReader fileReader = null;

        if (inputFile.exists()) {
            try {
                int c;
                fileReader = new FileReader(inputFile);
                while ((c = fileReader.read()) != -1) {
                    System.out.print(Character.toString(c));
                }

            } catch (IOException e) {
                System.err.println("File not found");
                System.exit(-1);
            }
        }
    }

    public Soubor() {
        this.input = getUserInput();
    }

    public static void main(String[] args) throws IOException {
        Soubor s = new Soubor();
        s.saveToFile("outputFile.txt");
        s.readFile("outputFile.txt");
    }
    
}