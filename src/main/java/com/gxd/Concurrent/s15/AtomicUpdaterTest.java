package com.gxd.Concurrent.s15;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * Created by gxdgodgxd on 18/2/24.
 */
public class AtomicUpdaterTest {


    public static void main(String[] args) {
        File file = new File("cat1.txt");
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream(file));
            Cat cat = new Cat();
            oos.writeObject(cat);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
