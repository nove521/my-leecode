package com.cx.leecode.In202006;

import java.util.*;

public class FindSubstring {
    public List<Integer> findSubstring(String s, String[] words) {
        if (s.length() == 0 || words.length == 0) {
            return Collections.emptyList();
        }
        int len = 0;
        for (String word : words) {
            len += word.length();
        }
        int slen = s.length();

        if (len > slen) {
            return Collections.emptyList();
        }

        int index = 0;

        List<Integer> res = new ArrayList<>();

        while (index <= slen - len) {

            Map<Integer, Integer> hash = new HashMap<>();
            int i = index;
            for (; i < index + len; i++) {
                int check = findStr(hash, words, s, i);
                if (check >= 0) {
                    hash.put(check, 1);
                    i = i + words[check].length() - 1;
                    continue;
                }
                break;
            }
            if (i == index + len) {
                res.add(index);
            }
            index++;
        }
        return res;
    }

    public int findStr(Map<Integer, Integer> hash, String[] words, String s, int index) {
        int len = words.length;
        for (int i = 0; i < len; i++) {
            if (hash.get(i) == null && words[i].equals(s.substring(index, index + words[i].length()))) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        FindSubstring findSubstring = new FindSubstring();
        List<Integer> barfoothefoobarman = findSubstring.findSubstring("barfoothefoobarman", new String[]{"foo", "bar"});
        System.out.println(barfoothefoobarman);

         barfoothefoobarman = findSubstring.findSubstring("wordgoodbestword", new String[]{"word", "good", "best", "word"});
        System.out.println(barfoothefoobarman);

        barfoothefoobarman = findSubstring.findSubstring("aaaaaaaa", new String[]{"aa", "aa", "aa"});
        System.out.println(barfoothefoobarman);

        barfoothefoobarman = findSubstring.findSubstring("bccbcc", new String[]{"bc", "cc", "cb"});
        System.out.println(barfoothefoobarman);


        barfoothefoobarman = findSubstring.findSubstring("aaabbbcccaaaaaaddd", new String[]{"aaa", "bbb", "ccc", "aaa", "aaa"});
        System.out.println(barfoothefoobarman);
    }
}
