package com.cx.leecode.In202101;

public class SumNumbers {

    int ans = 0;

    public int sumNumbers(TreeNode root) {
        sumNumbers(root,0);
        return ans;
    }

    private void sumNumbers(TreeNode root, int sum) {
        if (root == null){
            return;
        }
        int val = root.val + sum * 10;
        if (root.left == null && root.right == null){
            ans += val;
            return;
        }
        sumNumbers(root.left,val);
        sumNumbers(root.right,val);
    }
}
