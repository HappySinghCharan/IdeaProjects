package ServerClientHTTP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class HTTPClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 8080); // Connect to server at localhost and port 8080

        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        // Send HTTP request to server
        out.println("GET / HTTP/1.1");
        out.println("Host: localhost");
        out.println();

        // Read and print HTTP response from server
        String response;
        while ((response = in.readLine()) != null) {
            System.out.println(response);
        }

        socket.close(); // Close connection
    }
}
