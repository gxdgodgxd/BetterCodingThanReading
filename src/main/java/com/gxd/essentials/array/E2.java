package com.gxd.essentials.array;

/**
 * Created by gxdgodgxd on 17/2/14.
 */
//Remove Duplicates from Sorted Array II
public class E2 {

    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2) {
            return nums.length;
        }
        int len = 2;
        for (int i = 2; i < nums.length; i++) {
            if (nums[len-2] != nums[i]) {
                nums[len++] = nums[i];
            }
        }
        return len;

    }

    public static void main(String[] args) {
        E2 e2 = new E2();
        e2.removeDuplicates(new int[]{1, 1, 1, 2, 2, 2, 3});
    }
}
