package com.gxd;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by gxd4297 on 2016/11/15.
 */
public class ReadServer {

//    public ReadServer() {
//        try {
//            ServerSocket ss = new ServerSocket(18888);
//            System.out.println("ss listening");
//            Socket accept = ss.accept();
//            System.out.println("ss acceptted");
//            InputStream in = accept.getInputStream();
//            byte[] buf = new byte[50960];
//            int readed = 0;
//            while (true) {
//                if (in.available() > 0) {
//                    readed = in.read(buf);
//                    System.out.println(readed);
//                    System.out.println("---");
//                    System.out.println(new String(buf));
//                    System.out.println("---");
//                }
//                else{
//                    try {
//                        Thread.sleep(200);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

    public ReadServer() {
        try {
            ServerSocket ss = new ServerSocket(18888);
            System.out.println("ss listening");
            Socket accept = ss.accept();
            System.out.println("ss acceptted");
            InputStream in = accept.getInputStream();
            BufferedInputStream bis = new BufferedInputStream(in);
            byte[] buf = new byte[50960];
            int readed = 0;
            while (true) {
                if (bis.available() > 0) {
                    readed = bis.read(buf);
                    System.out.println(readed);
                    System.out.println("---");
                    System.out.println(new String(buf));
                    System.out.println("---");
                }
                else{
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ReadServer rs = new ReadServer();
    }
}
