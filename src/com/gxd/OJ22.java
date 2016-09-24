package com.gxd;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gxdgodgxd on 16/8/12.
 */

public class OJ22 {
    public static List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        if (n==1) {
            list.add("()");
            return list;
        }
        for (String s : generateParenthesis(n - 1)) {
            list.add("(" + s + ")");
            if (!list.contains("()" + s)) {
                list.add("()" + s);
            }
            if (!list.contains(s+"()")) {
                list.add(s + "()");
            }
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(OJ22.generateParenthesis(4));
    }
}
