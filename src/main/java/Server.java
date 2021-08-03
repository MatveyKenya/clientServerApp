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
                out.println("Hi, Write your name:");
                final String name = in.readLine();
                out.printf("Hi %s, your port is %d%n", name, clientSocket.getPort());
                out.println("Are you child? (yes/no)");

                if (in.readLine().equals("yes")){
                    out.printf("Welcome to the kids area, %s! Let's play!", name);
                }else {
                    out.printf("Welcome to the adult zone, %s! Have a good rest, or a good working day!", name);
                }


        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
