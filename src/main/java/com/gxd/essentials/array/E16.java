package com.gxd.essentials.array;

/**
 * Created by gxdgodgxd on 17/2/16.
 */
public class E16 {

    int climbStairs(int n) {
        int pre=0;
        int cur=1;
        int tmp;
        for (int i = 0; i < n; i++) {
            tmp = cur;
            cur += pre;
            pre = tmp;
        }
        return cur;

    }
}
