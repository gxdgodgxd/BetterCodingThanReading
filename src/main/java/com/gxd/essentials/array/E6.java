package com.gxd.essentials.array;

import java.util.Arrays;

/**
 * Created by gxdgodgxd on 17/2/14.
 */
public class E6 {

    public int threeSumClosest(int[] nums, int target) {
        int minGap = Integer.MAX_VALUE;
        Arrays.sort(nums);

        int result = 0, sum, gap;
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int j = i + 1;
            int k = nums.length - 1;

            while (j < k) {
                sum = nums[i] + nums[j] + nums[k];
                gap = Math.abs(target - sum);
                if (gap < minGap) {
                    minGap = gap;
                    result = sum;
                }
                if (sum < target) {
                    j++;
                } else
                    k++;
            }

        }
        return result;
    }
}
