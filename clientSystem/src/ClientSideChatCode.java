import java.io.*;
import java.net.*;

public class ClientSideChatCode {
    public static void main(String[] args)throws Exception
    {
        Socket s=new Socket("192.168.0.204",8080);

        DataInputStream din=new DataInputStream(s.getInputStream());
        DataOutputStream dout=new DataOutputStream(s.getOutputStream());
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        String str="",str2="";
        while(!str.equals("stop"))
        {
            System.out.println("You : ");
            str=br.readLine();
            dout.writeUTF(str);
            dout.flush();
            str2=din.readUTF();
            System.out.println("Server Says : "+str2);

        }
        dout.close();
        s.close();
    }
}
