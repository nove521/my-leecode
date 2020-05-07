package com.cx.leecode.In202005;

import junit.framework.TestCase;

public class IntToRomanTest extends TestCase {

    public void testIntToRoman() {

        IntToRoman intToRoman = new IntToRoman();

        int x = 9;
        print(x, intToRoman.intToRoman(x), "IX");

        x = 58;
        print(x, intToRoman.intToRoman(x), "LVIII");

        x = 1994;
        print(x, intToRoman.intToRoman(x), "MCMXCIV");

        x = 3999;
        print(x, intToRoman.intToRoman(x), "MMMCMXCIX");
    }

    private void print(int ival, String val, String ex) {
        System.out.println(String.format("数字 %s 对应的阿拉伯数字为：%s", ival, val));
        assertEquals("阿拉伯数字不正确", val, ex);
    }
}