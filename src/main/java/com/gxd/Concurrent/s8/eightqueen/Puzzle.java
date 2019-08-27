package com.gxd.Concurrent.s8.eightqueen;

import java.util.Set;

/**
 * Created by gxdgodgxd on 18/1/26.
 */
public interface Puzzle<P, M> {

    P initialPosition();

    boolean isGoal(Node<P, M> node);

    Set<M> legalMoves(P p);

    P move(P p, M m) throws Exception;


}
