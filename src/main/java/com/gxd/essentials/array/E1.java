package com.gxd.essentials.array;

/**
 * Created by gxdgodgxd on 17/2/14.
 */

//Remove Duplicates from Sorted Array
public class E1 {

    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int len = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[len] != nums[i]) {
                nums[++len] = nums[i];
            }
        }
        return len + 1;
    }


    public static void main(String[] args) {
        E1 e1 = new E1();
        e1.removeDuplicates(new int[]{1, 1, 2});
    }

}
