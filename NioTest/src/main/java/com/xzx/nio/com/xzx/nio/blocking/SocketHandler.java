package com.xzx.nio.com.xzx.nio.blocking;

import com.sun.istack.internal.NotNull;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class SocketHandler extends Thread {

    @NotNull
    SocketChannel socketChannel;

    public SocketHandler(SocketChannel socketChannel) {
        this.socketChannel = socketChannel;
    }

    @Override
    public void run() {
        try {
            final ByteBuffer buffer = ByteBuffer.allocate(1024);
            int num;
            while ((num = socketChannel.read(buffer)) > 0) { // 读取到数据
                buffer.flip();
                byte[] bytes = new byte[num];
                buffer.get(bytes);

                String msg = new String(bytes, "UTF-8");
                System.out.println("Server receive -> " + msg);
                ByteBuffer wb = ByteBuffer.wrap(("Server has received your message -> " + msg).getBytes());
                socketChannel.write(wb);
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
