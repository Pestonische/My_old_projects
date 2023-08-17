package server;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;


import java.io.*;
import java.util.Scanner;
import java.util.logging.Logger;

/**
 * Server handler
 */
public class ServerHandler extends SimpleChannelInboundHandler<String> {

    private static final ChannelGroup channels = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);
    Logger logger = Logger.getLogger(ServerHandler.class.getName());

    public ServerHandler() {
        new ReadMsg().start();
    }

    /**
     * Method for dealing with just joined client
     * @param ctx context
     * @throws Exception ex
     */
    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        File file = new File("C:\\Users\\alexe\\Desktop\\web_rips\\Lab5_3\\src\\main\\java\\index.txt");
        BufferedReader reader = new BufferedReader(new FileReader(file));

        String st;
        FileWriter fr = new FileWriter(file, true);
        BufferedWriter writer = new BufferedWriter(fr);
        String str = reader.readLine();
        int i = 0;
        if(str != null) {
            while (str != null) {
                i = Integer.parseInt(str);
                System.out.println(i);
                str = reader.readLine();
            }
            writer.newLine();
            i++;
            System.out.println(i);

        }
        writer.write(String.valueOf(i));

        System.out.println("Выберите пользователя");
        writer.close();
        reader.close();
        fr.close();

        channels.add(ctx.channel());
    }


    /**
     * Method for dealing with just came msg
     * @param s msg
     * @throws Exception ex
     */
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, String s) throws Exception {
        logger.info(s);
        Channel incoming = channelHandlerContext.channel();
        for (Channel channel : channels) {
            if (channel != incoming) {
                channel.write("[" + incoming.remoteAddress() + "]" + s + "\n");
            }
        }
    }



    private class ReadMsg extends Thread {
        @Override
        public void run() {
            while (true) {
                Scanner sc = new Scanner(System.in);
                int clientIndex = sc.nextInt();
                int i = 0;
                System.out.println("Клиент номер " + clientIndex);

                for (Channel channel : channels) {
                    if (i == clientIndex) {
                        channel.write(  " Новое сообщение с сервера!\n");
                        channel.flush();
                    }
                    i++;
                }
            }
        }
    }
}
