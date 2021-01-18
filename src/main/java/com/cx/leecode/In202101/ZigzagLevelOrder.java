package com.cx.leecode.In202101;

import java.util.*;

public class ZigzagLevelOrder {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null){
            return Collections.emptyList();
        }
        LinkedList<TreeNode> list = new LinkedList<>();
        List<Integer> resItem = new ArrayList<>();
        resItem.add(root.val);
        res.add(resItem);
        list.add(root);
        bin(list, 2);
        return res;
    }

    private void bin(LinkedList<TreeNode> nodes, int x) {
        if (nodes.isEmpty()) {
            return;
        }
        LinkedList<TreeNode> h = new LinkedList<>();
        List<Integer> resItem = new ArrayList<>();

        if (x % 2 == 1){
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
        }else {
            int size = nodes.size();
            for (int i = size - 1; i >= 0 ; i--) {
                TreeNode node = nodes.get(i);
                if (node.right != null){
                    h.addFirst(node.right);
                    resItem.add(node.right.val);
                }
                if (node.left != null){
                    h.addFirst(node.left);
                    resItem.add(node.left.val);
                }
            }
        }
        if (!resItem.isEmpty()){
            res.add(resItem);
        }
        bin(h,x+1);
    }

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        ListIterator<Integer> integerListIterator = linkedList.listIterator(linkedList.size());
        while (integerListIterator.hasPrevious()){
            System.out.println(integerListIterator.previous());
        }
    }
}
