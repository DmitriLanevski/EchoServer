import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

/**
 * Created by lanev_000 on 3.03.2016.
 */
public class Client {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket(InetAddress.getLocalHost(), 1337);
        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
        DataInputStream dis = new DataInputStream(socket.getInputStream());
        BufferedReader bufIn = new BufferedReader(new InputStreamReader(System.in));
        String userInput;
        String echo;

        userInput = bufIn.readLine();
        dos.writeUTF(userInput);
        echo = dis.readUTF();
        System.out.println(echo);
        bufIn.close();
        dos.close();
        dis.close();
        socket.close();
    }
}
