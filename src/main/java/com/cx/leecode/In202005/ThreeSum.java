package com.cx.leecode.In202005;

import java.util.*;

public class ThreeSum {
    public List<List<Integer>> threeSum2(int[] nums) {
        int len = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                Integer val = map.get(nums[j]);
                if (val != null ){
                    int a = val & ((1 << 16) - 1);
                    int b = val >> 16;
                    if (nums[i] == nums[a] || nums[i] == nums[b])
                        continue;
                }
                map.putIfAbsent(-nums[i] - nums[j], (i << 16) | j);
            }
        }
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 2; i < len; i++) {
            Integer val = map.get(nums[i]);
            if (val != null) {
                int a = val & ((1 << 16) - 1);
                int b = val >> 16;
                if (i != a && i != b) {
                    Integer [] ins = new Integer[]{nums[b], nums[a], nums[i]};
                    result.add(Arrays.asList(ins));
                    map.remove(nums[i]);
                }
            }
        }
        return result;
    }

    public List<List<Integer>> threeSum(int[] nums) {
        int len = nums.length;
        int left;
        int right;
        List<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < len; i++) {
            if (nums[i] > 0){
                break;
            }
            if(i > 0 && nums[i] == nums[i-1])
                continue; // 去重
            left = i + 1;
            right = len - 1;
            while (left < right){
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0){
                    lists.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    while (left < right && nums[left] == nums[left + 1]){
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]){
                        right--;
                    }
                    left ++ ;
                    right --;
                }
                if (sum < 0){
                    left++;
                }
                if (sum > 0){
                    right--;
                }
            }
        }
        return lists;
    }

    public static void main(String[] args) {
        ThreeSum threeSum = new ThreeSum();
        List<List<Integer>> lists = threeSum.threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        System.out.println(lists);
        lists = threeSum.threeSum(new int[]{-1, 0, 1});
        System.out.println(lists);

        lists = threeSum.threeSum(new int[]{0, 0, 0,0});
        System.out.println(lists);

        lists = threeSum.threeSum(new int[]{-1,0,1,0});
        System.out.println(lists);

        lists = threeSum.threeSum(new int[]{3,0,-2,-1,1,2});
        System.out.println(lists);

        lists = threeSum.threeSum(new int[]{-4,-2,1,-5,-4,-4,4,-2,0,4,0,-2,3,1,-5,0});
        System.out.println(lists);
    }
}
