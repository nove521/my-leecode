package com.cx.leecode.In202101;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LevelOrder {
    List<List<Integer>> res = new ArrayList<>();
    List<List<TreeNode>> res2 = new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null){
            return Collections.emptyList();
        }
        List<TreeNode> list = new ArrayList<>();
        List<Integer> resItem = new ArrayList<>();
        resItem.add(root.val);
        res.add(resItem);
        list.add(root);
        bin(list);
        return res;
    }

    private void bin(List<TreeNode> nodes) {
        if (nodes.isEmpty()) {
            return;
        }
        List<TreeNode> h = new ArrayList<>();
        List<Integer> resItem = new ArrayList<>();
        for (TreeNode node : nodes) {
            if (node.left != null){
                h.add(node.left);
                resItem.add(node.left.val);
            }
            if (node.right != null){
                h.add(node.right);
                resItem.add(node.right.val);
            }
        }
        res2.add(h);
        if (!resItem.isEmpty()){
            res.add(resItem);
        }
        bin(h);
    }
}
