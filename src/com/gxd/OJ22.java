package com.gxd;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gxdgodgxd on 16/8/12.
 */

public class OJ22 {

    public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        helper(res, n, n, "");
        return res;
    }

    static void helper(List<String> res, int left, int right, String str) {
        if (right == 0) {
            res.add(str);
            return;
        }
        if (left>0) {
            helper(res, left - 1, right, str + "(");
        }
        if (right>left) {
            helper(res, left, right - 1, str + ")");
        }
    }

    public static void main(String[] args) {
        List<String> res = OJ22.generateParenthesis(3);
        for (String re : res) {
            System.out.println(re);
        }
    }
}
