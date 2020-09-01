package com.cx.leecode.In202008;

public class DeleteDuplicates2 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode deleteDuplicates2(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode head2 = new ListNode(0);
        head2.next = head;
        ListNode node = head;
        boolean flag = false;
        ListNode per = node;
        while (node.next != null) {
            node = node.next;
            if (node.val == per.val) {
                flag = true;
                continue;
            }

            if (flag) {
                per.next = node;
                flag = false;
            }
            per = node;
        }
        if (flag) {
            per.next = null;
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

        DeleteDuplicates2 deleteDuplicates = new DeleteDuplicates2();
        ListNode listNode = deleteDuplicates.deleteDuplicates2(star.next);

        System.out.println(listNode);
    }
}
