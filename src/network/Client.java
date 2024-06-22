package network;

import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        try {
            Socket sc = new Socket("127.0.0.1", 1000);

            Output om = new Output(sc);
            om.start();
            Input im = new Input(sc);
            im.start();

        } catch (Exception e) {
            System.out.println("클라이언트 종료");
            e.printStackTrace();
        }
    }
}
