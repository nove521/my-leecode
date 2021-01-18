package com.cx.leecode.In202101;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PathSum {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> item = new LinkedList<>();
        pathSum(root, sum, res, item);
        return res;
    }

    private void pathSum(TreeNode root, int sum, List<List<Integer>> res, LinkedList<Integer> item) {
        if (root == null) {
            return;
        }
        int val = root.val;
        item.addLast(val);
        if (val == sum && root.left == null && root.right == null) {
            res.add(new ArrayList<>(item));
            item.pollLast();
            return;
        }
        pathSum(root.left, sum - val, res, item);
        pathSum(root.right, sum - val, res, item);
        item.pollLast();
    }
}
