package ServerClientHTTP;

import fi.iki.elonen.NanoHTTPD;

import java.io.IOException;

public class HTTPServer extends NanoHTTPD {
    public HTTPServer(int port) {
        super(port);
    }

    @Override
    public Response serve(IHTTPSession session) {
        String msg = "<html><body><h1>Hello from server!</h1><p>You requested: " + session.getUri() + "</p></body></html>";
        return newFixedLengthResponse(msg);
    }

    public static void main(String[] args) {
        int port = 8080; // Change port as needed
        HTTPServer server = new HTTPServer(port);
        try {
            server.start(NanoHTTPD.SOCKET_READ_TIMEOUT, false);
            System.out.println("Server started on port " + port);
        } catch (IOException e) {
            System.err.println("Error starting server: " + e.getMessage());
        }
    }
}
