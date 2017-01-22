package com.gxd;

import java.util.Arrays;


/**
 *@Auther gxd4297
 *@Date:  2016年2月1日下午1:24:44
 */

public class OJ4
{
    public static double findKth(int[] a,int m,int[] b,int n,int k){
        if(m>n){
            findKth(b, n, a, m, k);
        }
        if(m == 0){
            return b[k-1];
        }
        if(k == 1){
            return Math.min(a[0], b[0]);
        }
        //divide and conquar
        int pa = Math.min(k/2, m);
        int pb = k - pa;
        if(a[pa-1]<b[pb-1]){
            a = Arrays.copyOfRange(a, 0+pa, a.length);
            return findKth(a, m-pa, b, n, k-pa);
        }
        else if(a[pa-1]>b[pb-1]){
            b = Arrays.copyOfRange(b, 0+pb, b.length);
            return findKth(a, m, b, n-pb, k-pb);
        }
        else{
            return a[pa-1];
        }
        
    }
    
    public static double findMedianSortedArrays(int[] num1,int[] num2){
        int total = num1.length + num2.length;
        if((total & 0x1) == 1){
            return OJ4.findKth(num1, num1.length, num2, num2.length, total/2+1);
        }
        else{
            return (OJ4.findKth(num1, num1.length, num2, num2.length, total/2)
                    + OJ4.findKth(num1, num1.length, num2, num2.length, total/2+1))/2;
        }
    }
    
    public static void main(String[] args)
    {
        int[] num1 = {1,2,8,9};
        int[] num2 = {3,4,6,7};
        double mid = OJ4.findMedianSortedArrays(num1, num2);
        System.out.println(mid);
    }
}
