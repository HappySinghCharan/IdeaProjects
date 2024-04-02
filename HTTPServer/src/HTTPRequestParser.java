import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
public class HTTPRequestParser {
    public static HTTPRequest parse(Socket client) throws IOException
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

}
