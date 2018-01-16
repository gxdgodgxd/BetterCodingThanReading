package com.gxd.leetcode;

import java.util.HashMap;

public class OJ1 {
	public static int[] twoSum(int[] nums, int target) {
        Integer n;
        int[] a = new int[2];
        HashMap<Integer,Integer> hash = new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++)
        {
              n = hash.get(nums[i]);
              if(n==null) hash.put(nums[i],i);
              n = hash.get(target-nums[i]);
              if(n!=null && n<i){
                  a[0] = n+1;
                  a[1] = i+1;
              }
        }
        return a;
    }
	
	public static void main(String[] args) {
		int[] nums = new int[]{3,2,4};
		int[] b = OJ1.twoSum(nums, 6);
		System.out.println(b[0]);
		System.out.println(b[1]);
	}
}