package com.cx.leecode.In202008;

import java.util.ArrayList;
import java.util.List;

public class RestoreIpAddresses {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        if (s.length() < 4 || s.length() > 12) {
            return res;
        }
        pp(res, new StringBuffer(), s, 0, 0, s.length());
        return res;
    }

    private void pp(List<String> res, StringBuffer sb, String s, int start, int cen, int len) {
        if (cen == 4 || start >= len) {
            if (sb.length() - 3 == len)
                res.add(sb.toString());
            return;
        }
        StringBuilder ipItem = new StringBuilder(3);
        int end = (start + 2) < len ? start + 2 : len - 1;
        for (int i = start; i <= end; i++) {
            char c = s.charAt(i);
            ipItem.append(c);
            if (Integer.parseInt(ipItem.toString()) > 255){
                return;
            }
            if (cen<3 && (len - i) < (4- cen) || (len - i) > (3 * (4 - cen))){
                return;
            }
            int l = sb.length();
            sb.append(ipItem.toString());
            if (cen < 3){
                sb.append('.');
            }
            pp(res,sb,s,i + 1,cen + 1,len);
            if (c == '0' && i == start){
                return;
            }
            sb.delete(l,sb.length());
        }
    }

    public static void main(String[] args) {
        RestoreIpAddresses restoreIpAddresses = new RestoreIpAddresses();
        System.out.println(restoreIpAddresses.restoreIpAddresses("101023"));
    }
}
