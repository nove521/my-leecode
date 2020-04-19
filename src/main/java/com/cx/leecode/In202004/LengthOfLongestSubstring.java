package com.cx.leecode.In202004;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 无重复字符的最长子串
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * <p>
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * <p>
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        int reslutLen = 0;
        int len = s.length();
        int startIndex = 0; // 它们叫做滑动窗口 。这里表示匹配的最长字符串起始位置

        Map<Character, Integer> hashMap = new HashMap<>();
        // 采用单次循环，你细品
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            Integer index = hashMap.get(c);
            if (Objects.nonNull(index)) {
                if (reslutLen < (i - startIndex)) {
                    reslutLen = i - startIndex;
                }
                if (index >= startIndex){
                    startIndex = index + 1;
                }
            }
            hashMap.put(c, i);
        }
        if (reslutLen < (len - startIndex)) {
            reslutLen = len - startIndex;
        }
        return reslutLen;
    }

    /**
     * 和上面一样，用MAX 精简点
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring3(String s) {
        int reslutLen = 0;
        int len = s.length();
        int startIndex = 0;
        Map<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            Integer index = hashMap.get(c);
            if (Objects.nonNull(index)) {
                reslutLen = Math.max(reslutLen, i - startIndex);
                if (index >= startIndex){
                    startIndex = index + 1;
                }
            }
            hashMap.put(c, i);
        }
        reslutLen = Math.max(reslutLen, len - startIndex);
        return reslutLen;
    }

    /**
     * 其他人玩法。
     * @param s 入参
     * @return 出参
     */
    public int lengthOfLongestSubstring2(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }
}
