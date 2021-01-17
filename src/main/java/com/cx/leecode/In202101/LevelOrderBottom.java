package com.cx.leecode.In202101;

import java.util.*;

public class LevelOrderBottom {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        LinkedList<List<Integer>> res = new LinkedList<>();
        List<TreeNode> nodes = new ArrayList<>();
        nodes.add(root);
        fe(res, nodes);
        return res;
    }

    private void fe(LinkedList<List<Integer>> e, List<TreeNode> nodes) {
        if (nodes.isEmpty()) {
            return;
        }
        List<TreeNode> newNodes = new ArrayList<>();
        List<Integer> valNodes = new ArrayList<>();
        for (TreeNode node : nodes) {
            valNodes.add(node.val);
            if (Objects.nonNull(node.left)) {
                newNodes.add(node.left);
            }
            if (Objects.nonNull(node.right)) {
                newNodes.add(node.right);
            }
        }
        e.addFirst(valNodes);
        fe(e, newNodes);
    }
}
