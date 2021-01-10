package com.cx.leecode.In202101;

public class IsValidBST {

    public static class TreeNode {
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

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isValidBST2(root, -1, -1);
    }

    public boolean isValidBST2(TreeNode root, int min, int max) {
        if (root == null) {
            return true;
        }
        int val = root.val;
        if (root.left != null) {
            int leftV = root.left.val;
            if (leftV >= val || (min != -1 && leftV <= min)) {
                return false;
            }
        }
        if (root.right != null) {
            int rightV = root.right.val;
            if (val >= rightV || (max != -1 && rightV >= max)) {
                return false;
            }
        }
        boolean validBST = isValidBST2(root.left, min, root.val);
        boolean validBST1 = isValidBST2(root.right, root.val, max);
        return validBST && validBST1;
    }

    public static void main(String[] args) {
        IsValidBST isValidBST = new IsValidBST();
        TreeNode treeNode = new TreeNode(3);
        TreeNode node = new TreeNode(1);
        treeNode.left = node;
        node = new TreeNode(5);
        treeNode.right = node;
        System.out.println(isValidBST.isValidBST(treeNode));

    }

}
