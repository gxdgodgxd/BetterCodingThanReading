package com.gxd.Concurrent.s7;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by gxdgodgxd on 18/1/22.
 */
public class ShutdownHookTest {
    //// 18/1/22 验证文件不关会怎么样 并尝试shutdownhook来关闭

    private static File file;

    public static void main(String[] args) {
        Runtime.getRuntime().addShutdownHook(new Thread(){
            @Override
            public void run() {
                System.out.println("shut down hook running");
            }
        });
        ShutdownHookTest s = new ShutdownHookTest();
//        s.file = new File("newFile");
        s.file = new File("newFile");
        try {
            FileWriter fw = new FileWriter(s.file,true);
            fw.append("abc");
            fw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
