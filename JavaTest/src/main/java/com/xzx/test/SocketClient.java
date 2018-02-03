package com.xzx.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class SocketClient {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        PrintWriter pw = null;
        Socket socket = null;
        BufferedReader br = null;
        try {
            socket = new Socket("localhost", 8864);
            pw = new PrintWriter(socket.getOutputStream(), true); // 往服务端写数据
            br = new BufferedReader(new InputStreamReader(socket.getInputStream())); // 读取服务端数据
            pw.println("Hi Server");
            while (true) {
                String str = br.readLine();
                if (str == null) {
                    break;
                }
                System.out.println("Client Accept:" + str);
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
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }

}
