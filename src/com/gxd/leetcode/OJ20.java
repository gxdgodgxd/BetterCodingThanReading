package com.gxd.leetcode;

import java.util.Stack;

/**
 * Created by gxdgodgxd on 16/8/12.
 */
public class OJ20 {
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && isMatch(stack.peek(),c)) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        if (stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isMatch(char a, char b) {
        if (a == '(' && b == ')') {
            return true;
        }
        if (a == '[' && b == ']') {
            return true;
        }
        if (a == '{' && b == '}') {
            return true;
        }
        return false;
    }


    public static void main(String[] args) {
        String s = "(){}[]";
        System.out.println(OJ20.isValid(s));

    }
}
