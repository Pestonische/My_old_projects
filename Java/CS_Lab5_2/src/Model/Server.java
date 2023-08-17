package Model;

import java.util.logging.Logger;

import java.io.File;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.*;

/**
 * Class represents Nio server
 */
public class Server {

    @SuppressWarnings("unused")
    public static void main(String[] args) throws IOException {

        final Logger logger = Logger.getLogger( Server.class.getName() );

        ArrayList<SocketChannel> clients = new ArrayList<>();
        Selector selector = Selector.open();
        ServerSocketChannel servSocket = ServerSocketChannel.open();
        InetSocketAddress address = new InetSocketAddress("localhost", 1111);
        servSocket.bind(address);
        servSocket.configureBlocking(false);
        int ops = servSocket.validOps();
        SelectionKey selectKy = servSocket.register(selector, ops, null);

        while (true) {
            selector.select();
            Set<SelectionKey> keys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = keys.iterator();

            while (iterator.hasNext()) {
                SelectionKey myKey = iterator.next();
                if (myKey.isAcceptable()) {
                    SocketChannel client = servSocket.accept();
                    client.configureBlocking(false);
                    client.register(selector, SelectionKey.OP_READ);
                    logger.info("Новое соединение: " + client.getLocalAddress() + "\n");
                    clients.add(client);
                }

                Scanner sc = new Scanner(new File("C:\\Users\\alexe\\Desktop\\web_rips\\lab5_2\\src\\index.txt"));
                while(sc.hasNext()) {
                    System.out.println(sc.nextLine());
                }
                System.out.println("Введите индекс пользователя");
                sc = new Scanner(System.in);
                int clientIndex = sc.nextInt();

                byte[] message = "Новое сообщение от сервера".getBytes();
                ByteBuffer buffer = ByteBuffer.wrap(message);
                clients.get(clientIndex).write(buffer);
                buffer.clear();
            }
        }
    }

}