import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;



public class Server {
    public static void main(String[] args) {
        Socket socket = null ;
        try (ServerSocket serverSocket = new ServerSocket( 8283 )) {
            System.out.println( "Сервер запущен, ожидаем подключения..." );
            socket = serverSocket.accept();
            System.out.println( "Клиент подключился" );
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            while ( true ) {
                String clientMessage = in.readUTF();
                System.out.println(clientMessage);
                if (clientMessage.equalsIgnoreCase( "/end" )) {
                    closeConnection(socket, in, out);
                    break ;
                }
                out.writeUTF( "Эхо: " + clientMessage);
            }
        } catch (IOException ignored) {
        }

    }
    private static void closeConnection(Socket s, DataInputStream in, DataOutputStream out) {

        try {
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            s.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
