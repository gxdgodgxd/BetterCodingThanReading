package com.gxd.Concurrent.s15;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by gxdgodgxd on 18/2/24.
 */

public class Cat implements Serializable {

    private String name;
    private AtomicInteger age;

    public Cat() {
        this.name = "new cat";
        this.age = new AtomicInteger(10);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
