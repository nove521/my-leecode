package com.cx.leecode.In202009;

import java.util.*;

public class WordDictionary {

    private static Set<String> dict = new HashSet<>();
    private  static Map<Integer, List<String>> map = new HashMap<>();
    private static Map<String, Boolean> cache = new HashMap<>();

    /**
     * Initialize your data structure here.
     */
    public WordDictionary() {
        dict.clear();
        map.clear();
        cache.clear();
    }

    /**
     * Adds a word into the data structure.
     */
    public void addWord(String word) {
        dict.add(word);

        final List<String> strings = map.get(word.length());
        if (strings == null) {
            final List<String> objects = new ArrayList<>();
            objects.add(word);
            map.put(word.length(), objects);
        } else {
            strings.add(word);
        }
    }

    /**
     * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
     */
    public boolean search(String word) {
        if (word == null) {
            return false;
        }
        final Boolean aBoolean = cache.get(word);
        if (aBoolean != null) {
            return aBoolean;
        }
        if (dict.contains(word)) {
            cache.put(word, true);
            return true;
        }
        final List<String> strings = map.get(word.length());
        if (strings == null) {
            return false;
        }
        for (String string : strings) {
            if (oo(word, string)) {
                cache.put(word, true);
                return true;
            }
        }
        return false;
    }

    private boolean oo(String a, String b) {
        int len = a.length();
        for (int i = 0; i < len; i++) {
            if (a.charAt(i) == '.') {
                continue;
            }
            if (a.charAt(i) != b.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("at");
        wordDictionary.addWord("and");
        wordDictionary.addWord("an");
        wordDictionary.addWord("add");
        System.out.println(wordDictionary.search("a"));
        System.out.println(wordDictionary.search(".at"));
        wordDictionary.addWord("bat");
        System.out.println(wordDictionary.search(".at"));
        wordDictionary.addWord(".at");
        wordDictionary.addWord("an.");
    }
}
