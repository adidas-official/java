import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.FileNotFoundException;

public class DemoCopyException {

   public void demoStreamCopy(String inputFile, String outputFile) throws IOException {
      FileInputStream in = new FileInputStream(inputFile);
      FileOutputStream out = new FileOutputStream(outputFile);
      if (outputFile.equalsIgnoreCase("out2.txt")) {
	 out.close();
      }
      int b = in.read(); // read byte of data
      while (b != -1) {
	 out.write(b);
	 b = in.read();
      }
   }
   public static void main(String[] args) {
      try {
	 DemoCopyException demo = new DemoCopyException();
	 if (args.length > 1) {
	    demo.demoStreamCopy(args[0], args[1]);
	 } else {
	    System.err.println("Enter at least two arguments");
	 }
      } catch (FileNotFoundException e) {
	 System.err.println("File not found");
      } catch (IOException e) {
	 System.err.println("Error occured during copying");
	 e.printStackTrace();
      }
   }
}
