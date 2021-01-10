package com.cx.leecode.In202101;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个无重复元素的有序整数数组 nums 。
 * <p>
 * 返回 恰好覆盖数组中所有数字 的 最小有序 区间范围列表。也就是说，nums 的每个元素都恰好被某个区间范围所覆盖，并且不存在属于某个范围但不属于 nums 的数字 x 。
 * <p>
 * 列表中的每个区间范围 [a,b] 应该按如下格式输出：
 * <p>
 * "a->b" ，如果 a != b
 * "a" ，如果 a == b
 *  
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/summary-ranges
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        int len = nums.length;
        if (len == 0) {
            return res;
        }
        StringBuilder sb = new StringBuilder();
        int r = nums[0], l = nums[0];

        for (int i = 1; i < len; i++) {
            if (nums[i] == nums[i - 1] + 1) {
                r++;
            } else {
                sb.append(l);
                if (r != l) {
                    sb.append("->").append(r);
                }
                res.add(sb.toString());
                sb.delete(0, sb.length());
                l = nums[i];
                r = l;
            }
        }
        sb.append(l);
        if (r != l)
            sb.append("->").append(r);
        res.add(sb.toString());

        return res;
    }

    public static void main(String[] args) {
        SummaryRanges summaryRanges = new SummaryRanges();
        int[] arr = new int[]{0, 1, 2, 4, 5, 7};
        System.out.println(summaryRanges.summaryRanges(arr));
        arr = new int[]{0, 2, 3, 4, 6, 8, 9};
        System.out.println(summaryRanges.summaryRanges(arr));
        arr = new int[]{0};
        System.out.println(summaryRanges.summaryRanges(arr));
    }
}
