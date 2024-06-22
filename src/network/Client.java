package network;

import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        try {
            Socket sc = new Socket("127.0.0.1", 1000);

            OutputStream os = sc.getOutputStream();
            PrintWriter pw = new PrintWriter(os, true);
            pw.println("메시지");
        } catch (Exception e) {
            System.out.println("클라이언트 종료");
            e.printStackTrace();
        }
    }
}
