package com.cx.leecode.In202101;

public class HasPathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        int val = root.val;
        if (val == sum && root.left == null && root.right == null) {
            return true;
        }
        boolean b = hasPathSum(root.left, sum - val);
        if (b) {
            return true;
        }
        return hasPathSum(root.right, sum - val);
    }
}
