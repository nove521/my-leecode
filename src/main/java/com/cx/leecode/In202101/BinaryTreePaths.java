package com.cx.leecode.In202101;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null)
            return res;
        binaryTreePaths(root, res, new StringBuilder());
        return res;
    }

    private void binaryTreePaths(TreeNode root, List<String> res, StringBuilder sb) {
        if (root == null) {
            return;
        }
        int length = sb.length();
        sb.append(root.val).append("->");
        if (root.left == null && root.right == null) {
            res.add(sb.substring(0, sb.length() - 2));
            sb.delete(length, sb.length());
            return;
        }
        binaryTreePaths(root.left, res, sb);
        binaryTreePaths(root.right, res, sb);
        sb.delete(length, sb.length());
    }
}
