package com.cx.leecode.In202101;

public class Flatten {
    public void flatten(TreeNode root) {
        if (root == null){
            return;
        }
        flatten2(root);
    }

    public TreeNode flatten2(TreeNode root) {
        TreeNode right = root.right;
        TreeNode lLast = null;
        if (root.left != null){
            root.right = root.left;
            lLast = flatten2(root.left);
            lLast.right = right;
            root.left = null;
        }
        if (right == null && lLast!= null){
            return lLast;
        }
        if (right == null){
            return root;
        }
        return flatten2(right);
    }

    public static void main(String[] args) {
        Flatten flatten = new Flatten();

        TreeNode root = new TreeNode(1);
        TreeNode node = new TreeNode(2);
        root.left = node;
        node = new TreeNode(3);
        root.left.left = node;
        flatten.flatten(root);
        System.out.println(root);
    }
}
