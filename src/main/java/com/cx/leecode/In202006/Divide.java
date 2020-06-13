package com.cx.leecode.In202006;


import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

/**
 * 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
 * <p>
 * 返回被除数 dividend 除以除数 divisor 得到的商。
 * <p>
 * 整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: dividend = 10, divisor = 3
 * 输出: 3
 * 解释: 10/3 = truncate(3.33333..) = truncate(3) = 3
 * 示例 2:
 * <p>
 * 输入: dividend = 7, divisor = -3
 * 输出: -2
 * 解释: 7/-3 = truncate(-2.33333..) = -2
 *  
 * <p>
 * 提示：
 * <p>
 * 被除数和除数均为 32 位有符号整数。
 * 除数不为 0。
 * 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231,  231 − 1]。本题中，如果除法结果溢出，则返回 231 − 1。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/divide-two-integers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Divide {
    public int divide(int dividend, int divisor) {
        if (dividend == divisor) return 1;
        if (divisor == 1) return dividend;
        if (divisor == -1) {
            if (dividend == Integer.MIN_VALUE) {
                return Integer.MAX_VALUE;
            }
            return -dividend;
        }
        if (divisor == Integer.MIN_VALUE) return 0;

        int c = 0;

        if (dividend < 0) {
            dividend = dividend == Integer.MIN_VALUE ? Integer.MAX_VALUE : -dividend;
            c++;
        }
        if (divisor < 0) {
            divisor = -divisor;
            c++;
        }

        long res = div(dividend, divisor) ;
        return (int) (res * (c % 2 == 0 ? 1 : -1));
    }

    public int div(long dividend, long divisor) {

        if (dividend < divisor) {
            return 0;
        }
        long divInt = divisor;
        int count = 1;
        while ( dividend >= divInt + divInt) {
            divInt = divInt + divInt;
            count = count + count;
        }
        return count + div(dividend - divInt, divisor);

    }

    public static void main(String[] args) {
        Divide divide = new Divide();
//        System.out.println(divide.divide(-100, -3));
//        System.out.println(divide.divide(-2147483648, -1));

//        System.out.println(divide.divide(-65, 2));
//        System.out.println(divide.divide(999, 55));
//        System.out.println(divide.divide(-2147483648, 2));
//        System.out.println(divide.divide(-21, -1));
//        System.out.println(divide.divide(1, 2));
//        System.out.println(divide.divide(2147483647, -2147483648));

        int a = Integer.MAX_VALUE /2 ;
        int b = Integer.MAX_VALUE / 2 +111;
        System.out.println(Integer.MAX_VALUE * 2);

    }
}
