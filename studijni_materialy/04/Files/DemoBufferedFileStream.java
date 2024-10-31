
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DemoBufferedFileStream {

    public void demoStreamCopy(String inputFile, String outputFile) throws IOException {
        BufferedInputStream in = new BufferedInputStream(new FileInputStream(inputFile));
        BufferedOutputStream out =  new BufferedOutputStream(new FileOutputStream(outputFile));
        int b = in.read(); // read byte of data
        while (b != -1) {
            out.write(b);
            b = in.read();
        }
        out.flush(); //It is necessary to flush the output before end
    }

    public static void main(String[] args) {
        try {
            DemoBufferedFileStream demo = new DemoBufferedFileStream();
            if (args.length > 1) {
                demo.demoStreamCopy(args[0], args[1]);
            } else {
                System.err.println("Enter at least two arguments");
            }
        } catch (IOException e) {
            System.err.println("Error occured during copying");
        }
    }
}
