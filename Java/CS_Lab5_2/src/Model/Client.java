package Model;

import java.util.Scanner;
import java.util.logging.Logger;

import java.io.*;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * Class represents nio client
 */
public class Client {

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        final Logger logger = Logger.getLogger( Client.class.getName() );

        InetSocketAddress address = new InetSocketAddress("localhost", 1111);
        SocketChannel client = SocketChannel.open(address);

        File file = new File("C:\\Users\\alexe\\Desktop\\web_rips\\lab5_2\\src\\index.txt");
        BufferedReader reader = new BufferedReader(new FileReader(file));


        FileWriter fw = new FileWriter(file, true);
        BufferedWriter writer = new BufferedWriter(fw);

        String str = reader.readLine();
        int i = 0;
        if(str != null) {
            while (str != null) {
                i = Integer.parseInt(str);
                str = reader.readLine();
            }
            writer.newLine();
            i++;
        }
        writer.write(String.valueOf(i));

        writer.close();
        reader.close();
        fw.close();

        logger.info("Подключение к серверу по порту 1111...");
        String name;
        System.out.println("Введите ваше имя:");
        name = sc.next();

        while (true) {
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            client.read(buffer);
            String data = new String(buffer.array()).trim();
            if (data.length() > 0) {
                logger.info(name + " получил сообщение: " + data);
                if (data.equalsIgnoreCase("stop")) {
                    client.close();
                    logger.info(name + "отключение...");
                }
            }
        }
    }
}