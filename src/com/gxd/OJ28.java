package com.gxd;

/**
 * Created by gxd4297 on 2016/11/22.
 */
public class OJ28 {

    //naive
    public static int strStr(String haystack, String needle) {
        if (haystack == null || needle == null || needle.length() == 0) {
            return 0;
        }
        int i=0,j=0;
        for(;i<haystack.length()&&j<needle.length();) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            }else{
                i-=j-1;
                j=0;
            }
        }
        return j==needle.length()-1?i-j:-1;
    }

    //kmp
    public static void getNext(String pattern, int[] next) {
        int k,q;
        next[0] = 0;
        for(k=0,q=1;q<pattern.length();q++) {
            while (k > 0 && pattern.charAt(k) != pattern.charAt(q)) {
                k = next[k - 1];
            }
            if (pattern.charAt(k) == pattern.charAt(q)) {
                k++;
            }
            next[q] = k;
        }
    }

    public static int kmp(String templete, String pattern) {
        int[] next = new int[pattern.length()];
        getNext(pattern, next);
        int k,q;
        for(k=0,q=0;q<templete.length();q++) {
            while (k > 0 && pattern.charAt(k) != templete.charAt(q)) {
                k = next[k - 1];
            }
            if (pattern.charAt(k) == templete.charAt(q)) {
                k++;
            }
            if (k == pattern.length()) {
                return q-k+1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(OJ28.kmp("abcdabe", "abe"));
    }



}
