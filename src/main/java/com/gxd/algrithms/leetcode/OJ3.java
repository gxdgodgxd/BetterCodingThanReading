package com.gxd.algrithms.leetcode;

import java.util.HashMap;
import java.util.HashSet;


/**
 *@Auther gxd4297
 *@Date:  2016年2月1日上午9:33:39
 */

public class OJ3
{
    //我的思路更顺畅
    public static int lengthOfLogestSubstring(String s){
        HashMap<Character,Integer> h = new HashMap<Character, Integer>();
        int left=0,max=0;
        char[] charArray = s.toCharArray();
        for (int i=0;i<charArray.length;i++)
        {
            if(!h.containsKey(charArray[i])){
                h.put(charArray[i],i);
                max = i-left+1>max?i-left+1:max;
            }else{
                left = h.get(charArray[i])+1;
                h.put(charArray[i], i);
                max = i-left+1>max?i-left+1:max;
            }
        }
        return max;
    }
    
    public static int lengthOfLogestSubstringS(String s){
        HashSet<Character> h = new HashSet<Character>();
        int left=0,max=0;
        char[] charArray = s.toCharArray();
        for (int i=0;i<charArray.length;i++)
        {
            if(!h.contains(charArray[i])){
                h.add(charArray[i]);
            }else{
                max = i - left>max?i-left:max;
                while(charArray[left]!=charArray[i]){
                    h.remove(charArray[left++]);
                }
                left++;
            }
        }
        return (max-charArray.length+left>0?max:charArray.length-left);
    }
    
    public static int lengthOfLogestSubstringByArray(String s){
        int[] locs = new int[256];
        for(int i=0;i<256;i++){
            locs[i]=-1;
        }
        int idx = -1,max = 0;
        for(int i=0;i<s.length();i++){
            int curIndex = Integer.valueOf(s.charAt(i));
            if(locs[curIndex]>idx){
                idx = locs[curIndex];
            }
            if(i-idx > max){
                max = i-idx;
            }
            
            locs[curIndex] = i;
        }
        return max;
        
        
    }
    
    public static void main(String[] args)
    {
        String s= "abcbb";
        System.out.println(lengthOfLogestSubstring(s));
//        System.out.println(lengthOfLogestSubstringS(s));
//        System.out.println(lengthOfLogestSubstringByArray(s));
    }
}
