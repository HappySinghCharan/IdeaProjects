//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) {
        try {
            // Connect to server on specified IP address and port 12345
            Socket socket = new Socket("192.168.0.204", 12345);

            // Create input and output streams for communication
            BufferedReader inFromServer = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter outToServer = new PrintWriter(socket.getOutputStream(), true);

            // Send message to server
            outToServer.println("Hello from client!");

            // Receive response from server
            String response = inFromServer.readLine();
            System.out.println("Server says: " + response);

            // Close streams and socket
            inFromServer.close();
            outToServer.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

