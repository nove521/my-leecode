package com.cx.leecode.In202009;

import java.util.*;
import java.util.stream.Collectors;

public class ReadBinaryWatch {

    static int[] nums = new int[]{1, 2, 4, 8, 1, 2, 4, 8, 16, 32};

    public List<String> readBinaryWatch(int num) {
        List<List<Integer>> res = new ArrayList<>();
        pp(num, 0, res, new LinkedList<>());
        List<String> ress = new ArrayList<>();
        for (List<Integer> ints : res) {
            StringBuilder sb = new StringBuilder();
            int a = 0;
            int b = 0;
            for (Integer anInt : ints) {
                if (anInt < 4) {
                    a += nums[anInt];
                } else {
                    b += nums[anInt];
                }
            }
            if (a > 11 || b > 59) {
                continue;
            }
            sb.append(a).append(":");
            if (b < 10) {
                sb.append("0").append(b);
            } else {
                sb.append(b);
            }
            ress.add(sb.toString());
        }
        return ress;
    }

    private void pp(int num, int start, List<List<Integer>> res, LinkedList<Integer> item) {
        if (num == 0) {
            res.add(new ArrayList<>(item));
            return;
        }
        for (int i = start; i < 10; i++) {
            item.addLast(i);
            pp(num - 1, i + 1, res, item);
            item.removeLast();
        }
    }

    public static void main(String[] args) {
        ReadBinaryWatch readBinaryWatch = new ReadBinaryWatch();
        final List<String> strings = readBinaryWatch.readBinaryWatch(2);
        Collections.sort(strings);
        System.out.println(strings);

        String[] n = {"0:03", "0:05", "0:06", "0:09", "0:10", "0:12", "0:17", "0:18", "0:20", "0:24", "0:33", "0:34", "0:36", "0:40", "0:48", "1:01", "1:02", "1:04", "1:08", "1:16", "1:32", "2:01", "2:02", "2:04", "2:08", "2:16", "2:32", "3:00", "4:01", "4:02", "4:04", "4:08", "4:16", "4:32", "5:00", "6:00", "8:01", "8:02", "8:04", "8:08", "8:16", "8:32", "9:00", "10:00"};
        Arrays.sort(n);
        System.out.println(Arrays.toString(n));
    }
}
