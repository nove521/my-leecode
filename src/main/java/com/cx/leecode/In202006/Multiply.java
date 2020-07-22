package com.cx.leecode.In202006;

/**
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 * <p>
 * 示例 1:
 * <p>
 * 输入: num1 = "2", num2 = "3"
 * 输出: "6"
 * 示例 2:
 * <p>
 * 输入: num1 = "123", num2 = "456"
 * 输出: "56088"
 * 说明：
 * <p>
 * num1 和 num2 的长度小于110。
 * num1 和 num2 只包含数字 0-9。
 * num1 和 num2 均不以零开头，除非是数字 0 本身。
 * 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/multiply-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Multiply {
    public String multiply(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }

        int len1 = num1.length();
        int len2 = num2.length();
        int[][] cache = new int[len2][len1 + 1];
        StringBuilder sum = new StringBuilder();

        for (int i = 0; i < len2; i++) {
            int x = num2.charAt(len2 - i - 1) - '0';
            if (x == 0) {
                continue;
            }
            for (int j = 0; j < len1; j++) {
                int c = num1.charAt(len1 - j - 1) - '0';
                int s = x * c;
                cache[i][j] = cache[i][j] + (s % 10);
                cache[i][j + 1] = s / 10;
            }
        }

        int ca = 0;

        for (int i = 0; i < len2 + len1; i++) {
            int s = 0;
            for (int j = 0; j < len2; j++) {
                if (i - j >= 0 && i - j < len1 + 1) {
                    s += cache[j][i - j];
                }
            }
            s = s + ca;

            if (i == (len2 + len1 - 1) && s == 0) {
                continue;
            }

            sum.append(s % 10);
            ca = s / 10;
        }
        return sum.reverse().toString();
    }

    /**
     *   000
     *  000
     * 100
     *
     * @param args
     */
    public static void main(String[] args) {
        Multiply multiply = new Multiply();
        String multiply1 = multiply.multiply("10", "99999");
        System.out.println(multiply1);
    }
}
