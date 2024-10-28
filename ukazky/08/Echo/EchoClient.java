import java.io.*;
import java.net.Socket;

public class EchoClient {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 8080);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        ) {
            String userInput;
            while ((userInput = stdIn.readLine()) != null) {
                out.println(userInput);
                System.out.println("Server says: " + in.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
