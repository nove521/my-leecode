package com.cx.leecode.In202009;

import java.util.*;

public class WordBreak {
    public List<String> wordBreak3(String s, List<String> wordDict) {
        List<Integer>[] lists = new List[s.length()];
        mark = new boolean[s.length()];

        for (int i = 0; i < lists.length; i++) {
            lists[i] = new ArrayList<>();
        }

        for (int i = 0; i < wordDict.size(); i++) {
            int pos = s.indexOf(wordDict.get(i));
            while (pos != -1) {
                lists[pos].add(i);
                pos = s.indexOf(wordDict.get(i), pos + 1);
            }
        }
        dfs(lists, 0, wordDict);
        return res;
    }

    StringBuilder temp = new StringBuilder();
    List<String> res = new ArrayList<>();
    boolean[] mark;

    void dfs(List<Integer>[] lists, int pos, List<String> wordDict) {

        if (pos == lists.length) {
            res.add(temp.substring(0, temp.length() - 1));
            return;
        }
        if (mark[pos])
            return;
        int n = res.size();
        for (Integer x : lists[pos]) {
            String t = wordDict.get(x);
            temp.append(t).append(" ");
            dfs(lists, pos + t.length(), wordDict);
            temp.delete(temp.length() - 1 - t.length(), temp.length());
        }
        if (n == res.size()) {
            mark[pos] = true;
        }
    }

    public List<String> wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);
        LinkedList<String> item = new LinkedList<>();
        final char[] chars = s.toCharArray();
        List<String> res = new ArrayList<>();
        mark = new boolean[s.length()];
        dd(res, chars, 0, set, s, item);
        return res;
    }

    private void dd(List<String> res, char[] chars, int start, HashSet<String> set, String s, LinkedList<String> item) {
        int len = chars.length;
        if (start == len) {
            res.add(String.join(" ", item.toArray(new String[]{})));
            return;
        }
        if (mark[start])
            return;
        int n = res.size();
        for (int i = start; i <= len; i++) {
            final String substring = s.substring(start, i);
            if (!set.contains(substring)) {
                continue;
            }
            item.addLast(substring);
            dd(res, chars, i, set, s, item);
            item.removeLast();
        }
        if (n == res.size()) {
            mark[start] = true;
        }
    }

    public static void main(String[] args) {

        WordBreak wordBreak = new WordBreak();
        System.out.println(wordBreak.wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
                Arrays.asList("a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaa")));

    }
}
