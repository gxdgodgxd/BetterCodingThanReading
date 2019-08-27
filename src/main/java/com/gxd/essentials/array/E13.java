package com.gxd.essentials.array;

/**
 * Created by gxdgodgxd on 17/2/16.
 */
public class E13 {

   public int trap(int[] A) {
        int i = 0, j = A.length - 1, result = 0, plank = 0;
        while (i <= j) {
            plank = plank < Math.min(A[i], A[j]) ? Math.min(A[i], A[j]) : plank;
            result = A[i] >= A[j] ? result + (plank - A[j--]) : result + (plank - A[i++]);
        }
        return result;
    }
}

