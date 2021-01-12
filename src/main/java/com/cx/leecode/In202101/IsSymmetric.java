package com.cx.leecode.In202101;

public class IsSymmetric {
    public boolean isSymmetric(TreeNode root) {
        if (root == null){
            return true;
        }
        return leftRight(root.left,root.right);
    }

    private boolean leftRight(TreeNode left,TreeNode right){
        if (left == null && right == null){
            return true;
        }
        if (left == null || right == null){
            return false;
        }
        if (left.val != right.val){
            return false;
        }
        boolean b = leftRight(left.left, right.right);
        if (!b){
            return false;
        }
        return leftRight(left.right,right.left);
    }

}
