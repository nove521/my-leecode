package com.cx.leecode.In202005;

import junit.framework.TestCase;

public class LongestCommonPrefixTest extends TestCase {

    public void testLongestCommonPrefix() {
        LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();
        String s = longestCommonPrefix.longestCommonPrefix(new String[]{"flower","flow","flight"});
        print(s,"fl");
        s = longestCommonPrefix.longestCommonPrefix(new String[]{"dog","racecar","car"});
        print(s,"");
        s = longestCommonPrefix.longestCommonPrefix(new String[]{"","racecar","car"});
        print(s,"");
        s = longestCommonPrefix.longestCommonPrefix(new String[]{"","",""});
        print(s,"");
        s = longestCommonPrefix.longestCommonPrefix(new String[]{});
        print(s,"");
        s = longestCommonPrefix.longestCommonPrefix(new String[]{"a"});
        print(s,"a");
    }

    private void print(String val,String ext){
        assertEquals("最长匹配前缀字符串不正确",val,ext);
        System.out.println("最长匹配字符串:" + val);
    }
}