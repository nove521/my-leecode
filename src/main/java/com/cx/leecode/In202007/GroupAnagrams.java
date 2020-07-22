package com.cx.leecode.In202007;

import java.util.*;

/**
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 *
 * 示例:
 *
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 * 说明：
 *
 * 所有输入均为小写字母。
 * 不考虑答案输出的顺序。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/group-anagrams
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();
        List<List<String>> res = new ArrayList<>();
        for (String str : strs) {
            String key = createKey(str);
            List<String> val = map.get(key);
            if (Objects.isNull(val)){
                List<String> objects = new ArrayList<>();
                objects.add(str);
                res.add(objects);
                map.put(key,objects);
            }else {
                val.add(str);
            }
        }
        return res;
    }

    private String createKey(String str){
        int len = str.length();
        int []keyC = new int[26];
        for (int i = 0; i < len; i++) {
            char c = str.charAt(i);
            int index = c - 'a';
            keyC[index]++;
        }
        StringBuilder res = new StringBuilder(26);
        for (int i : keyC) {
            res.append(i);
        }
        return res.toString();
    }

    public static void main(String[] args) {
        GroupAnagrams groupAnagrams = new GroupAnagrams();
        List<List<String>> lists = groupAnagrams.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
        System.out.println(lists);
    }
}
