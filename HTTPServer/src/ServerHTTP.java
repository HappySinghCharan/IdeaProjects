//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

import java.io.*;
import java.net.*;
import java.lang.Thread;

public class ServerHTTP extends Thread{
    public static ServerSocket serverSocket;
    public static Socket client;

    /*private static String guessContentType(String fileName) {
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
    private static HTTPRequest parse(Socket client) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(client.getInputStream()));

        HTTPRequest request=new HTTPRequest();

        String line="";
        int spcnt=0;
        String idf="";

        line=br.readLine();
        int i=0;
        while(i<line.length())
        {
            if(line.charAt(i)!=' ' && line.charAt(i)!='?')   idf += line.charAt(i);
            else{
                if(spcnt==0)  request.method=idf;
                else if(spcnt==1)   request.path = idf;
                else request.query=idf;
                idf="";
                spcnt++;
            }
            i++;
        }
        request.protocol=idf;
        return request;
    }
    private static void requestHandler(String path, Socket client) throws IOException {
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
    }*/

    private int getPort() {

        return (int) (Math.random() * 100) + 8000;
    }
    public void run()
    {
        try{
            int port = getPort();
            serverSocket=new ServerSocket(port);

            System.out.println("Server is running at port :"+port);

            client = serverSocket.accept();
            System.out.println("Client is connected successfully at" + client.getInetAddress());

            HTTPRequest req = HTTPRequestParser.parse(client);
            String path = req.getPath();
            HTTPResponse.requestHandler(path, client);

            System.out.println(req.getMethod());
            System.out.println(req.getPath());
            System.out.println(req.getQuery());
            System.out.println(req.getProtocol());
        }
        catch(IOException e)
        {
            System.out.println(e);
        }
    }
    public static void main(String[] args) throws IOException
    {

        ServerHTTP t1=new ServerHTTP();
        t1.start();
        


//        serverSocket=new ServerSocket(8001);
//        System.out.println("Server is running...");
//        client=serverSocket.accept();
//        System.out.println("Client is connected successfully at"+client.getInetAddress());



      /*  HTTPRequest req=HTTPRequestParser.parse(client);
        String path=req.getPath();
        HTTPResponse.requestHandler(path,client);*/

//        System.out.println(req.getMethod());
//        System.out.println(req.getPath());
//        System.out.println(req.getQuery());
//        System.out.println(req.getProtocol());

    }
}
