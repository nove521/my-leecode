package com.cx.leecode.In202101;

public class RecoverTree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    void recoverTree(TreeNode root) {
        if (root == null) {
            return;
        }
        isValidBST2(root);
        swap(x,y);
    }
    TreeNode pre;
    TreeNode x;
    TreeNode y;
    public void isValidBST2(TreeNode root) {
        if (root == null) {
            return;
        }
        isValidBST2(root.left);
        if (pre != null){
            if (pre.val > root.val){
                x = root;
                if (y == null){
                    y = pre;
                }
            }
        }
        pre = root;
        isValidBST2(root.right);
    }

    private void swap(TreeNode v1, TreeNode v2) {
        int x = v1.val;
        v1.val = v2.val;
        v2.val = x;
    }

}
