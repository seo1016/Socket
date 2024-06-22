package network;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class Input extends Thread {
    private Socket sc = null;

    public Input(Socket sc) {
        this.sc = sc;
    }

    public void run() {
        try {
            InputStream is = sc.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            while (true) {
                System.out.println(br.readLine());
            }
        } catch (Exception e) {
            System.out.println("Input 종료");
            e.printStackTrace();
        }
    }
}
