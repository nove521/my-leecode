package com.cx.leecode.In202006;

/**
 * 实现 strStr() 函数。
 * <p>
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 * <p>
 * 示例 1:
 * <p>
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: haystack = "aaaaa", needle = "bba"
 * 输出: -1
 * 说明:
 * <p>
 * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 * <p>
 * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/implement-strstr
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class StrStr {
    public int strStr(String haystack, String needle) {
        int len = haystack.length();
        int nlen = needle.length();
        if (nlen == 0) return 0;

        for (int i = 0; i < (len - nlen + 1); i++) {

            if (haystack.charAt(i) == needle.charAt(0)) {
                int k = i + 1;
                int j = 1;
                for (; j < nlen && k < len; j++) {
                    if (haystack.charAt(k++) != needle.charAt(j)) {
                        break;
                    }
                }

                if (j == nlen) {
                    return k - j;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        StrStr strStr = new StrStr();
        int i = strStr.strStr("mississippi", "issipi");
        System.out.println(i);
    }
}
