package Model;

import java.io.*;

public class Client {

    public static String ipAddr = "localhost";
    public static int port = 8080;

    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\alexe\\Desktop\\web_rips\\lab5\\src\\index.txt");
        FileReader fr = new FileReader(file);
        BufferedReader reader = new BufferedReader(fr);

        String st;
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
        fr.close();

        new ClientFunctions(ipAddr, port);
    }
}