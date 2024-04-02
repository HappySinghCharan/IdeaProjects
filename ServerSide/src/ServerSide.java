
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.net.*;
import java.io.*;
class MyServer{
    public static void main(String args[])throws Exception{
        ServerSocket ss=new ServerSocket(3333);
        //establishing the connection between server and client.
        Socket s=ss.accept();
        //taking input from the socket
        DataInputStream din=new DataInputStream(s.getInputStream());
        //for sending output to Output Stream
        DataOutputStream dout=new DataOutputStream(s.getOutputStream());
        //reading the input

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        String str="",str2="";
        while(!str.equals("stop")){
            //reading input in representation of UTF format(unicode transformation format).
            str=din.readUTF();
            System.out.println("client says: "+str);
            System.out.print("You : ");

            str2=br.readLine();

            //writing the input entered by client to an output stream in a portable way.
            dout.writeUTF(str2);
            dout.flush();
        }
        din.close();
        s.close();
        ss.close();
    }}