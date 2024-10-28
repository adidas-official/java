/*

    Hlavní Body:
        Vlákna: Vytváření vláken pomocí implementace Runnable.
        Socket Programming: Jak pracovat s ServerSocket a Socket.
        I/O Streams: Používání PrintWriter a BufferedReader pro komunikaci mezi klientem a serverem.
    
    Analýza Kódu:
        Echo Server:
        Očekává připojení klienta na portu 8080.
        Po připojení klienta vytváří nové vlákno (ClientHandler) pro ošetření komunikace.
    
        ClientHandler:
        Čte vstup od klienta a posílá zpět "echo".
        Echo Client:
        Připojí se k serveru a čte uživatelský vstup ze standardního vstupu.
        Odesílá uživatelský vstup serveru a vypisuje odpověď.
    
    Mini Cvičení:
        Více Klientů: Testujte aplikaci s více klienty současně a pozorujte chování serveru.
        Bezpečnostní Zlepšení: Jak byste mohli zlepšit bezpečnost komunikace mezi klientem a serverem?
        GUI Klient: Vytvořte GUI pro klienta, aby uživatel mohl snadno zadávat a přijímat zprávy.

 */
import java.net.ServerSocket;
import java.net.Socket;
import java.io.*;

public class EchoServer {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(8080)) {
            while (true) {
                Socket clientSocket = serverSocket.accept();
                new Thread(new ClientHandler(clientSocket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ClientHandler implements Runnable {
    private final Socket clientSocket;

    public ClientHandler(Socket socket) {
        this.clientSocket = socket;
    }

    @Override
    public void run() {
        try (
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        ) {
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                System.out.println("Received: " + inputLine);
                out.println("Echo: " + inputLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
