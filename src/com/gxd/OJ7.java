package com.gxd;


/**
 *@Auther gxd4297
 *@Date:  2016年2月19日下午3:50:50
 */

public class OJ7
{
    public static int reverse(int x){
        int res = 0;
        while(x!=0){
            if(res>=Integer.MAX_VALUE/10 || res<=Integer.MIN_VALUE/10){
                res = 0;
                break;
            }
            res = res*10 + x%10;
            x/=10;
        }
        
        return (int)res;
    }
    
    public static void main(String[] args)
    {
        System.out.println(OJ7.reverse(463847412));
//        System.out.println(OJ7.reverse(1000000003));
    }
}
