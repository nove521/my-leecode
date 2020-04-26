package com.cx.leecode.In202004;

import junit.framework.TestCase;

public class ConvertTest extends TestCase {

    public void testConvert() {

        Convert convert = new Convert();
        String result;
        int rows;

        result = "LEETCODEISHIRING";
        rows = 3;
        assertEquals("排序结果不正确", "LCIRETOESIIGEDHN", convert.convert(result,rows));

        result = "LEETCODEISHIRING";
        rows = 4;
        assertEquals("排序结果不正确", "LDREOEIIECIHNTSG", convert.convert(result,rows));

        result = "A";
        rows = 1;
        assertEquals("排序结果不正确", "A", print(convert.convert(result,rows)));
    }

    private String print(String str){
        System.out.println(str);
        return str;
    }
}