package com.cx.leecode.In202006;
import java.util.Objects;

/**
 *给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 *
 * k 是一个正整数，它的值小于或等于链表的长度。
 *
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 *
 *  
 *
 * 示例：
 *
 * 给你这个链表：1->2->3->4->5
 *
 * 当 k = 2 时，应当返回: 2->1->4->3->5
 *
 * 当 k = 3 时，应当返回: 3->2->1->4->5
 *
 *  
 *
 * 说明：
 *
 * 你的算法只能使用常数的额外空间。
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-nodes-in-k-group
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ReverseKGroup {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1){
            return head;
        }
        ListNode h = new ListNode(0);
        h.next = head;
        ListNode first = h;
        ListNode node = head;
        ListNode newHead = new ListNode(0);
        ListNode lastNode = null;
        int i = 1;
        while (Objects.nonNull(node)){
            ListNode newNode = new ListNode(node.val);
            if (i % k == 1){
                lastNode = newNode;
            }else {
                newNode.next = newHead.next;
            }
            newHead.next = newNode;
            if (i % k == 0) {
                first.next = newHead.next;
                lastNode.next = node.next;
                newHead.next = null;
                node = lastNode;
                first = node;
            }
            node = node.next;
            i++;
        }
        return h.next;
    }

    public static void main(String[] args) {
        ListNode[] listNodes = new ListNode[3];
        ReverseKGroup reverseKGroup = new ReverseKGroup();
        ListNode node = new ListNode(1);
        ListNode head1 = node;
        node.next = new ListNode(2);
        node = node.next;
        node.next = new ListNode(3);
        node = node.next;
        node.next = new ListNode(4);
        node = node.next;
        node.next = new ListNode(5);
        node = node.next;
        node.next = new ListNode(6);
        node = node.next;

        ListNode listNode = reverseKGroup.reverseKGroup(head1,2);
        System.out.println(listNode);
    }


    //[5,62,17,20,2,30,58,40,94,78,31,62,21,92,30,61,10,54,88,63,35,89,24,33,48,31,35,46,35,6,87,40,68,57,60,22,87,70,63,33,0,94,95,22,38,77,35,48,31,24,63,19,65,88,4,14,71,39,60,6,45,48,99,65,57,11,88,44,82,51,77,82,97,25,56,35,2,92,36,86,68,99,5,33,39,9,99,11,0,60,69,97,60,68,62,17,32,50,13,14,1,42,48,98,67,5,86,22,97,74,8,65,25,65,50,65,26,50,28,26,10,97,23,22,18,85,91,2,88,56,16,41,98,64,92,18,21,78,92,18,4,0,83,29,17,34,94,43,36,74,69,98,24,44,20,94,29,63,96,69,19,12,11,69,28,3,87,50,33,31,20,37,31,56,18,48,42,13,43,78,39,12,76,63,56,48,57,38,11]
    //74
}
