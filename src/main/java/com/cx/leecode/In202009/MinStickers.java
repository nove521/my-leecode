package com.cx.leecode.In202009;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MinStickers {
//    public int minStickers(String[] stickers, String target) {
//        int stickersLen = stickers.length, targetLen = target.length();
//        int[] dp = new int[1 << targetLen];
//
//        char[] word = target.toCharArray();
//        Set<Integer>[] sets = new Set[26];
//        for (int i = 0; i < sets.length; i++)
//            sets[i] = new HashSet<Integer>();
//
//        int[][] sts = new int[stickersLen][26];
//        for (int i = 0; i < stickersLen; i++) {
//            for (char c : stickers[i].toCharArray()) {
//                sts[i][c - 'a']++;
//                sets[c - 'a'].add(i);
//            }
//        }
//
//        // 如果stickers中不存在需要的字符，直接-1
//        for (char c : word)
//            if (sets[c - 'a'].size() == 0) return -1;
//
//        // dp[i]表示拼凑字符串s时，所需要的贴纸数
//        // target的长度不会超过15，因此，可以用状态压缩来解决
//        // 与普通的动态规划区别是，不知道下一个状态是什么
//        // 但未操作过的target，其状态位都是0000，其下一个状态可能是1000、0100、0011等，对应的int肯定比0000大，所以，只要不停地将状态i的int值+1，
//        // 并判断dp[i]是否为0，就可以知道，dp[i]是不是可能的状态。
//        // 从状态0开始
//        // 从0开始，每一个循环代表 target 的状态。
//        for (int i = 0; i < dp.length - 1; i++) {
//            // 不是可能存在的状态
//            if (i != 0 && dp[i] == 0) continue;
//            int startIndex = 0;
//            // 找到第一个尚未拼凑的字符的索引
//            for (; startIndex < targetLen; startIndex++)
//                if (((1 << startIndex) & i) == 0) break;
//            for (int idx : sets[word[startIndex] - 'a']) {
//                int next = i;
//                int[] curSticker = Arrays.copyOf(sts[idx], 26);
//                for (int j = startIndex; j < targetLen; j++) {
//                    if (((1 << j) & next) == 0 && curSticker[word[j] - 'a'] > 0) {
//                        curSticker[word[j] - 'a']--;
//                        next = next | (1 << j);
//                    }
//                }
//                dp[next] = dp[next] == 0 ? dp[i] + 1 : Math.min(dp[next], dp[i] + 1);
//            }
//        }
//        return dp[dp.length - 1];
//    }

    public int minStickers(String[] stickers, String target) {

        int len = target.length();
        int tieLen = stickers.length;
        int dpLen = 1 << len;
        int[] dp = new int[dpLen];

        final char[] words = target.toCharArray();

        int[][] sits = new int[tieLen][26];
        Set<Integer>[] sets = new Set[26];
        for (int i = 0; i < sets.length; i++)
            sets[i] = new HashSet<>();

        for (int i = 0; i < tieLen ; i++) {
            String stic = stickers[i];
            final char[] chars = stic.toCharArray();
            for (char aChar : chars) {
                sits[i][aChar - 'a']++;
                sets[aChar - 'a'].add(i);
            }
        }

        for (char c : words)
            if (sets[c - 'a'].size() == 0) return -1;

        for (int i = 0; i < dpLen - 1; i++) {
            if (i != 0 && dp[i] == 0) continue;

            int start = 0;
            for (; start < len; start++)
                if (((1 << start) & i) == 0)
                    break;
            final Set<Integer> set = sets[words[start] - 'a'];
            for (Integer idx : set) {

                int next = i;
                final int[] ints = Arrays.copyOf(sits[idx], 26);

                for (int starIndex = start; starIndex < len; starIndex++) {

                    final char word = words[starIndex];
                    if (((1 << starIndex) & next) == 0 && ints[word - 'a'] > 0) {
                        ints[word - 'a']--;
                        next = next | (1 << starIndex);
                    }

                }
                dp[next] = dp[next] == 0 ? dp[i] + 1 : Math.min(dp[next], dp[i] + 1);

            }

        }

        return dp[dp.length - 1];

    }

    public static void main(String[] args) {
        MinStickers minStickers = new MinStickers();
        String[] nums = new String[]{"with", "example", "science"};
        System.out.println(minStickers.minStickers(nums, "thehat"));
    }
}
