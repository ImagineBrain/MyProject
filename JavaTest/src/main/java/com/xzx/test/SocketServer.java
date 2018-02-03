package com.xzx.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(8864);// port 8864
            Socket socket = serverSocket.accept();

            new Thread(() -> {
                PrintWriter pw = null;
                BufferedReader br = null;
                try {
                    br = new BufferedReader(new InputStreamReader(socket.getInputStream())); // 读取客户端数据
                    pw = new PrintWriter(socket.getOutputStream(), true); // 往客户端写数据
                    while (true) {
                        String str = br.readLine();
                        if (str == null) {
                            break;
                        }
                        System.out.println("Server Accept:" + str);
                        pw.println("Hi Client");
                    }
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } finally {
                    if (br != null) {
                        try {
                            br.close();
                        } catch (IOException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                    }
                    if (pw != null) {
                        pw.close();
                    }
                }
            }).start();
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        } finally {
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }

    }
}
