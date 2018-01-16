package com.gxd.Concurrent.s3;

import java.util.ArrayList;

/**
 * Created by gxdgodgxd on 17/7/18.
 */
public class UnsafeStates {

    private String[] status = new String[]{"a","b"};
    private ArrayList<String> list = new ArrayList<>();

    public UnsafeStates() {
        list.add("1");
        list.add("2");
        list.add("3");
    }

    public String[] getStatus() {
        return status;
    }

    public ArrayList<String> getList() {
        return list;
    }

    public static void main(String[] args) {
        UnsafeStates us = new UnsafeStates();
//        System.out.println(us.getList().size());
//        us.getList().add("4");
//        System.out.println(us.getList().size());
        for (String s : us.getStatus()) {
            System.out.println(s);
        }
        us.getStatus()[1] = "c";
        for (String s : us.getStatus()) {
            System.out.println(s);
        }



    }
}
