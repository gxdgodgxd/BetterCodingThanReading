package com.gxd;

public class OJ14 {
	public static String longestCommonPrefix(String[] strs) {
		if(strs.length==0){
			return "";
		}
		String prefix = strs[0];
		for(String s : strs){
			prefix = getPrefix(prefix, s);
		}
		return prefix;
        
    }
	
	public static String getPrefix(String a,String b){
		if(a.length()==0||b.length()==0){
			return "";
		}
		int len = a.length()<b.length()?a.length():b.length();
		int i;
		for(i=0;i<len;i++){
			if(a.charAt(i)!=b.charAt(i)){
				break;
			}
		}
		return a.substring(0,i);
	}
}
