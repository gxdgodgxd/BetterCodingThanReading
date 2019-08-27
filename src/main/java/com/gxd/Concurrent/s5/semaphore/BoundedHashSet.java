package com.gxd.Concurrent.s5.semaphore;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Semaphore;

/**
 * Created by gxdgodgxd on 18/1/12.
 */
public class BoundedHashSet<T> {

    private final Set<T> set;
    private final Semaphore sem;

    public BoundedHashSet(int bound) {
        this.set = Collections.synchronizedSet(new HashSet());
        this.sem = new Semaphore(bound);
    }

    public boolean add(T t) throws InterruptedException {
        sem.acquire();
        boolean isAdded = false;
        try {
            isAdded = set.add(t);
            return isAdded;
        }finally {
            if (!isAdded) {
                sem.release();
            }
        }
    }

    public boolean remove(T t) {
        boolean isRemoved = set.remove(t);
        if (isRemoved) {
            sem.release();
        }
        return isRemoved;
    }
}
