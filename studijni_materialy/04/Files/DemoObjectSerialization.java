import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class DemoObjectSerialization {

    void write(Customer customer, String fname) throws IOException {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fname))) {
            out.writeObject(customer);
        }
    }

    Customer read(String fname) throws IOException, ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(fname));
        return (Customer) in.readObject();
    }

    public void start(String fname) throws IOException, ClassNotFoundException {
        Customer customer = new Customer("AAA", "BBB", 47);
        System.out.println("Customer: " + customer);
        write(customer, fname);
        customer = new Customer("ZZZ", "WWW", 17);
        System.out.println("Customer: " + customer);
        customer = read(fname);
        System.out.println("Customer: " + customer);
    }

    public static void main(String[] args) {
        try {
            DemoObjectSerialization demo = new DemoObjectSerialization();

            demo.start(args.length > 0 ? args[0] : "customer.bin");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
