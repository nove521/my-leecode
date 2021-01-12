package com.cx.leecode.In202101;

public class IsSameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null){
            return true;
        }
        if (p == null || q == null){
            return false;
        }
        boolean a = isSameTree(p.left, q.left);
        if (!a){
            return false;
        }
        if (p.val != q.val){
            return false;
        }
        return isSameTree(q.right, p.right);
    }
}
