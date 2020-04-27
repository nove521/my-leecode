package com.cx.leecode.In202004;

/**
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 *
 * 示例 1:
 *
 * 输入: 121
 * 输出: true
 * 示例 2:
 *
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3:
 *
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IsPalindrome {
    public static boolean isPalindrome(int x) {
        if (x < 0) return false;
        if (x < 10) return true;
        if (x % 10 ==0)return false;
        int result = 0;
        int xx = x;
        int pow = 10;
        while (x != 0 || xx > result) {
            result = result * pow + x % 10;
            xx = x / pow;
            if (result == xx || (xx / 10 != 0 && result == xx / 10)) {
                return true;
            }
            x = x / 10;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(1000021));
    }
}
