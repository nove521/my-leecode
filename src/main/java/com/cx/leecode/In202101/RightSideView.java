package com.cx.leecode.In202101;

import java.util.ArrayList;
import java.util.List;

public class RightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        List<TreeNode> nodes = new ArrayList<>();
        nodes.add(root);
        rightSideView(nodes, res);
        return res;
    }

    private void rightSideView(List<TreeNode> nodes, List<Integer> res) {
        if (nodes.isEmpty()){
            return;
        }
        List<TreeNode> newNodes = new ArrayList<>();
        int size = nodes.size();
        for (int i = 0; i < size; i++) {
            TreeNode node = nodes.get(i);
            if (i == size - 1) {
                res.add(node.val);
            }
            if (node.left != null) {
                newNodes.add(node.left);
            }
            if (node.right != null) {
                newNodes.add(node.right);
            }
        }
        rightSideView(newNodes, res);
    }


    // 很骚
    List<Integer> res = new ArrayList<>();
    public List<Integer> rightSideView2(TreeNode root) {
        dfs(root,0);
        return res;
    }
    private void dfs(TreeNode root, int depth){
        if(root == null){
            return;
        }
        if(depth == res.size()){
            res.add(root.val);
        }
        dfs(root.right,depth+1);
        dfs(root.left,depth+1);

    }
}
