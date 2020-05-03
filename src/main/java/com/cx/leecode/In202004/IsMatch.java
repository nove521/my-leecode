package com.cx.leecode.In202004;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
 *
 * '.' 匹配任意单个字符
 * '*' 匹配零个或多个前面的那一个元素
 * 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
 *
 * 说明:
 *
 * s 可能为空，且只包含从 a-z 的小写字母。
 * p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。
 * 示例 1:
 *
 * 输入:
 * s = "aa"
 * p = "a"
 * 输出: false
 * 解释: "a" 无法匹配 "aa" 整个字符串。
 * 示例 2:
 *
 * 输入:
 * s = "aa"
 * p = "a*"
 * 输出: true
 * 解释: 因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
 * 示例 3:
 *
 * 输入:
 * s = "ab"
 * p = ".*"
 * 输出: true
 * 解释: ".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
 * 示例 4:
 *
 * 输入:
 * s = "aab"
 * p = "c*a*b"
 * 输出: true
 * 解释: 因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。
 * 示例 5:
 *
 * 输入:
 * s = "mississippi"
 * p = "mis*is*p*."
 * 输出: false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/regular-expression-matching
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IsMatch {
    public boolean isMatch(String s, String p) {
        int lenS = s.length();
        int lenP = p.length();
        if (lenS == 0 && lenP == 1){
            return false;
        }
        if (lenP == 0 && lenS == 0)
            return true;
        if (lenP == 0){
            return false;
        }
        if (lenS == 0 )
            s = "1";
            lenS = s.length();

        int [][]map = new int[lenP + 1][lenS + 1];
        if (p.charAt(0) == '*' || p.charAt(0) == '+'){
            return false;
        }
        map[0][0] = 1;
        map[0][1] = 1;
        for (int i = 1; i < lenP + 1; i++) {

            if (i > 1 && p.charAt(i-1) == '*' && p.charAt(i-2) == '*'){
                return false;
            }
            if (i > 1 && p.charAt(i-1) == '+' && p.charAt(i-2) == '+'){
                return false;
            }

            if (p.charAt(i-1) == '*' && map[i - 1][0] == 1){
                map[i][0] = 1;
            }else if (p.charAt(i-1) == '*' && map[i - 2][0] == 1){
                map[i][0] = 1;
            }else{
                map[i][0] = 0;
            }
        }


        for (int i = 1; i <= lenP; i++) {
            char charP = p.charAt(i-1);
            for (int j = 1; j <= lenS; j++) {
                char charS = s.charAt(j-1);
                if ((charS == charP || charP == '.') && map[i - 1][j - 1] == 1){
                    if (i == 1 && j == 1){
                        map[i][j] = 1;
                    }
                    if (i > 1){
                        map[i][j] = 1;
                    }
                    if (i ==1){
                        break;
                    }
                }
                if (charP == '*' && ( map[i - 1][j -1] == 1 ||  map[i ][j -1] == 1) && (p.charAt(i-2) == charS || p.charAt(i-2) == '.')){
                    map[i][j] = 1;
                }else if (charP == '*' && map[i - 1][j] == 1 ){
                    map[i][j] = 1;
                }else if (charP == '*' && map[i - 2][j] == 1 ){
                    map[i][j] = 1;
                }
                if (charP == '+' && map[i-1][j -1] == 1 && charS == p.charAt(i-2)){
                    map[i][j] = 1;
                }
            }
        }
        printMap(map,s,p);
        return map[lenP ][lenS ] == 1;
    }

    public boolean isMatch2(String s, String p) {
        int ns = s.length() + 1, np = p.length() + 1;
        boolean[][] dp = new boolean[ns][np];
        dp[0][0] = true;
        for (int i = 1; i < np; i++) {
            // 这一步就是代表 如果 s长度为0的情况下， p = a*s*s*s* . 就匹配，只要p的奇数位是 *，那么就能匹配的到
            if (((i - 1) & 1) == 1) {
                System.out.println(i);
                if (p.charAt(i - 1) != '*') {
                    break;
                }
                dp[0][i] = true;
            }
        }

        for (int i = 1; i < ns; i++) {
            for (int j = 1; j < np; j++) {
                if (p.charAt(j - 1) == '.' || p.charAt(j - 1) == s.charAt(i - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
                if (p.charAt(j - 1) == '*') {
                    if (s.charAt(i - 1) != p.charAt(j - 2) && p.charAt(j - 2) != '.') {
                        dp[i][j] = dp[i][j - 2];
                    } else {
                        dp[i][j] = dp[i - 1][j] || dp[i][j - 1] || dp[i][j - 2];
                    }
                }
            }
        }
        pintMap2(dp,s,p);
        return dp[ns - 1][np - 1];
    }

    private void pintMap2(boolean [][]map,String s,String p){
        System.out.print("    ");
        for (int i = 1; i < map[0].length; i++) {
            System.out.print(p.charAt(i -1 ) + " ");
        }
        System.out.println();
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (i == 0 && j == 0){
                    System.out.print("  ");
                }
                if (j == 0 && i > 0){
                    System.out.print(s.charAt(i - 1) + " ");
                }
                System.out.print((map[i][j] ? "1" : "0") + " ");
            }
            System.out.println();
        }
    }

    private void printMap(int [][]map,String s,String p){
        System.out.print("  ");
        for (int i = 1; i < map[0].length; i++) {
            System.out.print(s.charAt(i -1 ) + " ");
        }
        System.out.println();
        for (int i = 1; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (j == 0){
                    System.out.print(p.charAt(i-1) + " ");
                }else {
                    System.out.print(map[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    public static void main2(String[] args) {
        IsMatch isMatch = new IsMatch();
        System.out.println(isMatch.isMatch("mississippi","mis*is*ip*."));
        System.out.println(isMatch.isMatch("aa","a"));
        System.out.println(isMatch.isMatch("abcd","d*"));
        System.out.println(isMatch.isMatch("aaba","ab*a*c*a"));
        System.out.println(isMatch.isMatch("ab",".*"));
        System.out.println(isMatch.isMatch("aaa","ab*a*c*a"));
        System.out.println(isMatch.isMatch("aaa",".*"));
        System.out.println(isMatch.isMatch("abb","bbb*"));
        System.out.println(isMatch.isMatch("aab","c*a*b"));
        System.out.println(isMatch.isMatch("","c*a*"));
        System.out.println(isMatch.isMatch("",".b*"));

    }

    public static void main(String[] args) {
        IsMatch isMatch = new IsMatch();
        System.out.println(isMatch.isMatch2("mississippi","mis*is*ip*."));
//        System.out.println(isMatch.isMatch2("aa","a"));
//        System.out.println(isMatch.isMatch2("abcd","d*"));
        System.out.println(isMatch.isMatch2("aaa","a*a*a*c*a"));
    }
}
