package com.cx.leecode.In202101;

public class InvertTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null){
            return null;
        }
        TreeNode res = new TreeNode();
        invertTree2(root, res);
        return res;
    }

    private void invertTree2(TreeNode root, TreeNode res) {
        if (root == null) {
            return;
        }
        if (root.right!=null){
            res.left = new TreeNode();
        }
        invertTree2(root.right, res.left);
        res.val = root.val;
        if (root.left!=null){
            res.right = new TreeNode();
        }
        invertTree2(root.left, res.right);
    }
}
