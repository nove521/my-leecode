package com.cx.leecode.In202004;

import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LongestPalindromeTest extends TestCase {


    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testLongestPalindrome() {
        String result = "";
        LongestPalindrome longestPalindrome = new LongestPalindrome();
        String s = "aabbabbc";
        result = longestPalindrome.longestPalindrome(s);
        print("bbabb",result,s);

        s = "aabbab";
        result = longestPalindrome.longestPalindrome(s);
        print("abba",result,s);

        s = "aabbabb";
        result = longestPalindrome.longestPalindrome(s);
        print("bbabb",result,s);

        s = "a";
        result = longestPalindrome.longestPalindrome(s);
        print("a",result,s);

        s = "aba";
        result = longestPalindrome.longestPalindrome(s);
        print("aba",result,s);

        s = "bananas";
        result = longestPalindrome.longestPalindrome(s);
        print("anana",result,s);

        s = "aacdefcaa";
        result = longestPalindrome.longestPalindrome(s);
        print("aa",result,s);

        s = "cbcdcbedcbc";
        result = longestPalindrome.longestPalindrome(s);
        print("bcdcb",result,s);
    }



    private void print(String expect,String result,String s){
        System.out.println("字符串：" + s + " 输出的回文是：" + result);
        assertEquals("回文不正确",expect,result);
    }
}