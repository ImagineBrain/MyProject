package com.xzx.nio.com.xzx.nio.blocking;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;


public class BlockingNioServer {

    public static void main(String[] args) {
        try {
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.socket().bind(new InetSocketAddress(8080));

            while (true) {
                // 阻塞等待新连接
                SocketChannel socketChannel = serverSocketChannel.accept();
                // 启动新线程处理
                SocketHandler socketHandler = new SocketHandler(socketChannel);
                socketHandler.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
