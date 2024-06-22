package network;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(1000);
            System.out.println("Server start");

            while (true) {
                Socket sc = ss.accept();

                InputStream is = sc.getInputStream();
                BufferedReader br = new BufferedReader(new InputStreamReader(is));
                System.out.println(br.readLine());
            }
        } catch (Exception e) {
            System.out.println("서버 종료");
            e.printStackTrace();
        }
    }
}
