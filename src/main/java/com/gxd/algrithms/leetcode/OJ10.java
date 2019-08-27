package com.gxd.algrithms.leetcode;


/**
 *@Auther gxd4297
 *@Date:  2016年3月18日下午3:19:50
 */

public class OJ10
{
    public static boolean isMatch(String s, String p){
        if(s == null || p == null){
            return false;
        }
        if(p.isEmpty()){
            return s.isEmpty();
        }
        else{
            char p1,p2,s1;
            p1 = p.charAt(0);
            if(s.isEmpty()){
                if(canBeNull(p)) return true;
                else return false;
            }else{
                s1 = s.charAt(0);
                if(s1==p1||p1=='.'){
                    if(p.length()==1){
                        return isMatch(s.substring(1,s.length()), "");
                    }else{
                        p2 = p.charAt(1); 
                        if(p2=='*'){
                            p = p;
                        }else{
                            p = p.substring(1,p.length());
                        }
                        return isMatch(s.substring(1, s.length()), p);
                    }
                }else{
                    return isMatch(s, nextP(p));
                }
            }
        }
    }
    
    public static boolean canBeNull(String p){
        boolean flag = true;
        if(p.length()==1){
            flag =  false;
        }
        for(int i=1;i<p.length();i+=2){
            if(p.charAt(i)!='*'){
                flag = false;
            }
        }
        return flag;
    }
    
    public static String nextP(String p){
        if(p.length()==1){
            return "";
        }
        else if(p.charAt(1)=='*'){
            return p.substring(2,p.length());
        }else{
            return "";
        }
    }
    
    public static void main(String[] args)
    {
        System.out.println(OJ10.isMatch("aa", "SameTimeEnd"));
        System.out.println(OJ10.isMatch("aa", "aa"));
        System.out.println(OJ10.isMatch("aaa", "aa"));
        System.out.println(OJ10.isMatch("aa", "SameTimeEnd*"));
        System.out.println(OJ10.isMatch("aa", ".*"));
        System.out.println(OJ10.isMatch("ab", ".*"));
        System.out.println(OJ10.isMatch("aab", "c*SameTimeEnd*b"));
        System.out.println(OJ10.isMatch("SameTimeEnd", "ab"));
    }
}
