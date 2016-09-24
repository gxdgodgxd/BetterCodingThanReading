package com.gxd;

import java.io.UnsupportedEncodingException;

/**
 * Created by gxdgodgxd on 16/9/8.
 */
public class ByteTest {

    public static void main(String[] args) {
        byte[] bytes = new byte[256];
        for(int i=0;i<256;i++) {
            bytes[i] = ((byte) i);
        }
        String s = null;
        try {
            s = new String(bytes,"utf-8");
            byte[] bytes2 = s.getBytes("utf-8");
            System.out.println(bytes2);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
