package com.cx.leecode.In202101;

import java.util.HashMap;
import java.util.Map;

public class BuildTree {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inoIndex = new HashMap<>();
        int len = inorder.length;
        int len2 = preorder.length;
        for (int i = 0; i < len; i++) {
            inoIndex.put(inorder[i], i);
        }
        return buildTree(preorder, 0, len2 - 1, inorder, 0, len - 1, inoIndex);
    }

    private TreeNode buildTree(int[] preorder, int preL, int perR, int[] inorder, int inoL, int inoR, Map<Integer, Integer> inoIndex) {
        if (preL > perR || inoL > inoR ) return null;

        int val = preorder[preL];
        TreeNode root = new TreeNode(val);
        Integer inoCenter = inoIndex.get(val);
//        int numL = inoCenter - inoL;

        root.left = buildTree(preorder, preL + 1, preL + inoCenter - inoL, inorder, inoL, inoCenter - 1, inoIndex);
        root.right = buildTree(preorder, preL + inoCenter - inoL + 1, perR, inorder, inoCenter + 1, inoR, inoIndex);
        return root;
    }


    public static void main(String[] args) {
        BuildTree buildTree = new BuildTree();
        int []x = new int[]{3,9,20,15,7};
        int []y = new int[]{9,3,15,20,7};
        TreeNode treeNode = buildTree.buildTree(x, y);
        System.out.println(treeNode);
    }
}
