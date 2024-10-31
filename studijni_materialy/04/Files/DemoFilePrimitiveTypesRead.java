import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class DemoFilePrimitiveTypesRead {

    public static void main(String[] args) {
        try {
            String fname = args.length > 0 ? args[0] : "out.bin";
            DataInputStream in = new DataInputStream(
                    new FileInputStream(fname));

            for (int i = 0; i < 10; ++i) {
                int v = in.readInt();
                double d = in.readDouble();
                System.out.println("Read " + v + " " + d);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
