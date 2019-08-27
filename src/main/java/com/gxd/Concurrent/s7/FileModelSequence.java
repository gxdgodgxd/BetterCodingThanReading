package com.gxd.Concurrent.s7;

import java.io.*;

/**
 * Created by gxdgodgxd on 18/3/9.
 */
public class FileModelSequence implements Sequence{

    public int sequence;

    public void init() {
        File file = new File("sequence");
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(file);
            byte[] seq = new byte[fis.available()];
            fis.read(seq);
            fis.close();

            this.sequence = Integer.parseInt(new String(seq, "utf-8"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int getSequence() {
        return sequence++;
    }

    public void stop() {
        File file = new File("sequence");
        try {
            FileOutputStream fos = new FileOutputStream(file);
            fos.write(String.valueOf(this.sequence).getBytes("utf-8"));
            fos.close();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
//        File file = new File("sequence");
//        try {
//            FileOutputStream fos = new FileOutputStream(file);
//            fos.write(String.valueOf(1).getBytes("utf-8"));
//            fos.close();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

    }
}
