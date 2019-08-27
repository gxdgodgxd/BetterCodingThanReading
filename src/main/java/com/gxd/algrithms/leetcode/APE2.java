package com.gxd.algrithms.leetcode;

/**
 * Created by gxdgodgxd on 16/8/22.
 */

//找出abbabcd中 abc 顺序/无序 出现的最短子串长度
public class APE2 {

    public static int getShortInOrder(String src,String tar,int si,int ti) {
        int len1 = src.length(),len2 = src.length();
        if (ti == tar.length()) {
            return 0;
        }
        if (si == src.length()) {
            return len2;
        }
        if (src.charAt(si)==tar.charAt(ti)) {
            len1 = getShortInOrder(src, tar, si + 1, ti + 1)+1;
        }
        if (ti == 0) {
            len2 = getShortInOrder(src, tar, si + 1, ti);
        } else {
            len2 = getShortInOrder(src, tar, si + 1, ti) + 1;
        }
        return Math.min(len1, len2);
    }

    public static int getShortNoOrder(String src, String tar) {
        char[] tars = tar.toCharArray();
        int[] counter = new int[tars.length];
        char[] srcs = src.toCharArray();
        int len = srcs.length;
        int i = 0, j = 0;
        while (i < src.length()) {
            if (AnyZero(counter)) {
                i++;
            }else {
                j++;
            }
        }
        return 0;
    }

    public static boolean AnyZero(int[] ints) {
        for (int anInt : ints) {
            if (anInt==0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(APE2.getShortInOrder("adbc", "abc", 0, 0));
    }


}
