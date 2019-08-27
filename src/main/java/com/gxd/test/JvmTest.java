package com.gxd.test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gxdgodgxd on 17/7/5.
 */
public class JvmTest {

    public static void main(String[] args) {
        int i=0;
        String a = "123123123123131231312131";
        List<String> list = new ArrayList();
        while (true) {
            list.add((a + String.valueOf(i)).intern());
        }
    }
}
