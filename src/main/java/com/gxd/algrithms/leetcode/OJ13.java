package com.gxd.algrithms.leetcode;

public class OJ13 {
    public static int romanToInt(String s){
        String romans = "IVXLCDM";
        int[] values = new int[]{1,5,10,50,100,500,1000};
        int index =0;
        int carry = 0;
        int pre = Integer.MAX_VALUE;
        int val = 0;
        int res = 0;
        for(int i=0;i<s.length();i++){
            index = romans.indexOf(s.charAt(i));
            val = values[index];
            if(pre>=val){
            	res += carry;
            	carry = val;
            }else if(pre==val){
            	carry += val;
            }else{
            	carry = -carry + val;
            }
            pre = val;
        }
        return res+carry;
    }
    
    public static void main(String[] args) {
		System.out.println(OJ13.romanToInt("XCV"));
	}
}
