package com.cx.leecode.In202007;

public class IsMatch {
    public boolean isMatch(String s, String p) {
        int len = s.length();
        int lenP = p.length();
        int[][] map = new int[lenP + 1][len + 1];
        map[0][0] = 1;

        for (int i = 1; i <= lenP; i++) {
            char c = p.charAt(i - 1);
            for (int j = 0; j <= len; j++) {
                char cc = (j == 0 ? 0 : s.charAt(j - 1));

                if (c == '*' && (map[i - 1][j] == 1 || (j - 1 >= 0 && map[i - 1][j - 1] == 1))) {
                    while (j <= len)
                        map[i][j++] = 1;
                }
                if (c == '?' && j - 1 >= 0 && map[i - 1][j - 1] == 1) {
                    map[i][j] = 1;
                }
                if (c == cc && j - 1 >= 0 && map[i - 1][j - 1] == 1) {
                    map[i][j] = 1;
                }
            }
        }
        return map[lenP][len] == 1;
    }

    public static void main(String[] args) {
        IsMatch isMatch = new IsMatch();
        boolean acdcb2 = isMatch.isMatch("", "?");
        System.out.println(acdcb2);
    }
}
