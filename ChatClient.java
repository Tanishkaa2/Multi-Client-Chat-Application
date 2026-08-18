import java.io.*;
import java.net.*;

public class ChatClient {

    public static void main(String[] args) {

        String serverAddress = "127.0.0.1";
        int port = 5000;

        try {
            Socket socket = new Socket(serverAddress, port);

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(
                    socket.getOutputStream(), true);

            BufferedReader userInput = new BufferedReader(
                    new InputStreamReader(System.in));

            new Thread(() -> {
                try {
                    String msg;
                    while ((msg = in.readLine()) != null) {
                        System.out.println(msg);
                    }
                } catch (IOException e) {}
            }).start();

            String userMsg;
            while ((userMsg = userInput.readLine()) != null) {
                out.println(userMsg);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}