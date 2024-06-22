package network;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        ServerSocket ss = null;
        try {
            ss = new ServerSocket(1000);
            System.out.println("Server start");

            while (true) {
                Socket sc = ss.accept();
                System.out.println(sc.getInetAddress() + " Client 접속");

                Client_Thread ct = new Client_Thread(sc);
                ct.start();
            }
        } catch (Exception e) {
            System.out.println("서버 종료");
            e.printStackTrace();
        } finally {
            try {
                ss.close();
            } catch (IOException e) {

            }
        }
    }
}
