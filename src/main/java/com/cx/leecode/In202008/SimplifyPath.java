package com.cx.leecode.In202008;

import java.util.LinkedList;
import java.util.List;

public class SimplifyPath {
    public String simplifyPath(String path) {
        int len = path.length();
        StringBuilder sb = new StringBuilder(len);
        LinkedList<String> stack = new LinkedList<>();
        for (int i = 0; i < len; i++) {
            char c = path.charAt(i);
            if (c == '/'){

                String s = sb.toString();
                if (sb.length() == 0 || s.equals(".")){
                    sb.setLength(0);
                    continue;
                }
                if ("..".equals(s)){
                    stack.pollLast();
                }else {
                    stack.add("/"  + sb.toString());
                }
                sb.setLength(0);
                continue;
            }
            sb.append(c);

            if (i == len - 1){
                String s = sb.toString();
                if (sb.length() == 0 || s.equals(".")){
                    sb.setLength(0);
                    continue;
                }
                if ("..".equals(s)) {
                    stack.pollLast();
                }else {
                    stack.add("/"  + sb.toString());
                }
            }
        }
        StringBuilder res = new StringBuilder(len);
        for (String s : stack) {
            res.append(s);
        }

        if (res.length() == 0){
            return "/";
        }
        return res.toString();
    }

    public static void main(String[] args) {
        SimplifyPath simplifyPath = new SimplifyPath();
        String s = simplifyPath.simplifyPath("/home/");
         s = simplifyPath.simplifyPath("/...");
        System.out.println(s);
    }
}
