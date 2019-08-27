package com.gxd.algrithms.leetcode;


/**
 *@Auther gxd4297
 *@Date:  2016年3月18日下午3:12:54
 */

public class OJ9
{
    public static boolean isPalindrome(int x){
        if(x<0) return false;
        int res = 0;
        while(x>res){
            res = res*10 + x%10;
            x/=10;
        }
        return (x==res || x==res/10);
    }
    
    public static void main(String[] args)
    {
        System.out.println(OJ9.isPalindrome(123321));
    }
}
