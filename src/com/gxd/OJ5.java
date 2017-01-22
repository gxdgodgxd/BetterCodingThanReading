package com.gxd;


/**
 *@Auther gxd4297
 *@Date:  2016年2月1日下午1:55:44
 */

public class OJ5
{
    public static String manacher(String s,char c){
        s = init(s,c);
        int[] rad = new int[s.length()];
        int i=1,j=0,k;
        int maxLen = 0,maxindex = 0;
        while(i<s.length()){
            while(i-j-1>=0 && i+j+1<=s.length()-1 && s.charAt(i-j-1)==s.charAt(i+j+1)){
                j++;
            }
            rad[i] = j;
            
            if(j>maxLen){
                maxLen = j;
                maxindex = i;
            }
            
            k=1;
            while(k<=rad[i] && rad[i-k]!=rad[i]-k){
                rad[i+k] = rad[i-k]<rad[i]-k?rad[i-k]:rad[i]-k;
                k++;
            }
            i = i + k;
            j = j-k>0?j-k:0;
        }
        return s.substring(maxindex-maxLen,maxindex+maxLen+1).replace("#", "");
    }
    
    public static String init(String s,char c){
        StringBuilder sb = new StringBuilder();
        for (char sc : s.toCharArray())
        {
            sb.append(c);
            sb.append(sc);
        }
        sb.append(c);
//        System.out.println(sb.toString());
        return sb.toString();
    }
    
    public static String longestPalindromicSubstring(String s){
        if(s.length()<1){
            return s;
        }
        String rtn = s.substring(0,1);
        String temp;
        for(int i=0;i<s.length();i++){
            temp = getPalindorme(s, i, i);
            if(temp.length()>rtn.length()){
                rtn = temp;
            }
            
            temp = getPalindorme(s, i, i+1);
            if(temp.length()>rtn.length()){
                rtn = temp;
            }
        }
        return rtn;
    }
    
    public static String getPalindorme(String s,int start,int end){
        while(start>=0 && end<s.length() && s.charAt(start)==s.charAt(end)){
            start--;
            end++;
        }
        return s.substring(start+1,end);
    }
    
    public static void main(String[] args)
    {
        String s = "abcbcdcbd";
        System.out.println(longestPalindromicSubstring(s));
        System.out.println(manacher(s,'#'));
    }
}
