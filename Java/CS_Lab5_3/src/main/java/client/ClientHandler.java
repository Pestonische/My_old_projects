package client;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.logging.Logger;

/**
 * client handler class
 */
public class ClientHandler extends SimpleChannelInboundHandler<String> {
    Logger logger = Logger.getLogger(ClientHandler.class.getName());

    /**
     * method for dealing with the received message
     * @param s message
     * @throws Exception ex
     */

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, String s) throws Exception {
        logger.info(s);
    }
}
