package com.gxd.Concurrent.s7;

/**
 * Created by gxdgodgxd on 18/3/9.
 */
public class SequenceManager {

    static Sequence sequence;

    public static void initSequence(){
        sequence = new FileModelSequence();
        sequence.init();
    }

    public static int getSeq(){
        return sequence.getSequence();
    }

    public static void stop(){
        if (sequence != null) {
            sequence.stop();
        }
    }

    public static void main(String[] args) {
        Runtime.getRuntime().addShutdownHook(new Thread(){
            @Override
            public void run() {
                SequenceManager.stop();
            }
        });
        SequenceManager.initSequence();
        SequenceManager.getSeq();
        SequenceManager.getSeq();
        try {
            Thread.sleep(1200000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
