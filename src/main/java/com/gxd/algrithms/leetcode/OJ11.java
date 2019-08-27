package com.gxd.algrithms.leetcode;

public class OJ11 {

    public static int maxArea(int[] height) {
        int size = height.length;
        int i = 0, j = size - 1;
        int max = 0, tmp;
        while (i < j) {
            tmp = (j - i) * (height[i] < height[j] ? height[i++] : height[j--]);
            max = Math.max(max, tmp);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] ints = new int[]{1, 2, 5, 8, 9};
        System.out.println(OJ11.maxArea(ints));
    }
}
