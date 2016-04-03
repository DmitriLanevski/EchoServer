import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by lanev_000 on 3.03.2016.
 */
public class Server {
    public static void main(String[] args) throws Exception{
        ServerSocket serverSocket = new ServerSocket(1337);

        while(true){
            Socket incoming = serverSocket.accept();
            DataInputStream dis = new DataInputStream(incoming.getInputStream());
            DataOutputStream dos = new DataOutputStream(incoming.getOutputStream());
            String buf = dis.readUTF();
            dos.writeUTF(buf);
            dis.close();
            dos.close();
            incoming.close();
            if (buf.equals("Close")){
                break;
            }
        }

        serverSocket.close();
    }
}
