package com.cx.leecode.In202005;

import java.util.*;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 * 示例 1:
 *
 * 输入: "()"
 * 输出: true
 * 示例 2:
 *
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 *
 * 输入: "(]"
 * 输出: false
 * 示例 4:
 *
 * 输入: "([)]"
 * 输出: false
 * 示例 5:
 *
 * 输入: "{[]}"
 * 输出: true
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IsValid {

    static Map<Character,Integer> hash = new HashMap<>();
    static Map<Character,Character> hash2 = new HashMap<>();

    static {
        hash.put('{', 1);
        hash.put('[', 1);
        hash.put('(', 1);
        hash.put('}', 2);
        hash.put(']', 2);
        hash.put(')', 2);
        hash2.put('}', '{');
        hash2.put(']', '[');
        hash2.put(')', '(');
    }

    public boolean isValid(String s) {
        LinkedList<Character> list = new LinkedList<>();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            Character poll = list.peekLast();
            if (Objects.isNull(poll) || hash.get(ch) == 1){
                list.add(ch);
                continue;
            }

            if (hash2.get(ch).equals(poll)){
                list.pollLast();
            }else {
                return false;
            }
        }
        return list.isEmpty();
    }

    public static void main(String[] args) {
        IsValid isValid = new IsValid();
//        isValid.isValid("()[{}");
//        isValid.isValid("{[]}");
        isValid.isValid("(])");
        isValid.isValid("");
    }
}
