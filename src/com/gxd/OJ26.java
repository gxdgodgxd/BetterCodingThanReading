package com.gxd;

/**
 * Created by gxd4297 on 2016/11/3.
 */
public class OJ26 {

    public void foo(){
        System.out.println(26);
    }

    public static int removeDuplicates(int[] nums) {
        int len = 0;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i]!=nums[i-1]){
                nums[++len] = nums[i];
            }
        }
        return len+1;
    }

    public static void main(String[] args) {
        OJ26.removeDuplicates(new int[]{1, 1,1,2, 2,3,4,5});
    }
}
