package com.cx.leecode.In202006;

import java.util.Objects;

/**
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 *  
 *
 * 示例:
 *
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/swap-nodes-in-pairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SwapPairs {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode swapPairs(ListNode head) {
        ListNode h = new ListNode(0);
        h.next = head;
        ListNode node = h.next;
        ListNode preo = null;
        ListNode preo2 = h;
        int i = 1;
        while (Objects.nonNull(node)){
            if (i % 2 == 0){
                preo2.next = node;
                preo.next = node.next;
                node.next = preo;
                preo2 = preo;
                node = preo;
            }else {
                preo = node;
            }
            node = node.next;
            i++;
        }

        return h.next;
    }

    public static void main(String[] args) {
        SwapPairs.ListNode[] listNodes = new SwapPairs.ListNode[3];
        SwapPairs swapPairs = new SwapPairs();
        SwapPairs.ListNode node = new SwapPairs.ListNode(1);
        SwapPairs.ListNode head1 = node;
        node.next = new SwapPairs.ListNode(4);
        node = node.next;
        node.next = new SwapPairs.ListNode(5);
        node = node.next;
        node.next = new SwapPairs.ListNode(6);
        node = node.next;

        ListNode listNode = swapPairs.swapPairs(head1);
        System.out.println(listNode);
    }
}
