package com.cx.leecode.In202101;

public class MaxDepth {
    public int maxDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        int a = maxDepth(root.left) + 1;
        int b = maxDepth(root.right) + 1;
        return Math.max(a,b);
    }
}
