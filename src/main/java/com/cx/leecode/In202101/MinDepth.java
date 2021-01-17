package com.cx.leecode.In202101;

import java.util.concurrent.atomic.AtomicInteger;

public class MinDepth {

    private static AtomicInteger min = new AtomicInteger(Integer.MAX_VALUE);

    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        else if (root.left == null) return minDepth(root.right) + 1;
        else if (root.right == null) return minDepth(root.left) + 1;
        else return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }


    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(2);
        TreeNode root = treeNode;
        for (int i = 3; i <= 6; i++) {
            treeNode.right = new TreeNode(i);
            treeNode = treeNode.right;
        }
        MinDepth m = new MinDepth();
        System.out.println(m.minDepth(root));

        treeNode = new TreeNode(2);
        System.out.println(m.minDepth(treeNode));
    }
}
