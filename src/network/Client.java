package network;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try {
            Socket sc = new Socket("127.0.0.1", 1000);

            OutputStream os = sc.getOutputStream();
            PrintWriter pw = new PrintWriter(os, true);

            Scanner scan = new Scanner(System.in);
            pw.println(scan.next());

            InputStream is = sc.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            System.out.println(br.readLine());
        } catch (Exception e) {
            System.out.println("클라이언트 종료");
            e.printStackTrace();
        }
    }
}
