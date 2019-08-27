package com.gxd.Concurrent.s8.eightqueen;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by gxdgodgxd on 18/1/26.
 */
public class EightQueenPuzzle implements Puzzle<Position, Move> {

    public static final int SIZE = 10;

    @Override
    public Position initialPosition() {
        return new Position(0, -1);
    }

    @Override
    public boolean isGoal(Node<Position, Move> node) {
        List<Position> positions = node.asPosList();
        if (positions.size() < SIZE) {
            return false;
        } else {
            return EightQueenValidator.isValid(positions);
        }
    }

    @Override
    public Set<Move> legalMoves(Position position) {
        if (position.getY() == SIZE - 1) {
            return null;
        } else {
            HashSet<Move> set = new HashSet<>();
            for (int i = 0; i < SIZE; i++) {
                set.add(new Move(i));
            }
            return set;
        }

    }

    @Override
    public Position move(Position position, Move move) throws Exception {
        if (move.getDirection() < SIZE && move.getDirection() >= 0) {
            return new Position(move.getDirection(), position.getY() + 1);
        } else {
            throw new Exception("illegal move direction!");
        }
    }
}
