package com.cx.leecode.utils;

import java.util.Objects;

public final class TestTimeHolder {

    private long startTime;

    private static TestTimeHolder testTimeHolder;

    private TestTimeHolder() {
        start();
    }

    public static TestTimeHolder newInstance() {
        if (Objects.isNull(testTimeHolder)) {
            synchronized (TestTimeHolder.class) {
                if (Objects.isNull(testTimeHolder)) {
                    testTimeHolder = new TestTimeHolder();
                    return testTimeHolder;
                }
            }
        }
        return testTimeHolder;
    }

    public void start() {
        startTime = System.currentTimeMillis();
    }

    public static void end() {
        long now = System.currentTimeMillis();
        formateTime(now - testTimeHolder.startTime);
    }

    private static void formateTime(long sub) {
        System.out.println("执行了： " + sub + "毫秒");
    }

}
