import java.io.*;
import java.net.*;
import java.util.*;

public class ChatServer {

    private static Set<ClientHandler> clients = new HashSet<>();

    public static void main(String[] args) {
        int port = 5000;
        System.out.println("Server started...");

        try (ServerSocket serverSocket = new ServerSocket(port)) {

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected");

                ClientHandler client = new ClientHandler(socket);
                clients.add(client);
                client.start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void broadcast(String message, ClientHandler excludeUser) {
        for (ClientHandler client : clients) {
            if (client != excludeUser) {
                client.sendMessage(message);
            }
        }
    }

    static void removeClient(ClientHandler client) {
        clients.remove(client);
    }
}

class ClientHandler extends Thread {

    private Socket socket;
    private PrintWriter out;
    private BufferedReader in;
    private String name;

    ClientHandler(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);

            out.println("Enter your name:");
            name = in.readLine();
            ChatServer.broadcast(name + " joined the chat", this);

            String message;
            while ((message = in.readLine()) != null) {
                ChatServer.broadcast(name + ": " + message, this);
            }

        } catch (IOException e) {
            System.out.println(name + " disconnected");
        } finally {
            try {
                socket.close();
            } catch (IOException e) {}
            ChatServer.removeClient(this);
            ChatServer.broadcast(name + " left the chat", this);
        }
    }

    void sendMessage(String message) {
        out.println(message);
    }
}