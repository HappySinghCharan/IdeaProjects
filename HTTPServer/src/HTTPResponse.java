import java.io.*;
import java.net.Socket;

public class HTTPResponse {
    public static String guessContentType(String fileName) {
        if (fileName.endsWith(".html") || fileName.endsWith(".htm")) {
            return "text/html";
        } else if (fileName.endsWith(".txt")) {
            return "text/plain";
        } else if (fileName.endsWith(".jpg") || fileName.endsWith(".jpeg")) {
            return "image/jpeg";
        } else if (fileName.endsWith(".png")) {
            return "image/png";
        } else if (fileName.endsWith(".gif")) {
            return "image/gif";
        } else if (fileName.endsWith(".pdf")) {
            return "application/pdf";
        } else if (fileName.endsWith(".css")) {
            return "text/css";
        } else if (fileName.endsWith(".js")) {
            return "application/javascript";
        } else {
            return "application/octet-stream";
        }
    }
    public static void requestHandler(String path, Socket client) throws IOException {
        //Path filePath= Paths.get(path);
        PrintWriter writer=new PrintWriter(new OutputStreamWriter(client.getOutputStream()));

        String conct = "/home/happy.charan/IdeaProjects/HTTPServer/files";
        String actualPath = conct + path;
        File resource = new File(actualPath);

        if (!resource.exists()) {
            return;
        }
        //Finding out the content type of file
        String contentType = guessContentType(resource.getName());

        String crlf = "\r\n";
        //status line and content type
        writer.print("HTTP/1.1 200 OK" + crlf);
        writer.print("Content-Type: " + contentType + crlf);
        // Get file length
        long fileLength = resource.length();
        writer.print("Content-Length: " + fileLength + crlf);
        // End of headers
        writer.print(crlf);
        writer.flush();
        // Send file contents in chunks
        try (InputStream resourceInputStream = new FileInputStream(resource)) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = resourceInputStream.read(buffer)) != -1) {
                client.getOutputStream().write(buffer, 0, bytesRead);
            }
        }
        client.close();

    }
}
