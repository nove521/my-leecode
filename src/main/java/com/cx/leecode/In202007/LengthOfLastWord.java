package com.cx.leecode.In202007;

import com.cx.leecode.In202005.LetterCombinations;

import java.util.List;

public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        int len = s.length();
        if (len == 0){
            return 0;
        }
        boolean flag = false;
        int end = 0;
        for (int i = len - 1; i >= 0 ; i--) {
            char c = s.charAt(i);
            if (!flag && c != ' '){
                flag = true;
                end = i;
            }
            if (flag && c == ' '){
                return end - i;
            }
            if (flag && i == 0){
                return end - i + 1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        LengthOfLastWord lengthOfLastWord = new LengthOfLastWord();
        int hello_world = lengthOfLastWord.lengthOfLastWord("hello ");
        System.out.println(hello_world);
    }
}
