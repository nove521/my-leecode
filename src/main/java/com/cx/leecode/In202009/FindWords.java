package com.cx.leecode.In202009;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FindWords {
    boolean [][]map;
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();

        if (board.length == 0){
            return res;
        }


        List<List<Integer>>[] keyList = new ArrayList[26];

        int len = board.length;
        for (int i = 0; i < len; i++) {
            int len2 = board[i].length;
            for (int j = 0; j < len2; j++) {
                char b = board[i][j];
                final List<List<Integer>> integers = keyList[b - 'a'];
                if (integers != null){
                    final ArrayList<Integer> objects = new ArrayList<>();
                    objects.add(i);
                    objects.add(j);
                    integers.add(objects);
                }else {
                    List<List<Integer>> list = new ArrayList<>();
                    final ArrayList<Integer> objects = new ArrayList<>();
                    objects.add(i);
                    objects.add(j);
                    list.add(objects);
                    keyList[b - 'a'] = list;
                }
            }
        }

        map = new boolean[board.length][board[0].length];

        for (String word : words) {
            final char c = word.charAt(0);
            final List<List<Integer>> lists = keyList[c - 'a'];
            if (Objects.nonNull(lists)){
                for (List<Integer> list : lists) {
                    if (pp(board,list.get(0),list.get(1),word,0)){
                        res.add(word);
                        break;
                    }
                }
            }
        }
        return res;

    }

    private boolean pp(char[][]board,int x,int y,String word,int start){
        if (board[x][y] != word.charAt(start)){
            return false;
        }
        if (start == word.length() - 1){
            return true;
        }
        map[x][y] = true;
        boolean result = false;
        if (x + 1 < board.length && !map[x + 1][y]){
            result = pp(board,x + 1,y,word,start + 1);
        }
        if (!result && x - 1 >= 0 && !map[x - 1][y]){
            result = pp(board,x - 1,y,word,start + 1);
        }
        if (!result && y + 1 < board[0].length && !map[x][y + 1]){
            result = pp(board,x,y + 1,word,start + 1);
        }
        if (!result && y - 1 >= 0 && !map[x][y - 1]){
            result = pp(board,x,y - 1,word,start + 1);
        }
        map[x][y] = false;
        return result;
    }

    public static void main(String[] args) {
        FindWords findWords = new FindWords();
//        char[][]bords = new char[][]{
//                {'o','a','a','n'},
//                {'e','t','a','e'},
//                {'i','h','k','r'},
//                {'i','f','l','v'}
//        };
        char[][]bords = new char[][]{
                {'a','b','c'},
                {'a','e','d'},
                {'a','f','g'},
        };
        String[]words = new String[]{"eaabcdgfa"};
        System.out.println(findWords.findWords(bords, words));
    }
}
