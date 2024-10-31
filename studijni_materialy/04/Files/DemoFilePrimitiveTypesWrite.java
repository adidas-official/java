import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DemoFilePrimitiveTypesWrite {

    public static void main(String[] args) {
        try {
            String fname = args.length > 0 ? args[0] : "out.bin";
            DataOutputStream out = new DataOutputStream(
                    new FileOutputStream(fname));

            for (int i = 0; i < 10; ++i) {
                double d = (Math.random() % 100) / 10.0;
                out.writeInt(i);
                out.writeDouble(d);
                System.out.println("Write " + i + " " + d);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
