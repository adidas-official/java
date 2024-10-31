import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DemoFileStream {

   public void demoStreamCopy(String inputFile, String outputFile) throws IOException {
      FileInputStream in = new FileInputStream(inputFile);
      FileOutputStream out = new FileOutputStream(outputFile);
      int b = in.read(); // read byte of data
      while (b != -1) {
	 out.write(b);
	 b = in.read();
      }
   }
   public static void main(String[] args) {
      try {
	 DemoFileStream demo = new DemoFileStream();
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
