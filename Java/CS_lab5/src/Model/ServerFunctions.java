package Model;


import java.io.*;
import java.net.Socket;
import java.util.Scanner;

class ServerFunctions extends Thread {
    private Socket socket;

    private BufferedReader reader;
    private BufferedWriter writer;

    public ServerFunctions(Socket socket) throws IOException {
        this.socket = socket;
        reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        start();
    }

    @Override
    public void run() {
        String word;
        try {
            word = reader.readLine();
            writer.write(word + "\n");
            writer.flush();
            while (true) {
                Scanner sc = new Scanner(new File("C:\\Users\\alexe\\Desktop\\web_rips\\lab5\\src\\index.txt"));
                while(sc.hasNext()) {
                    System.out.println(sc.nextLine());
                }
                System.out.println("Выберити индекс пользователя");
                sc = new Scanner(System.in);
                int clientIndex = sc.nextInt();
                Server.serverList.get(clientIndex).send("Новое сообщение с сервера!");
            }

        } catch (IOException e) {
            this.downService();
        }
    }

    private void send(String msg) {
        try {
            writer.write(msg + "\n");
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
                for (ServerFunctions vr : Server.serverList) {
                    if (vr.equals(this)) vr.interrupt();
                    Server.serverList.remove(this);
                }
            }
        } catch (IOException e) {
        }
    }
}
