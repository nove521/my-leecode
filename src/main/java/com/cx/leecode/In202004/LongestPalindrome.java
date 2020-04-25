package com.cx.leecode.In202004;

import java.util.Objects;

/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * <p>
 * 示例 1：
 * <p>
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 * <p>
 * 输入: "cbbd"
 * 输出: "bb"
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LongestPalindrome {
    // 将字符串反转，找出相同最长字符串。
    public String longestPalindrome(String s) {
        if (s.equals(""))
            return "";
        String s2 = new StringBuffer(s).reverse().toString();
        int[] map = new int[s.length()];
        int len = s.length();

        int max = 0;
        int maxX = 0;
        for (int i = 0; i < len; i++) {
            for (int j = len - 1; j >= 0 ; j--) {
                if (s.charAt(i) == s2.charAt(j)) {
                    if (i - 1 >= 0 && j - 1 >= 0) {
                        map[j] = map[j -1] + 1;
                    }else {
                        map[j] = 1;
                    }
                    if (max < map[j]) {
                        int beforeRev = len - 1 - j;
                        if (beforeRev + map[j] - 1 == i){
                            max = map[j];
                            maxX = i;
                        }
                    }
                }else {
                    map[j] = 0;
                }
            }
        }
        return s.substring(maxX - max + 1, maxX + 1);

    }



    private void print(int [][]xx){
        int len = xx.length;

        for (int i = 0 ; i < len ; i++){
            for (int j = 0 ; j < xx[i].length;j++){
                System.out.print(xx[i][j] + " ");
            }
            System.out.println();
        }
    }
}
