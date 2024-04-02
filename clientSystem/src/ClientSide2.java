import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.lang.Thread;

public class ClientSide2{

    private static final String HOST = "192.168.0.204"; // Replace with server's IP address
    private static final int PORT = 8080; // Change port if needed

    public static void main(String[] args) throws IOException {
        // Connect to server
        Socket socket = new Socket(InetAddress.getByName(HOST), PORT);
        System.out.println("Connected to server: " + socket.getRemoteSocketAddress());

        // Input and output streams
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true); // Auto-flush
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        // Get username and send to server
        BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter your username: ");
        String username = keyboard.readLine();
        out.println(username);

        // Receive messages from server in a separate thread
        Thread receiveThread = new Thread(() -> {
            try {
                String message=in.readLine();
                while (message != null) {
                    System.out.println(message);
                }
            } catch (IOException e) {
                System.err.println("Error receiving messages: " + e.getMessage());
            } finally {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        receiveThread.start();

        // Send messages to server from the main thread
        String message;
        while ((message = keyboard.readLine()) != null) {
            out.println(message);
            if (message.equalsIgnoreCase("EXIT")) {
                break;
            }
        }

        // Wait for receive thread to finish (optional)
        try {
            receiveThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Disconnected from server.");
        socket.close(); // Close socket again in case receive thread didn't close it
    }
}