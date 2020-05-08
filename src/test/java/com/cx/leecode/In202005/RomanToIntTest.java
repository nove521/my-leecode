package com.cx.leecode.In202005;

import junit.framework.TestCase;

public class RomanToIntTest extends TestCase {

    public void testRomanToInt() {

        RomanToInt romanToInt = new RomanToInt();

        String x = "III";
        print(x, romanToInt.romanToInt(x), 3);

        x = "IV";
        print(x, romanToInt.romanToInt(x), 4);

        x = "IX";
        print(x, romanToInt.romanToInt(x), 9);

        x = "LVIII";
        print(x, romanToInt.romanToInt(x), 58);

        x = "MCMXCIV";
        print(x, romanToInt.romanToInt(x), 1994);
    }

    private void print(String ival, int val, int ex) {
        System.out.println(String.format("%s ：阿拉伯数字对应的数字为 %s", ival, val));
        assertEquals("阿拉伯数字不正确", val, ex);
    }
}