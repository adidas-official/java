import java.io.IOException;
import java.io.RandomAccessFile;

public class DemoRandomAccess {

    public void write(String fname, int n) throws IOException {
        RandomAccessFile out = new RandomAccessFile(fname, "rw");
        for (int i = 0; i < n; ++i) {
            out.writeInt(i);
            System.out.println("write: " + i);
        }
        out.close();
    }

    public void start() throws IOException {
        String fname = "numbers.bin";
        write(fname, 10);

        final int SIZE = Integer.SIZE / 8;
        RandomAccessFile in = new RandomAccessFile(fname, "r");
        for (int i = 0; i < 5; ++i) {
            in.seek(i * 2 * SIZE);
            int v = in.readInt();
            System.out.println("read: " + v);
        }
        in.close();
    }

    public static void main(String[] args) {
        DemoRandomAccess demo = new DemoRandomAccess();
        try {
            demo.start();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
