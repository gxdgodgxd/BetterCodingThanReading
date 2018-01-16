package com.gxd.leetcode;

/**
 * Created by gxd4297 on 2016/12/5.
 */
public class OJ29 {
    public static int divide(int dividend, int divisor) {
        if (dividend==0) {
            return 0;
        }
        if (divisor==0) {
            return Integer.MAX_VALUE;
        }
        boolean positive = true;
        if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0)) {
            positive = false;
        }
        dividend = dividend>0?dividend:-dividend;
        divisor = divisor>0?divisor:-divisor;
        int quatient;
        for (quatient = 0; dividend >= divisor;) {
            dividend -= divisor;
            quatient++;
        }
        return positive==true?quatient:-quatient;
    }

    public static void main(String[] args) {
        System.out.println(OJ29.divide(200, 2));
    }
}
