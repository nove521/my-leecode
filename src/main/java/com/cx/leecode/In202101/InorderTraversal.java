package com.cx.leecode.In202101;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树的根节点 root ，返回它的 中序 遍历。
 */
public class InorderTraversal {

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

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        List<Integer> left = inorderTraversal(root.left);
        res.addAll(left);
        res.add(root.val);
        List<Integer> right = inorderTraversal(root.right);
        res.addAll(right);
        return res;
    }

    public static void main(String[] args) {
        InorderTraversal inorderTraversal = new InorderTraversal();
        TreeNode node = new TreeNode(3);
        TreeNode treeNode = new TreeNode(2, node, null);
        node = new TreeNode(1, null, treeNode);
        System.out.println(inorderTraversal.inorderTraversal(node));
    }
}
