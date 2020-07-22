package com.cx.leecode.In202007;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 给出一个区间的集合，请合并所有重叠的区间。
 *
 * 示例 1:
 *
 * 输入: [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2:
 *
 * 输入: [[1,4],[4,5]]
 * 输出: [[1,5]]
 * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-intervals
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Merge {
    public int[][] merge2(int[][] intervals) {
        int len = intervals.length;
        if (len == 0)  return intervals;
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        List<Object> res = new ArrayList<>();
        res.add(intervals[0]);
        for (int i = 1; i < len; i++) {
            int [] preInterval = (int[]) res.get(res.size() - 1);
            int[] interval = intervals[i];
            if (interval[0] <= preInterval[1] && interval[1] >= preInterval[1]){
                preInterval[1] = interval[1];
            }else if (interval[1] > preInterval[1]){
                res.add(intervals[i]);
            }
        }
//
        int [][]resi = new int[res.size()][2];
        int lenR = res.size();
        for (int i = 0; i < lenR; i++) {
            resi[i] = (int[]) res.get(i);
        }
        return resi;
    }

    public int[][] merge(int[][] intervals) {
        int len = intervals.length;
        if (len == 0)  return intervals;

        quickSort(intervals,0,intervals.length-1);
        int[][] resss = new int[len][2];
        int k = 0;
        resss[k++] = intervals[0];
        for (int i = 1; i < len; i++) {
            int [] preInterval = resss[k-1];
            int[] interval = intervals[i];
            if (interval[0] <= preInterval[1] && interval[1] >= preInterval[1]){
                preInterval[1] = interval[1];
            }else if (interval[1] > preInterval[1]){
                resss[k++] = intervals[i];
            }
        }
        return Arrays.copyOf(resss,k);
    }

    public void quickSort(int[][] arr,int start,int end){
        if(start>=end){
            return;
        }
        int low = start,high=end;
        int[] mid = arr[low];
        while(low<high){
            while(low<high&&mid[0]<arr[high][0]){
                high--;
            }
            arr[low] = arr[high];
            while(low<high&&mid[0]>=arr[low][0]){
                low++;
            }
            arr[high] = arr[low];
        }
        arr[low] = mid;
        quickSort(arr,start,low-1);
        quickSort(arr,low+1,end);

    }

    public static void main(String[] args) {
        int [][]nums = new int[][]{{1,3},{2,6},{8,10},{15,18}};
        Merge merge = new Merge();
        int[][] merge1 = merge.merge(nums);
        System.out.println(Arrays.toString(merge1));;
    }
}
