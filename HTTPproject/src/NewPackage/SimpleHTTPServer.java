package NewPackage;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Objects;

public class SimpleHTTPServer {
    public static void main(String[] args) throws IOException
    {
        ServerSocket server = new ServerSocket(9000);
        String person="";
        while(true){
            final Socket client=server.accept();
            BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
            PrintWriter writer = new PrintWriter(new OutputStreamWriter(client.getOutputStream()));
            while(true){
                String line=reader.readLine();
                System.out.println("Header :"+line);
                if(line.equals(""))
                {
                    break;
                }
                if(line.contains("GET"))
                {
                    int startIndex=line.indexOf("/");
                    int endIndex=line.indexOf(" HTTP");
                     person=line.substring(startIndex+1,endIndex);
                    System.out.println("Person name : "+person);
                }
            }
            String crlf = "\r\n";
            Employee employee = getEmployeeDetails(person);

            writer.print("HTTP/1.1 200 OK"+crlf);
            writer.print("Content-type: application/json"+crlf);
            writer.println("Content-Length:"+employee.toString().length()+crlf);
            writer.print(employee.toString());

            writer.flush();
            writer.close();
            reader.close();
            client.close();
        }
    }
    public static Employee getEmployeeDetails(String name){
        Employee laksh=new Employee(name,"acb@laksh.com","NewCompany");
        Employee happy=new Employee(name,"acb@happy.com","NewOneCompany");
        if(Objects.equals(name,"laksh"))
        {
            return laksh;
        }
        else if(Objects.equals(name,"happy")){
            return happy;
        }
        else{
            return new Employee();
        }

    }
}
