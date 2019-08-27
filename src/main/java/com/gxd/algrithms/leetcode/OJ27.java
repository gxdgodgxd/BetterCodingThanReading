package com.gxd.algrithms.leetcode;

/**
 * Created by gxd4297 on 2016/11/15.
 */

public class OJ27 {

    public static int removeElement(int[] nums, int val) {
        int len = 0;
        for(int i=0;i<nums.length;i++) {
            if (nums[i] != val) {
                nums[len++] = nums[i];
            }
        }
        return len;
    }

    public static void main(String[] args) {
        System.out.println(OJ27.removeElement(new int[]{3, 2, 2, 3}, 3));
    }
}
