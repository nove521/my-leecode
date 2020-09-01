package com.cx.leecode.In202008;

import java.util.LinkedList;

public class MinWindow {
    public String minWindow(String s, String t) {
        int len = s.length();
        int len2 = t.length();

        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        int[] tmap = new int[128];
        int[] smap = new int[128];
        for (int i = 0; i < len2; i++) {
            tmap[tChars[i]]++;
        }

        int l = 0;
        int r = 0;
        int count = 0;
        int minLens = len + 1;
        int minLeft = -1;

        while (l <= r) {
            if (count < len2 && r < len){
                char sChar = sChars[r];
                if (smap[sChar] < tmap[sChar]) {
                    count++;
                }
                smap[sChar]++;
                r++;
                continue;
            }

            if (count == len2) {
                if (minLens > (r - l)) {
                    minLens = r - l;
                    minLeft = l;
                }

                int a = smap[sChars[l]];
                int b = tmap[sChars[l]];
                if (a == b) {
                    count--;
                    smap[sChars[l]]--;
                } else if (a > b) {
                    smap[sChars[l]]--;
                }
            }
            l++;
            while (l < r && tmap[sChars[l]] == 0){
                l++;
            }
        }
        if (minLeft < 0){
            return "";
        }
        return s.substring(minLeft, minLeft + minLens);
    }

    public String minWindow2(String s, String t) {
        int len = s.length();
        int len2 = t.length();
        int[] map = new int[128];
        int[] smap = new int[128];
        boolean[] haveMap = new boolean[128];

        for (int i = 0; i < len2; i++) {
            map[t.charAt(i)]++;
            haveMap[t.charAt(i)] = true;
        }
        LinkedList<Integer> stack = new LinkedList<>();
        int count = 0;
        boolean flag = false;
        int minL = 0;
        int min = len + 1;
        int lens = 0;
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (map[c] > 0) {
                if (!flag) {
                    flag = true;
                }
                stack.add(i);
                count++;
                map[c]--;
            } else if (haveMap[c]) {
                stack.add(i);
                smap[c]++;
            }

            if (flag) {
                lens++;
            }
            if (count == len2) {
                Integer pop = stack.pop();
                map[s.charAt(pop)]++;
                if (min > lens) {
                    min = lens;
                    minL = pop;
                }

                if (stack.size() > 1) {
                    Integer peek = stack.peekFirst();
                    lens -= (peek - pop);
                } else {
                    lens--;
                }
                count--;
            }

        }
        return s.substring(minL, min);
    }

    public static void main(String[] args) {
        MinWindow minWindow = new MinWindow();
        System.out.println(minWindow.minWindow("ADOBECODEBANC", "BE"));
    }
}
