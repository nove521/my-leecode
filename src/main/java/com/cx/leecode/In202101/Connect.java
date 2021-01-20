package com.cx.leecode.In202101;

import java.util.ArrayList;
import java.util.List;

public class Connect {
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        List<Node> nodes = new ArrayList<>();
        nodes.add(root);
        connect(nodes);
        return root;
    }

    private void connect(List<Node> nodes) {
        if (nodes.isEmpty()) {
            return;
        }
        List<Node> newNodes = new ArrayList<>();
        int size = nodes.size();
        Node first = nodes.get(0);
        for (int i = 0; i < size; i++) {
            Node node = nodes.get(i);
            if (node.left != null) {
                newNodes.add(node.left);
            }
            if (node.right != null) {
                newNodes.add(node.right);
            }
            if (i > 0) {
                first.next = node;
                first = node;
            }
        }
        connect(newNodes);
    }
}
