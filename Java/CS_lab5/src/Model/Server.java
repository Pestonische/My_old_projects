package Model;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;
import java.util.logging.Logger;

public class Server {

    public static final int PORT = 8080;
    public static LinkedList<ServerFunctions> serverList = new LinkedList<>();
    static Logger logger = Logger.getLogger(Server.class.getName());

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(PORT);
        logger.info("Server listened on port 8080");
        try {
            while (true) {
                Socket socket = server.accept();
                try {
                    serverList.add(new ServerFunctions(socket));
                } catch (IOException e) {
                    socket.close();
                }
            }
        } finally {
            server.close();
        }
    }
}