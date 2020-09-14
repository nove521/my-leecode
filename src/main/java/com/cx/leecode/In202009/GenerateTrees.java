package com.cx.leecode.In202009;

import com.cx.leecode.utils.T;
import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;

public class GenerateTrees {
    static class TreeNode {
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

    static int count = 0;

    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new LinkedList<>();
        }
        return ppp(1,n);
    }

    public List<TreeNode> ppp(int start,int end){
        List<TreeNode> allTrees = new LinkedList<>();
        if (start > end) {
            allTrees.add(null);
            return allTrees;
        }

        List<TreeNode> leftTreeNodes;
        List<TreeNode> rightTreeNodes;
        for (int i = start; i <= end; i++) {
            leftTreeNodes = ppp(start,i-1);
            rightTreeNodes = ppp(i + 1,end);

            for (TreeNode leftTreeNode : leftTreeNodes) {
                for (TreeNode rightTreeNode : rightTreeNodes) {
                    TreeNode currNode = new TreeNode(i);
                    currNode.left = leftTreeNode;
                    currNode.right = rightTreeNode;
                    allTrees.add(currNode);
                }
            }
        }
        return allTrees;
    }

    public void pp(List<TreeNode> res, TreeNode first, TreeNode item, int n, int size, int left, int right) {
        if (left > right) {
            if (count == size) {
                final TreeNode treeNode = new TreeNode();
                copyTreeNode(first, treeNode);
                res.add(treeNode);
            }
            return;
        }
        TreeNode old = item;
        if (n <= 0) {
            item.left = new TreeNode();
            item = item.left;
        } else {
            item.right = new TreeNode();
            item = item.right;
        }

        for (int i = left; i <= right; i++) {
            item.val = i;
            count++;
            pp(res, first, item, 0, size, left, i - 1);
            if (left != right){
                pp(res, first, item, 1, size, i + 1, right);
            }
            count--;
        }
        old.left = null;
        old.right = null;
    }

    private void copyTreeNode(TreeNode first, TreeNode newTreeNode) {
        if (first != null) {
            newTreeNode.val = first.val;
            if (first.left != null) {
                newTreeNode.left = new TreeNode();
                copyTreeNode(first.left, newTreeNode.left);
            }
            if (first.right != null) {
                newTreeNode.right = new TreeNode();
                copyTreeNode(first.right, newTreeNode.right);
            }
        }
    }

    public static void main(String[] args) {
        GenerateTrees generateTrees = new GenerateTrees();
        final List<TreeNode> treeNodes = generateTrees.generateTrees(3);
        System.out.println(treeNodes);
    }
}
