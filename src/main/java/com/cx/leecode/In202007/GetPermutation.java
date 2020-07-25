package com.cx.leecode.In202007;

import java.util.LinkedList;

public class GetPermutation {
    public String getPermutation(int n, int k) {
        StringBuilder sb = new StringBuilder(n);
        LinkedList<Character> list = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            list.add((char) ('0' + i));
        }
        pp(n, k, list, sb);
        return sb.toString();
    }

    private void pp(int n, int k, LinkedList<Character> list, StringBuilder sb) {
        if (n == 1) {
            sb.append(list.get(0));
            return;
        }
        int s = 1;
        for (int i = 1; i < n; i++) {
            s = s * i;
        }
        int index = (k - 1) / s;
        sb.append(list.get(index));
        list.remove(index);
        if (k % s == 0){
            pp(n - 1, k - (index * s),list,sb);
        }else {
            pp(n - 1, k % s,list,sb);
        }
    }

    public static void main(String[] args) {
        GetPermutation getPermutation = new GetPermutation();
        System.out.println(getPermutation.getPermutation(3,6));
    }
}
