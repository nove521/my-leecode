package com.cx.leecode.In202101;

import java.util.Stack;

class BSTIterator {

    Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        bst(root);
    }


    private void bst(TreeNode node) {
        if (node != null) {
            stack.push(node);
            bst(node.left);
        }
    }

    public int next() {
        TreeNode pop = stack.pop();
        bst(pop.right);
        return pop.val;
    }

    public boolean hasNext() {
        return stack.size() > 0;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode node = new TreeNode(1);
        root.left = node;
        node = new TreeNode(1);
        root.right = node;
        node = new TreeNode(2);
        root.left.right = node;
        BSTIterator bstIterator = new BSTIterator(root);
        System.out.println(bstIterator.hasNext());
        System.out.println(bstIterator.next());
        System.out.println(bstIterator.hasNext());
        System.out.println(bstIterator.next());
    }
}