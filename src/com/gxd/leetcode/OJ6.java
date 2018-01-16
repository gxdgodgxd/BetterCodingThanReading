package com.gxd.leetcode;


/**
 *@Auther gxd4297
 *@Date:  2016年2月19日下午2:15:13
 */

public class OJ6
{
    public static String convert(String s,int numRows){
        if(s.length()<numRows||numRows==1)
            return s;
        StringBuilder sb = new StringBuilder();
        char[] charArray = s.toCharArray();
        
        for(int i=0;i<numRows;i++){
            for(int j=0;j<charArray.length/numRows;j++){
                if((j*(2*numRows-2)+i)<s.length())
                    sb.append(charArray[j*(2*numRows-2)+i]);
                if(i!=0&&i!=numRows-1&&((j+1)*(2*numRows-2)-i)<s.length())
                    sb.append(charArray[(j+1)*(2*numRows-2)-i]);
            }
        }
        
        return sb.toString();
    }
    
    public static String convert2(String s,int numRows){
        if(s.length()<numRows||numRows==1)
            return s;
        StringBuilder sb = new StringBuilder();
        char[] charArray = s.toCharArray();
        
        int rgap = 0;
        int lgap = numRows*2-2;
        for(int i=0;i<numRows;i++){
            int j=i;
            while(j<charArray.length){
                if(j==i)
                    sb.append(charArray[j]);
                if(lgap!=0 && j+lgap<=charArray.length-1)
                    sb.append(charArray[j+lgap]);
                if(rgap!=0 && j+lgap+rgap<=charArray.length-1)
                    sb.append(charArray[j+lgap+rgap]);
                j+=rgap+lgap;
            }
            lgap = lgap -2;
            rgap = rgap +2;
        }
        return sb.toString();
    }
    
    public static void main(String[] args)
    {
//        String s = "PAYPALISHIRING";
        String s = "123456789abcdefg";
        System.out.println(OJ6.convert2(s, 4));
    }
}
