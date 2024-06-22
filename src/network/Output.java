package network;

import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Output extends Thread {
    private Socket sc = null;
    private Scanner scan = new Scanner(System.in);

    public Output(Socket sc) {
        this.sc = sc;
    }

    public void run() {
        try {
            OutputStream os = sc.getOutputStream();
            PrintWriter pw = new PrintWriter(os, true);
            while (true) {
                pw.println(scan.next());
            }
        } catch (Exception e) {
            System.out.println("Output 종료");
            e.printStackTrace();
        }
    }
}
