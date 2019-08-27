package com.gxd.test;

/**
 * Created by gxdgodgxd on 17/6/30.
 */
public class string {

    public static void main(String[] args) {
        String a1 = "SameTimeEnd";
        String a2 = "SameTimeEnd";
        System.out.println(a1 == a2);
        String a3 = new String("SameTimeEnd");
        String a4 = new String("SameTimeEnd");
        System.out.println(a1 == a3);
        System.out.println(a4 == a3);
        a3 = a3.intern();
        System.out.println(a1 == a3);

        System.out.println("---");

        String b11 = "b";
        String b12 = "1";
        String b1 = b11 + b12;
        String b2 = "b1";
        String b3 = "b" + "1";
        final String b31 = "b";
        String b4 = b31 + "1";
        System.out.println(b1 == b2);
        System.out.println(b1.intern() == b2);
        System.out.println(b2 == b3);
        System.out.println(b3 == b4);
        String b5 = new String(b3);
        System.out.println(b3 == b5);
    }

}
