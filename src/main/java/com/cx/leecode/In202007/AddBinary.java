package com.cx.leecode.In202007;

public class AddBinary {
    public String addBinary(String a, String b) {
        int len = a.length();
        int len2 = b.length();

        int i = len - 1;
        int j = len2 - 1;
        StringBuilder res = new StringBuilder();
        int ci = 0;
        while (i >= 0 && j >= 0) {
            int ai = a.charAt(i--) - '0';
            int bi = b.charAt(j--) - '0';
            int ri = ai + bi + ci;
            if (ci == 1) ci = 0;
            if (ri > 1){
                ci = 1;
            }
            int xx = ri & 0b1;
            res.append(xx == 1 ? '1' : '0');
        }

        while (i >= 0) {
            int ai = a.charAt(i--) - '0';
            int ri = ai + ci;
            if (ci == 1) ci = 0;
            if (ri > 1){
                ci = 1;
            }
            int xx = ri & 0b1;
            res.append(xx == 1 ? '1' : '0');
        }
        while (j >= 0) {
            int ai = b.charAt(j--) - '0';
            int ri = ai + ci;
            if (ci == 1) ci = 0;
            if (ri > 1){
                ci = 1;
            }
            int xx = ri & 0b1;
            res.append(xx == 1 ? '1' : '0');
        }

        if (ci == 1)
            res.append('1');

        return res.reverse().toString();
    }

    public static void main(String[] args) {
        AddBinary addBinary = new AddBinary();
        System.out.println(addBinary.addBinary("11", "1"));
    }
}
