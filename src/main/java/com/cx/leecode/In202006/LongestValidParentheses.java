package com.cx.leecode.In202006;

import java.util.LinkedList;

/**
 * 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "(()"
 * 输出: 2
 * 解释: 最长有效括号子串为 "()"
 * 示例 2:
 * <p>
 * 输入: ")()())"
 * 输出: 4
 * 解释: 最长有效括号子串为 "()()"
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LongestValidParentheses {
    public int longestValidParentheses2(String s) {
        int len = s.length();
        int[] dp = new int[len];
        int max = 0;
        for (int i = 1; i < len; i++) {
            char c = s.charAt(i);
            if (c == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i - 2) >= 0 ? dp[i - 2] + 2 : 2;
                } else if ((i - dp[i - 1] - 1) >= 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = (i - dp[i - 1] - 2) >= 0 ? dp[i - dp[i - 1] - 2] + dp[i - 1] + 2 : dp[i - 1] + 2;
                }
                max = Math.max(max, dp[i]);
            }
        }
        return max;
    }

    public int longestValidParentheses(String s) {
        int len = s.length();
        int max = 0;
        LinkedList<Integer> link = new LinkedList<>();
        link.addLast(-1);
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == '(') {
                link.addLast(i);
            } else {
                link.pollLast();
                if (link.isEmpty()) {
                    link.addLast(i);
                } else {
                    max = Math.max(max, i - link.peekLast());
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        LongestValidParentheses longestValidParentheses = new LongestValidParentheses();
        int i = longestValidParentheses.longestValidParentheses("(()");
        System.out.println(i);

        i = longestValidParentheses.longestValidParentheses(")()())");
        System.out.println(i);

        i = longestValidParentheses.longestValidParentheses("()(())(()");
        System.out.println(i);

        i = longestValidParentheses.longestValidParentheses(")()())");
        System.out.println(i);

        i = longestValidParentheses.longestValidParentheses("()(()");
        System.out.println(i);

        i = longestValidParentheses.longestValidParentheses("(()()");
        System.out.println(i);
    }


}
