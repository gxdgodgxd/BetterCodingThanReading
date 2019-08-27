package com.gxd.Concurrent.s8.eightqueen;

import java.util.List;

/**
 * Created by gxdgodgxd on 18/1/26.
 */
public class EightQueenValidator {

    public static boolean isValid(List<Position> positions) {
        int ix,iy,jx,jy;
        for (int i = 0; i < positions.size()-1; i++) {
            for (int j = i+1; j < positions.size(); j++) {
                ix = positions.get(i).getX();
                iy = positions.get(i).getY();
                jx = positions.get(j).getX();
                jy = positions.get(j).getY();
                //check if two pos is in same row/colomn/diagonal
                if (ix == jx || iy == jy || ix + iy == jx + jy || ix - iy == jx - jy) {
                    return false;
                }
            }
        }
        return true;
    }
}
