package com.cx.leecode.In202006;

import java.util.Arrays;
import java.util.Objects;
import java.util.function.IntFunction;

/**
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-k-sorted-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MergeKLists {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {

        int len = lists.length;
        if (len == 0) {
            return null;
        }
        if (len == 1) {
            return lists[0];
        }
        if (len == 2) {
            ListNode node1 = lists[0];
            ListNode node2 = lists[1];
            ListNode head = new ListNode(0);
            ListNode node = head;
            while (Objects.nonNull(node1) && Objects.nonNull(node2)) {
                if (node1.val > node2.val) {
                    node.next = new ListNode(node2.val);
                    node2 = node2.next;
                } else {
                    node.next = new ListNode(node1.val);
                    node1 = node1.next;
                }
                node = node.next;
            }

            while (Objects.nonNull(node1)) {
                node.next = new ListNode(node1.val);
                node1 = node1.next;
                node = node.next;
            }
            while (Objects.nonNull(node2)) {
                node.next = new ListNode(node2.val);
                node2 = node2.next;
                node = node.next;
            }

            return head.next;
        }

        int limit = len / 2;
        ListNode[] list1 = gn(lists, 0, limit);
        ListNode[] list2 = gn(lists, limit, len - limit);

        ListNode node1 = mergeKLists(list1);
        ListNode node2 = mergeKLists(list2);
        return mergeKLists(new ListNode[]{node1, node2});
    }

    private ListNode[] gn(ListNode[] lists, int offset, int limit) {
        ListNode[] listNodes = new ListNode[limit];
        int len = limit + offset;
        int index = 0;
        for (int i = offset; i < len; i++) {
            listNodes[index++] = lists[i];
        }
        return listNodes;
    }

    public static void main(String[] args) {
        ListNode[] listNodes = new ListNode[3];
        MergeKLists mergeKLists = new MergeKLists();
        MergeKLists.ListNode node = new MergeKLists.ListNode(1);
        MergeKLists.ListNode head1 = node;
        node.next = new MergeKLists.ListNode(4);
        node = node.next;
        node.next = new MergeKLists.ListNode(5);
        node = node.next;
        listNodes[0] = head1;

        node = new MergeKLists.ListNode(1);
        MergeKLists.ListNode head2 = node;
        node.next = new MergeKLists.ListNode(3);
        node = node.next;
        node.next = new MergeKLists.ListNode(4);
        node = node.next;
        listNodes[1] = head2;

        node = new MergeKLists.ListNode(2);
        MergeKLists.ListNode head3 = node;
        node.next = new MergeKLists.ListNode(6);
        node = node.next;
        listNodes[2] = head3;

        ListNode node1 = mergeKLists.mergeKLists(listNodes);
        System.out.println(node1);
    }

}
