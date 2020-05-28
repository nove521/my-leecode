package com.cx.leecode.In202005;

import java.util.Objects;

/**
 * 将两个升序链表合并为一个新的升序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 *
 * 示例：
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-two-sorted-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MergeTwoLists {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode head = new ListNode(0);
        ListNode cache = head;

        while (Objects.nonNull(l1) && Objects.nonNull(l2)){
            int val = l1.val;
            int val2 = l2.val;
            if (val < val2){
                cache.next = new ListNode(val);
                l1 = l1.next;
            }else {
                cache.next = new ListNode(val2);
                l2 = l2.next;
            }
            cache = cache.next;
        }

        while (Objects.nonNull(l1)){
            int val = l1.val;
            cache.next = new ListNode(val);
            cache = cache.next;
            l1 = l1.next;
        }
        while (Objects.nonNull(l2)){
            int val = l2.val;
            cache.next = new ListNode(val);
            cache = cache.next;
            l2 = l2.next;
        }

        return head.next;
    }

    public static void main(String[] args) {
        MergeTwoLists mergeTwoLists = new MergeTwoLists();

        ListNode node = new ListNode(1);
        ListNode h = node;
        node.next = new ListNode(2);
        node = node.next;
        node.next = new ListNode(4);
        node = node.next;

        ListNode node2 = new ListNode(1);
        ListNode h2 = node2;
        node2.next = new ListNode(2);
        node2 = node2.next;
        node2.next = new ListNode(4);
        node2 = node2.next;

        ListNode node1 = mergeTwoLists.mergeTwoLists(h, h2);
        System.out.println(node1);
    }
}
