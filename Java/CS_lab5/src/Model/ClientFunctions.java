package Model;


import java.io.*;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Logger;

class ClientFunctions {
    private Socket socket;
    private BufferedReader reader;
    private BufferedWriter writer;
    private Scanner sc;
    private String name;
    static Logger logger = Logger.getLogger(ClientFunctions.class.getName());

    public ClientFunctions(String addr, int port) {
        try {
            this.socket = new Socket(addr, port);
        } catch (IOException e) {
        }
        try {
            sc = new Scanner(System.in);
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            this.enteringName();
            new readMessage().start();
        } catch (IOException e) {
            ClientFunctions.this.downService();
        }
    }

    private void enteringName() {
        System.out.print("Введите имя: ");
        try {
            name = sc.next();
            writer.write("Привет, " + name + "!\n");
            writer.flush();
        } catch (IOException e) {
        }

    }

    private void downService() {
        try {
            if (!socket.isClosed()) {
                socket.close();
                reader.close();
                writer.close();
            }
        } catch (IOException e) {
        }
    }

    private class readMessage extends Thread {
        @Override
        public void run() {
            String str;
            try {
                while (true) {
                    str = reader.readLine();
                    if (str.equals("stop")) {
                        ClientFunctions.this.downService();
                        break;
                    }
                    logger.info(name + " получил сообщение: " + str);
                }
            } catch (IOException e) {
                ClientFunctions.this.downService();
            }
        }
    }

}
