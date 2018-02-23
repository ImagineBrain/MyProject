package com.xzx.nio.com.xzx.nio.blocking;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class NioClient {

    public static void main(String[] args) {
        try {
            SocketChannel socketChannel = SocketChannel.open();
            socketChannel.connect(new InetSocketAddress("localhost", 8080));

            ByteBuffer wb = ByteBuffer.wrap("Hello Server, I'm Client".getBytes());
            // 发送数据
            socketChannel.write(wb);
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            int num;
            // 读取返回数据
            while ((num = socketChannel.read(byteBuffer)) > 0) {
                byteBuffer.flip();
                byte[] bytes = new byte[num];
                byteBuffer.get(bytes);
                String result = new String(bytes, "UTF-8");
                System.out.println("Client receive -> " + result);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
