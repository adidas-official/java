import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class DemoTextFile {

    public void write(String fname) throws IOException {
        String months[] = {"jan", "feb", "mar", "apr", "may", "jun", "jul", "aug", "sep", "oct", "nov", "dec"};
        PrintWriter out = new PrintWriter(fname, "UTF-8");
        for (int i = 0; i < months.length; ++i) {
            out.println(months[i]);
        }
        out.close();
    }

    public void start() throws IOException {
        String fname = "text_file.txt";

        write(fname);

	FileInputStream in = new FileInputStream(fname);
        Scanner scan = new Scanner(in);
        while (scan.hasNext()) {
            String str = scan.next();
            System.out.println("Read: " + str);
        }

    }

    public static void main(String[] args) {
        try {
            DemoTextFile demo = new DemoTextFile();
            demo.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
