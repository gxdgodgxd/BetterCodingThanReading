package com.gxd.leetcode;


/**
 *@Auther gxd4297
 *@Date:  2016年3月11日下午3:00:08
 */

public class OJ8
{
    public static int atoi(String s){
        if(s.isEmpty())
            return 0;
        int i=0,ans=0,sign=1,len=s.length();
        if(s.charAt(i)=='+'||s.charAt(i)=='-')
            sign = s.charAt(i++)=='+'?1:-1;
        for(;i<len;i++){
            int tmp = s.charAt(i)-'0';
            if(tmp<0||tmp>9)
                break;
            if(ans>Integer.MAX_VALUE/10 || (ans==Integer.MAX_VALUE/10&&tmp>Integer.MAX_VALUE%10))
                return sign==1?Integer.MAX_VALUE:Integer.MIN_VALUE;
            else ans = ans *10 + tmp;
        }
        return sign*ans;
    }
    
    public static void main(String[] args)
    {
        System.out.println(OJ8.atoi("-2147483650"));
    }
}
