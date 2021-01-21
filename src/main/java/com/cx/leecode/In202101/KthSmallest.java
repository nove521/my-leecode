package com.cx.leecode.In202101;

import com.sun.xml.internal.ws.addressing.WsaTubeHelperImpl;

import java.util.LinkedList;

public class KthSmallest {
    LinkedList<TreeNode> queue = new LinkedList<>();

    public int kthSmallest(TreeNode root, int k) {
        kthSmallest(root);
        TreeNode poll = queue.pollLast();
        if (poll == null) {
            return 0;
        }
        if (k == 1) {
            return poll.val;
        }
        return kthSmallest(poll.right, k - 1);
    }

    private void kthSmallest(TreeNode root) {
        while (root != null) {
            queue.add(root);
            root = root.left;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode node = new TreeNode(1);
        root.left = node;
        node = new TreeNode(4);
        root.right = node;
        node = new TreeNode(2);
        root.left.right = node;

        KthSmallest kthSmallest = new KthSmallest();
        kthSmallest.kthSmallest(root, 1);

    }
}
