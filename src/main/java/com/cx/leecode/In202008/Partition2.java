package com.cx.leecode.In202008;

import java.util.*;

/**
 * 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
 * <p>
 * 返回 s 所有可能的分割方案。
 * <p>
 * 示例:
 * <p>
 * 输入:"aab"
 * 输出:
 * [
 * ["aa","b"],
 * ["a","a","b"]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-partitioning
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Partition2 {

    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        final char[] chars = s.toCharArray();

        if (chars.length == 1 || isHui(chars,0,chars.length - 1,s)){
            List<String> item = new ArrayList<>();
            item.add(s);
            res.add(item);
        }
        LinkedList<String> item = new LinkedList<>();
        pp(res, item, chars, 0, s.length(), s);
        return res;
    }

    private void pp(List<List<String>> res, LinkedList<String> item, char[] chars, int start, int end, String s) {
        for (int i = start + 1; i <= end - 1; i++) {
            final int size = item.size();
            if (isHui(chars, start, i - 1,s)) {
                item.addLast(s.substring(start, i));
            }else {
                continue;
            }
            if (isHui(chars, i, end - 1,s)) {
                item.addLast(s.substring(i, end));
                res.add(new ArrayList<>(item));
                item.removeLast();
            }
            pp(res, item, chars, i, end, s);

            int len = item.size();
            for (int j = size; j <len ; j++) {
                item.removeLast();
            }
        }
    }

    private boolean isHui(char[] chars, int start, int end,String s) {

        while (start < end) {
            if (chars[start++] != chars[end]--) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Partition2 partition2 = new Partition2();
        System.out.println(partition2.partition("abb"));
    }
}
