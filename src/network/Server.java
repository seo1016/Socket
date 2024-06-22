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

            while (true) {
                InputStream is = sc.getInputStream();
                BufferedReader br = new BufferedReader(new InputStreamReader(is));
                String str = br.readLine();
                System.out.println(str);

                OutputStream os = sc.getOutputStream();
                PrintWriter pw = new PrintWriter(os, true);
                pw.println("[서버]" + str);
            }
        } catch (Exception e) {
            System.out.println("서버 종료");
            e.printStackTrace();
        }
    }
}
