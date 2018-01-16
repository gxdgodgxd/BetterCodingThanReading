package com.gxd.essentials.array;

/**
 * Created by gxdgodgxd on 17/2/14.
 */
public class E10 {

    public void nextPermutation(int[] nums) {
        int head = 0, i = 0;
        for (i = nums.length - 1; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                head = i - 1;
                break;
            }
        }
        if (i == 0) {
            reverse(nums, 0, nums.length - 1);
            return;
        }
        for (i = nums.length - 1; i > 0; i--) {
            if (nums[i] > nums[head]) {
                break;
            }
        }
        swap(nums, i, head);
        reverse(nums, head + 1, nums.length - 1);
    }

    public void swap(int[] nums, int a, int b) {
        int temp;
        temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public void reverse(int[] nums, int begin, int end) {
        while (begin < end) {
            swap(nums, begin++, end--);
        }
    }

    public static void main(String[] args) {
        E10 e10 = new E10();
        e10.nextPermutation(new int[]{1, 2, 3});
    }
}
