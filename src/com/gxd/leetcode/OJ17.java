package com.gxd.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gxdgodgxd on 16/7/6.
 */

public class OJ17 {

    private static final char[][] lettersMap = new char[][]{{},{},{'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g','h','i'}, {'j','k','l'}, {'m', 'n','o'}, {'p','q','r','s'}, {'t','u','v'}, {'w','x','y','z'}};

    public static List<String> letterCombinations(String digits) {
        List<String> ret = new ArrayList<>();
        if(digits==null || digits.isEmpty()){
            return ret;
        }
        dfs(ret,digits,0,"");
        return ret;
    }

    public static void dfs(List<String> ret, String digits, int start, String tmp) {
        if(start < digits.length()){
            for(char c : OJ17.lettersMap[Character.getNumericValue(digits.charAt(start))]){
                dfs(ret,digits,start+1,tmp + c);
            }
        }else {
            ret.add(tmp);
        }
    }

    public static void main(String[] args) {
        OJ17.letterCombinations("23");
    }

}
