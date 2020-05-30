package com.cx.leecode.In202005;

import java.util.ArrayList;
import java.util.List;

/**
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 *
 *  
 *
 * 示例：
 *
 * 输入：n = 3
 * 输出：[
 *        "((()))",
 *        "(()())",
 *        "(())()",
 *        "()(())",
 *        "()()()"
 *      ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/generate-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class GenerateParenthesis {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        int size = n * 2;
        StringBuilder sb = new StringBuilder(size);
        fun(size, n, 0, sb, res);
        return res;
    }

    public void fun(int total, int n, int count, StringBuilder sb, List<String> res) {

        if (sb.length() == total) {
            res.add(sb.toString());
            return;
        }
        if (count < n) {
            sb.append('(');
            int len = sb.length();
            fun(total, n, count + 1, sb, res);
            sb.delete(len - 1, sb.length());
        }
        if (count > 0) {
            sb.append(')');
            fun(total, n - 1, count - 1, sb, res);
        }
    }

    public static void main(String[] args) {
        GenerateParenthesis generateParenthesis = new GenerateParenthesis();
        generateParenthesis.generateParenthesis(3);
    }
}
