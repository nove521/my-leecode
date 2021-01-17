package com.cx.leecode.In202101;

public class IsBalanced {
    private static boolean flag = true;
    public boolean isBalanced(TreeNode root) {
        flag = true;
        if (root == null) return true;
        balancedHeight(root);
        return flag;
    }

    public int balancedHeight(TreeNode root){
        if (root == null || !flag){
            return 0;
        }
        int l = balancedHeight(root.left) + 1;
        int r = balancedHeight(root.right) + 1;
        if (Math.abs(r - l) > 1){
            flag = false;
        }
        return Math.max(l,r);
    }
}
