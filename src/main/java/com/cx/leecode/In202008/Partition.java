package com.cx.leecode.In202008;


public class Partition {
    static public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode partition(ListNode head, int x) {
        ListNode node = head;
        ListNode newNode = new ListNode(0);
        ListNode res = newNode;
        ListNode bigNode = new ListNode(0);
        ListNode headBigNode = bigNode;
        while (node != null){

            if (node.val < x){
                newNode.next = new ListNode(node.val);
                newNode = newNode.next;
            }else {
                bigNode.next = new ListNode(node.val);
                bigNode = bigNode.next;
            }

            node = node.next;
        }
        newNode.next = headBigNode.next;

        return res.next;
    }

    public static void main(String[] args) {
        int []nums = new int[]{1,4,3,2,5,2};
        ListNode head = new ListNode(0);
        ListNode star = head;
        for (int i = 0; i < nums.length; i++) {
            ListNode node = new ListNode(nums[i]);
            head.next = node;
            head = node;
        }

        Partition partition = new Partition();
        ListNode partition1 = partition.partition(star.next, 3);
        System.out.println(partition1);
    }
}
