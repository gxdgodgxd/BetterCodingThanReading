package com.gxd.essentials.array;

/**
 * Created by gxdgodgxd on 18/1/3.
 */
public class trap {

    public static int trap(int[] A) {
        int i = 0, j = A.length - 1, plank = 0, result = 0;
        while (i < j) {
            plank = Math.max(Math.min(A[i], A[j]), plank);
            result += A[i] < A[j] ? (plank - A[i++]) : (plank - A[j--]);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(trap(arr));
        System.out.println(trap2(arr));
    }

    public static int trap2(int[] A) {
        int result = 0;
        int len = A.length;
        int[] leftPeek = new int[len];
        int[] rightPeek = new int[len];

        for (int i = 1; i < len; i++) {
            leftPeek[i] = Math.max(leftPeek[i - 1], A[i - 1]);
        }
        for (int i = len - 2; i > 0; i--) {
            rightPeek[i] = Math.max(rightPeek[i + 1], A[i + 1]);
        }

        int tmp;
        for (int i = 1; i < len-1; i++) {
             tmp = Math.min(leftPeek[i], rightPeek[i])-A[i];
            result += tmp>0?tmp:0;

        }
        return result;
    }
}
