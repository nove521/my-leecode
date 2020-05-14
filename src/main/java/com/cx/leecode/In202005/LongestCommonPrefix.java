package com.cx.leecode.In202005;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * 示例 1:
 *
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 *
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 说明:
 *
 * 所有输入只包含小写字母 a-z 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-common-prefix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        int len = strs.length;
        StringBuilder sb = new StringBuilder();
        int index = 0;
        while (len > 0 && index < strs[0].length()){
            char c = strs[0].length() > 0 ? strs[0].charAt(index) : 0;
            for (int i = 0; i < len; i++) {
                if (strs[i].length() <= index){
                    return sb.toString();
                }
                if (strs[i].charAt(index) != c) {
                    return sb.toString();
                }
            }
            sb.append(strs[0].charAt(index));
            index ++;
        }
        return sb.toString();
    }
}
