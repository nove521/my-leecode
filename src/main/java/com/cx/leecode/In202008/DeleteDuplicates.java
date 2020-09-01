package com.cx.leecode.In202008;


public class DeleteDuplicates {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null){
            return head;
        }
        ListNode head2 = new ListNode(0);
        head2.next = head;
        ListNode pper = head2;
        ListNode per;
        ListNode node = head;
        boolean flag = false;
        while (node.next != null){
            per = node;
            node = node.next;

            if (node.val == per.val){
                flag = true;
                continue;
            }

            if (flag){
                pper.next =node;
                flag = false;
                continue;
            }
            pper = per;
        }
        if (flag){
            pper.next =null;
        }
        return head2.next;
    }

    public static void main(String[] args) {

        int []nums = new int[]{1,1,2,2,3,3};
        ListNode head = new ListNode(0);
        ListNode star = head;
        for (int i = 0; i < nums.length; i++) {
            ListNode node = new ListNode(nums[i]);
            head.next = node;
            head = node;
        }

        DeleteDuplicates deleteDuplicates = new DeleteDuplicates();
        ListNode listNode = deleteDuplicates.deleteDuplicates(star.next);

        System.out.println(listNode);
    }
}
