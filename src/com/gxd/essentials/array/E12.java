package com.gxd.essentials.array;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Created by gxdgodgxd on 17/2/16.
 */
public class E12 {

    /**
     * good code using hashset
     * 需要判断数值是否重复时,hashset是个好的选择
     **/
    public boolean isValidSudoku(char[][] board) {
        for(int i = 0; i<9; i++){
            HashSet<Character> rows = new HashSet<Character>();
            HashSet<Character> columns = new HashSet<Character>();
            HashSet<Character> cube = new HashSet<Character>();
            for (int j = 0; j < 9;j++){
                if(board[i][j]!='.' && !rows.add(board[i][j]))
                    return false;
                if(board[j][i]!='.' && !columns.add(board[j][i]))
                    return false;
                int RowIndex = 3*(i/3);
                int ColIndex = 3*(i%3);
                if(board[RowIndex + j/3][ColIndex + j%3]!='.' && !cube.add(board[RowIndex + j/3][ColIndex + j%3]))
                    return false;
            }
        }
        return true;
    }

    public boolean isValidSudoku2(char[][] board) {
        boolean[] used = new boolean[9];

        for (int i = 0; i < 9; i++) {
            Arrays.fill(used, false);
            for (int j = 0; j < 9; j++) {
                if (!isValid(board[i][j], used)) {
                    return false;
                }
            }
            Arrays.fill(used,false);
            for (int j = 0; j < 9; j++) {
                if(!isValid(board[j][i],used)){
                    return false;
                }
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {

                Arrays.fill(used, false);

                for (int k = 0; k < 3; k++) {
                    for (int l = 0; l < 3; l++) {
                        if(!isValid(board[i*3+k][j*3+l],used)){
                            return false;
                        }
                    }
                }

            }
        }
        return true;

    }

    public boolean isValid(char c, boolean[] used) {
        if (c=='.') {
            return true;
        }
        if(used[c-'1']){
            return false;
        }
        used[c-'1'] = true;
        return true;
    }

}
