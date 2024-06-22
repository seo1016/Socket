package network;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Client_Thread extends Thread {
    private static List<Client_Thread> ClientList = Collections.synchronizedList(new ArrayList<Client_Thread>());
    private Socket sc = null;
    private Scanner scan = new Scanner(System.in);

    OutputStream os = null;
    PrintWriter pw = null;

    public Client_Thread(Socket sc) {
        this.sc = sc;
        ClientList.add(this);
        try {
            os = sc.getOutputStream();
            pw = new PrintWriter(os, true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendMessage(String msg) {
        pw.println(scan.next());
    }

    public void run() {
        try {
            InputStream is = sc.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            while (true) {
                String brmsg = br.readLine();
                for (Client_Thread c: ClientList) {
                    c.sendMessage(brmsg);
                }
            }
        } catch (Exception e) {
            System.out.println("연결 종료");
            e.printStackTrace();
            ClientList.remove(this);
        }
    }
}
