package com.cx.leecode.In202101;

public class MaxPathSum {

    int ans = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        ans = Integer.MIN_VALUE;
        oneSideMax(root);
        return ans;
    }

    private int oneSideMax(TreeNode root) {
        if (root == null)
            return 0;
        int lMax = Math.max(0, oneSideMax(root.left));
        int rMax = Math.max(0, oneSideMax(root.right));
        ans = Math.max(ans, lMax + rMax + root.val);
        return Math.max(lMax, rMax) + root.val;
    }
}
