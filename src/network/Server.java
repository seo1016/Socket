package network;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(1000);
            System.out.println("Server start");
            Socket sc = ss.accept();

            Output om = new Output(sc);
            om.start();
            Input im = new Input(sc);
            im.start();

        } catch (Exception e) {
            System.out.println("서버 종료");
            e.printStackTrace();
        }
    }
}
