package com.cx.leecode.In202101;

import java.util.ArrayList;
import java.util.List;

public class LevelOrder2 {
    static class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        List<Node> newNodes = new ArrayList<>();
        newNodes.add(root);
        levelOrder(newNodes, res);
        return res;
    }

    public void levelOrder(List<Node> nodes, List<List<Integer>> res) {
        if (nodes.isEmpty()) {
            return;
        }
        List<Node> newNodes = new ArrayList<>();
        List<Integer> item = new ArrayList<>();
        for (Node node : nodes) {
            item.add(node.val);
            if (node.children != null) {
                newNodes.addAll(node.children);
            }
        }
        res.add(item);
        levelOrder(newNodes, res);
    }
}
