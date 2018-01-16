package com.gxd.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by gxdgodgxd on 16/7/7.
 */
public class OJ18 {

    public static void main(String[] args) {
        int[] nums = new int[]{0, 0, 0, 0};
        System.out.println(fourSum(nums, 0));
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ret = new ArrayList<>();
        if (nums.length < 4) {
            return ret;
        }
        Arrays.sort(nums);

        int low, high, sum;
        int len = nums.length;
        for (int i = 0; i < len - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            //to large
            if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) break;
            //to small
            if (nums[i] + nums[len - 1] + nums[len - 2] + nums[len - 3] < target) continue;
            for (int j = i + 1; j < len - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                //to large
                if (nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) break;
                //to small
                if (nums[i] + nums[j] + nums[len - 1] + nums[len - 2] < target) continue;
                low = j + 1;
                high = len - 1;
                while (low < high) {
                    sum = nums[i] + nums[j] + nums[low] + nums[high];
                    if (sum == target) {
                        ret.add(Arrays.asList(nums[i], nums[j], nums[low], nums[high]));
                        while (++low < high && nums[low] == nums[low - 1]) ;
                        while (low < --high && nums[high] == nums[high + 1]) ;
                    } else if (sum > target) {
                        while (low < --high && nums[high] == nums[high + 1]) ;
                    } else if (sum < target) {
                        while (++low < high && nums[low] == nums[low - 1]) ;
                    }
                }
            }
        }
        return ret;
    }

}
