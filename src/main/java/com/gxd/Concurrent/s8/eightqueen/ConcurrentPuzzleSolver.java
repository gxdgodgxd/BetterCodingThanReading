package com.gxd.Concurrent.s8.eightqueen;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by gxdgodgxd on 18/1/25.
 */
public class ConcurrentPuzzleSolver {
    //// TODO: 18/1/25 解谜游戏! 八皇后问题
    WaitForDoneThreadPoolExecutor exec = new WaitForDoneThreadPoolExecutor(5,5,new ArrayBlockingQueue<Runnable>(100));
    Puzzle<Position, Move> puzzle = new EightQueenPuzzle();
    ConcurrentHashMap<Integer, Node<Position, Move>> map = new ConcurrentHashMap<>();
    AtomicInteger count = new AtomicInteger(0);

    public ConcurrentPuzzleSolver() {
        //阻塞任务提交线程,防止任务数量爆炸导致OOM
        exec.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
    }

    public void solve() {
        long starttime = System.nanoTime();
        Position p = puzzle.initialPosition();
        exec.execute(new SolverTask(new Node<Position, Move>(p, null, null)));
        try {
            exec.waitForDone();
            for(Map.Entry entry : map.entrySet()){
                System.out.println(((Node<Position, Move>) entry.getValue()));
            }
        } catch (InterruptedException e) {

        }
        long endtime = System.nanoTime();
        System.out.println(endtime - starttime);
        exec.shutdown();
    }


    class SolverTask implements Runnable {

        Node<Position, Move> node;

        public SolverTask(Node<Position, Move> node) {
            this.node = node;
        }

        public void run() {
            if (puzzle.isGoal(node)) {
                map.put(count.getAndIncrement(), node);
            }
            Set<Move> moves = puzzle.legalMoves(node.pos);
            if (moves == null) {
                return;
            }
            for (Move m : moves) {
                try {
                    exec.execute(new SolverTask(new Node<Position, Move>(puzzle.move(node.pos, m), m, node)));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public static void main(String[] args) {
        ConcurrentPuzzleSolver ps = new ConcurrentPuzzleSolver();
        ps.solve();
    }
}
