package com.cx.leecode.In202101;

public class CountNodes {

    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int res;
        int left = computedDeep(root.left);
        int right = computedDeep(root.right);
        if (left == right) {
            res = countNodes(root.right) + (1 << left);
        } else {
            res = countNodes(root.left) + (1 << right);
        }
        return res;
    }

    private int computedDeep(TreeNode node) {
        int count = 0;
        while (node != null) {
            count++;
            node = node.left;
        }
        return count;
    }
}
