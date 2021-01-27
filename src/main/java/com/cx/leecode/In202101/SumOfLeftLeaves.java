package com.cx.leecode.In202101;

public class SumOfLeftLeaves {
    public int sumOfLeftLeaves(TreeNode root) {
        return sumOfLeftLeaves(root, false);
    }

    public int sumOfLeftLeaves(TreeNode root, boolean lor) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null && lor) {
            return root.val;
        }
        int left = sumOfLeftLeaves(root.left, true);
        int right = sumOfLeftLeaves(root.right, false);
        return left + right;
    }
}
