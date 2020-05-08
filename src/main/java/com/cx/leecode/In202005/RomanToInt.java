package com.cx.leecode.In202005;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class RomanToInt {

    static Map<String, Integer> map = new HashMap<>();

    static {
        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);
        map.put("IV", 4);
        map.put("IX", 9);
        map.put("XL", 40);
        map.put("XC", 90);
        map.put("CD", 400);
        map.put("CM", 900);
    }

    public int romanToInt(String s) {
        int len = s.length();
        int sum = 0;
        for (int i = len - 1; i >= 0; i--) {
            Integer x = map.get(String.valueOf(s.charAt(i)));
            if (Objects.nonNull(x)) {
                if (i - 1 >= 0) {
                    String key = s.substring(i - 1, i + 1);
                    Integer x2 = map.get(key);
                    if (Objects.nonNull(x2)) {
                        sum += x2;
                        i--;
                        continue;
                    }
                }
                sum += x;
            }
        }
        return sum;
    }

}
