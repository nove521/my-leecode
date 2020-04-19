package com.cx.leecode.In202004;

import com.cx.leecode.utils.TestTimeHolder;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 *  abcdb
 */
public class LengthOfLongestSubstringTest extends TestCase {

    @Before
    public void setUp() throws Exception {
        TestTimeHolder.newInstance();
    }

    @After
    public void tearDown() throws Exception {
        TestTimeHolder.end();
    }

    @Test
    public void testLengthOfLongestSubstring() {
        LengthOfLongestSubstring obj = new LengthOfLongestSubstring();
        String s = "abcdabcdd";
        printMessage(s, obj.lengthOfLongestSubstring(s), 4);

        s = "bbbbb";
        printMessage(s, obj.lengthOfLongestSubstring(s), 1);

        s = "pwwkew";
        printMessage(s, obj.lengthOfLongestSubstring(s), 3);

        s = "aabbccdd";
        printMessage(s, obj.lengthOfLongestSubstring(s), 2);

        s = "abcdbewqooi";
        printMessage(s, obj.lengthOfLongestSubstring(s), 7);

        s = "abcdbewqooi123456789";
        printMessage(s, obj.lengthOfLongestSubstring(s), 11);

        s = "abba";
        printMessage(s, obj.lengthOfLongestSubstring(s), 2);
    }

    /**
     * 打印 并 断言
     *
     * @param s      输入的字符串
     * @param len    结果最大长度
     * @param expect 期望最大长度
     */
    private void printMessage(String s, int len, int expect) {
        System.out.println("字符串： " + s + " | 最大长度为：" + len);
        assertEquals("最大长度不正确",expect, len);
    }
}