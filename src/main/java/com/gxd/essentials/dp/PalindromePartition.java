package com.gxd.essentials.dp;

/**
 * Created by gxdgodgxd on 18/5/11.
 */
public class PalindromePartition {

    public static int minCut(String s) {
        final int n = s.length();
        int[] f = new int[n];
        for (int i = 0; i < f.length; i++) {
            f[i] = Integer.MAX_VALUE;
        }
        f[n-1]=0;
        boolean[][] p = new boolean[n][n];
        //the worst case is cutting by each char
        for (int i = n-1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (s.charAt(i) == s.charAt(j) &&
                        (j - i < 2 || p[i + 1][j - 1])) {
                    p[i][j] = true;
                    if (j == n - 1) {
                        f[i] = 0;
                    }else{
                        f[i] = Math.min(f[i], f[j + 1] + 1);
                    }
                }
            }
        }
        return f[0];
    }

    public static void main(String[] args) {
        System.out.println(PalindromePartition.minCut("bb"));
    }

}
