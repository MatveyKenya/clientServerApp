import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {

        int port = 8081; // порт любой в доступном диапазоне 0-65536.
        try (ServerSocket serverSocket = new ServerSocket(port);
            Socket clientSocket = serverSocket.accept(); // ждем подключения
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))){

                System.out.println("New connection accepted");
                final String name = in.readLine();
                System.out.printf("Hi %s, your port is %d%n", name, clientSocket.getPort());

        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
