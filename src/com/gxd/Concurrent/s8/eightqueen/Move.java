package com.gxd.Concurrent.s8.eightqueen;

/**
 * Created by gxdgodgxd on 18/1/26.
 */
public class Move {

    public Move(int direction) {
        this.direction = direction;
    }

    private int direction;

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }
}
