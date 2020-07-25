package com.cx.leecode.In202007;

public class RotateRight {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null){
            return null;
        }

        ListNode node = head;
        ListNode start = node;
        int begin = 0;
        int len = 1;
        while (node.next != null) {
            len++;
            node = node.next;
        }
        node = head;
        k = k % len;
        if (k == 0){
            return head;
        }

        while (node.next != null) {
            if (begin == 0) {
                start = node;
            }
            node = node.next;
            begin++;
            if (begin > k) {
                start = start.next;
            }
        }

        ListNode res = start.next;
        start.next = null;
        node.next = head;

        return res;

    }

    public static void main(String[] args) {
        RotateRight rotateRight = new RotateRight();

        ListNode listNode = new ListNode(1);
        ListNode head = listNode;
        listNode.next = new ListNode(2);
        listNode = listNode.next;
        listNode.next = new ListNode(3);
        listNode = listNode.next;
        listNode.next = new ListNode(4);
        listNode = listNode.next;
        listNode.next = new ListNode(5);
        listNode = listNode.next;

        ListNode listNode1 = rotateRight.rotateRight(head, 11);
        System.out.println(listNode1);
    }
}
