package com.cx.leecode.In202005;

import java.util.Objects;

/**
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 *
 * 示例：
 *
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 *
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：
 *
 * 给定的 n 保证是有效的。
 *
 * 进阶：
 *
 * 你能尝试使用一趟扫描实现吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RemoveNthFromEnd {

    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {

        int lastCount = 0;
        ListNode node = head;
        ListNode resultNode = node;
        while (Objects.nonNull(node)){
            lastCount++;
            if (lastCount > n + 1 ){
                resultNode = resultNode.next;
            }
            node = node.next;
        }

        if (lastCount == 1){
            return null;
        }
        if (lastCount == n)
            return head.next;

        if (n == 1){
            resultNode.next = null;
        }else {
            resultNode.next = resultNode.next.next;
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode nodes = head;
        for (int i = 2; i <= 10; i++) {
            ListNode node = new ListNode(i);
            nodes.next = node;
            nodes = node;
        }
        RemoveNthFromEnd fromEnd = new RemoveNthFromEnd();
        ListNode listNode = fromEnd.removeNthFromEnd(head, 2);

        while (Objects.nonNull(listNode)){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}
