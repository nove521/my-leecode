package com.cx.leecode.In202101;

import java.util.HashMap;
import java.util.Map;

public class BuildTreeL {


    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int len1 = inorder.length;
        int len2 = postorder.length;
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < len1; i++) {
            indexMap.put(inorder[i], i);
        }
        return buildTree(inorder, 0, len1 - 1, postorder, 0, len2 - 1, indexMap);
    }

    private TreeNode buildTree(int[] inorder, int inoL, int inoR, int[] postorder, int postL, int postR, Map<Integer, Integer> indexMap) {
        if (inoL > inoR || postL > postR) {
            return null;
        }
        int rootVal = postorder[postR];
        TreeNode root = new TreeNode(rootVal);
        Integer rootIndex = indexMap.get(rootVal);
        int leftNumber = rootIndex - inoL;
        root.left = buildTree(inorder, inoL, rootIndex - 1, postorder, postL, postL + leftNumber - 1, indexMap);
        root.right = buildTree(inorder, rootIndex + 1, inoR, postorder, postL + leftNumber, postR - 1 , indexMap);
        return root;
    }

    public static void main(String[] args) {
        int [] x1 = new int[]{9,3,15,20,7};
        int [] x2 = new int[]{9,15,7,20,3};
        BuildTreeL b = new BuildTreeL();
        b.buildTree(x1,x2);
    }
}
