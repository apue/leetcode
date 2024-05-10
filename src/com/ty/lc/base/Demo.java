package com.ty.lc.base;

import sun.jvm.hotspot.runtime.VM;

public class Demo {
    private static final Demo sInstance = new Demo();

    public static int tmp = 500;

    public static Demo getInstance() {
        System.out.println("getInstance: " + tmp + ", " + System.identityHashCode(tmp));
        return sInstance;
    }

    private Demo() {
        System.out.println("constructor: " + tmp + ", " + System.identityHashCode(tmp));
        tmp = 1000;
        System.out.println("constructor: " + tmp + ", " + System.identityHashCode(tmp));
    }

    public void printTmp() {
        System.out.println("printTmp: " + tmp + ", " + System.identityHashCode(tmp) + ", " + hashCode());
    }

    public static void main(String[] args) {
        Demo.getInstance().printTmp();
    }
}
