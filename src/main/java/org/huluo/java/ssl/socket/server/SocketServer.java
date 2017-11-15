package org.huluo.java.ssl.socket.server;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {

    private static ServerSocket serverSocket;

    static {
        try {
            serverSocket = new ServerSocket(8080);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {

        while (true) {
            Socket socket = serverSocket.accept();
            String string = "返回的数据";
            PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
            printWriter.println(string);
            printWriter.close();
            socket.close();
            System.out.println("继续往下执行");
        }
    }
}
