package com.cx.leecode.In202005;

import java.util.*;

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 * 示例:
 *
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 说明:
 * 尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LetterCombinations {

    public static Map<Character, List<String>> map = new HashMap<>();

    static {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        map.put('2', list);
        list = new ArrayList<>();
        list.add("d");
        list.add("e");
        list.add("f");
        map.put('3', list);
        list = new ArrayList<>();
        list.add("g");
        list.add("h");
        list.add("i");
        map.put('4', list);
        list = new ArrayList<>();
        list.add("j");
        list.add("k");
        list.add("l");
        map.put('5', list);
        list = new ArrayList<>();
        list.add("m");
        list.add("n");
        list.add("o");
        map.put('6', list);
        list = new ArrayList<>();
        list.add("p");
        list.add("q");
        list.add("r");
        list.add("s");
        map.put('7', list);
        list = new ArrayList<>();
        list.add("t");
        list.add("u");
        list.add("v");
        map.put('8', list);
        list = new ArrayList<>();
        list.add("w");
        list.add("x");
        list.add("y");
        list.add("z");
        map.put('9', list);
    }

    public List<String> letterCombinations(String digits) {
        if ("".equals(digits)){
            return Collections.emptyList();
        }
        List<String> result = new ArrayList<>();
        getStr(digits, 0, new StringBuilder(), result);
        return result;
    }

    public void getStr(String digits, int index, StringBuilder sb, List<String> result) {
        if (index >= digits.length()) {
            result.add(sb.toString());
            return;
        }
        char ch = digits.charAt(index);
        List<String> list = map.get(ch);
        int len = sb.length();
        for (String item : list) {
            sb.append(item);
            getStr(digits, index + 1, sb, result);
            sb.delete(len,sb.length());
        }
    }

    public static void main(String[] args) {
        LetterCombinations letterCombinations = new LetterCombinations();
        List<String> list = letterCombinations.letterCombinations("234");
        System.out.println(list);
    }
}
