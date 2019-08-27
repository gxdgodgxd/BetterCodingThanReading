package com.gxd.algrithms.leetcode;

import java.util.Date;

/**
 * Created by gxdgodgxd on 16/8/21.
 */

//求 heellloappe中顺序出现 helloape的排列组合数
public class APE1 {

    public static int getCombination(String str, String tar) {
        char[] tars = tar.toCharArray();
        char[] strs = str.toCharArray();
        int ret = 1;
        int tari,stri;
        int i = 0, j = 0;
        while (i < tars.length) {
            while (j<strs.length && strs[j] != tars[i]) {
                j++;
            }
            if (j == strs.length && i < tars.length) {
                return 0;
            }
            tari = 1;
            stri = 1;
            //same with next char
            while (i < tars.length - 1 && tars[i] == tars[i + 1]) {
                i++;
                tari++;
            }
            while (j < strs.length - 1 && strs[j] == strs[j + 1]) {
                j++;
                stri++;
            }
            for(int k=tari+1;k<=stri;k++) {
                ret *= k;
            }
            i++;
            j++;
        }

        return ret;
    }

    public static void main(String[] args) {
//        System.out.println(APE1.getCombination("heellloappe", "helloapea"));
        System.out.println(new Date().getTime());
        System.out.println(APE1.getCombinationDP("heeeeeelllllllloapppppbbpeeee", "helloape", 0, 0));
        System.out.println(new Date().getTime());
        System.out.println(APE1.getCombinationDP_noRecursive("heeeeeelllllllloapppppbbpeeee", "helloape" ));
        System.out.println(new Date().getTime());
    }

    //recursive dp
    public static int getCombinationDP(String src,String tar,int si,int ti) {
        if (ti==tar.length()) {
            return 1;
        }
        if (si==src.length()) {
            return 0;
        }
        int temp = 0;
        if (src.charAt(si) == tar.charAt(ti)) {
            temp = getCombinationDP(src, tar, si + 1, ti + 1);
        }
        return getCombinationDP(src, tar, si + 1, ti) + temp;
    }

    //non-recursive dp
    public static int getCombinationDP_noRecursive(String src, String tar) {
        int ls = src.length();
        int lt = tar.length();
        int[][] dp = new int[ls][lt];
        if (src.charAt(0) == tar.charAt(0)) {
            dp[0][0]=1;
        }else{
            dp[0][0]=0;
        }
        for (int i = 1; i < lt; i++) {
            dp[0][i]=0;
        }
        int temp;
        for (int i = 1; i < ls; i++) {
            for (int j = 0; j < lt; j++) {
                temp = 0;
                if (src.charAt(i)==tar.charAt(j)) {
                    temp = dp[i-1][j-1];
                }
                dp[i][j]=dp[i-1][j]+temp;
            }
        }
        return dp[ls-1][lt-1];
    }
}
