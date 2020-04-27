package com.cx.leecode.In202004;

import junit.framework.TestCase;

public class MyAtoiTest extends TestCase {

    public void testMyAtoi() {
        MyAtoi myAtoi = new MyAtoi();
        String str;
        str = "56454546";
        assertEquals("返回值数据不正确",56454546,myAtoi.myAtoi(str));

        str = "-91283472332";
        assertEquals("返回值数据不正确",Integer.MIN_VALUE,myAtoi.myAtoi(str));

        str = " -42";
        assertEquals("返回值数据不正确",-42,myAtoi.myAtoi(str));
    }
}