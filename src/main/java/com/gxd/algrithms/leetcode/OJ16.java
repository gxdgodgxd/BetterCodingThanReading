package com.gxd.algrithms.leetcode;

import java.util.Arrays;

public class OJ16 {

	public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int j,k,sum;
        int delta = Integer.MAX_VALUE;
        int result = target;
        for(int i=0;i<nums.length-2;i++){
        	if(nums[i]*3-target>=delta){
        		break;
        	}
        	j = i+1;
        	k = nums.length-1;
        	if(nums[i]+nums[k]+nums[k-1]<=target){
        	    delta = target - nums[i] - nums[k] - nums[k-1];
        	    result = target - delta;
        	    continue;
        	}
        	while(j<k){
        		sum = nums[j]+nums[k]+nums[i];
	        	if(target<sum){
	        		if(sum-target<delta){
	        			result = sum;
	        			delta = sum-target;
	        		}
	        		k--;
	        	}else if(target>sum){
	        		if(target-sum<delta){
	        			result = sum;
	        			delta = target-sum;
	        		}
	        		j++;
	        	}else{
	        		return target;
	        	}
        	}
        }
        return result;
    }
    
    public static void main(String[] args) {
		OJ16.threeSumClosest(new int[]{-3,-2,-5,3,-4}, -1);
	}
}
