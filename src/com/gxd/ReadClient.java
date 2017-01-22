package com.gxd;

import java.io.IOException;
import java.net.Socket;

/**
 * Created by gxd4297 on 2016/11/15.
 */
public class ReadClient {

    public ReadClient(){
        byte[] buf = new byte[50960];
        for (int i = 0; i < 50960; i++) {
            buf[i] = (byte)((i % 10) + 48);
        }
        System.out.println(new String(buf));
        try {
            Socket s = new Socket("127.0.0.1",18888);
            System.out.println("connect finished");

            s.getOutputStream().write(buf);
            s.getOutputStream().flush();
            s.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ReadClient rc = new ReadClient();
    }

}
