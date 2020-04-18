package com.cx.leecode.In202004;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * <p>
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * <p>
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */


public class SolutionSum {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    static final int SYSTEM = 10;
    private boolean carry = false;

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
       carry = false;
        ListNode firstNode = null;
        ListNode nexttNode = null;

        while (Objects.nonNull(l1) && Objects.nonNull(l2)) {
            int sum = add(l1, l2);
            l1 = l1.next;
            l2 = l2.next;
            if (Objects.isNull(firstNode)) {
                nexttNode = firstNode = new ListNode(sum);
            } else {
                nexttNode.next = new ListNode(sum);
                nexttNode = nexttNode.next;
            }
        }

        // 分别判断，如果上一个循环没走完，得继续走完
        traversal(l1, firstNode, nexttNode);
        traversal(l2, firstNode, nexttNode);

        // 防止 需要进位，但链表都走完了得情况
        if (Objects.nonNull(nexttNode) && carry){
            nexttNode.next = new ListNode(1);
        }

        return firstNode;
    }


    /**
     * 采用 链表位数不够直接补0得策略。 省去麻烦得边界判断
     * @param l1 表1
     * @param l2 表2
     * @return 值
     */
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        carry = false;
        ListNode firstNode = null;
        ListNode nexttNode = null;

        while (Objects.nonNull(l1) || Objects.nonNull(l2)) {
            if (Objects.isNull(l1)){
                l1 = new ListNode(0);
            }
            if (Objects.isNull(l2)){
                l2 = new ListNode(0);
            }
            int sum = add(l1, l2);
            l1 = l1.next;
            l2 = l2.next;
            if (Objects.isNull(firstNode)) {
                nexttNode = firstNode = new ListNode(sum);
            } else {
                nexttNode.next = new ListNode(sum);
                nexttNode = nexttNode.next;
            }
        }

        // 防止 需要进位，但链表都走完了得情况
        if (carry){
            nexttNode.next = new ListNode(1);
        }

        return firstNode;
    }


    /**
     * 执行位数相加
     * @param l1 链表1
     * @param l2 聊表2
     * @return 返回链表相加值
     */
    private int add(ListNode l1, ListNode l2) {
        int carryInt = carry ? 1 : 0;
        int sum = l1.val + l2.val + carryInt;
        if (sum > 9) {
            carry = true;
            sum = sum - SYSTEM;
        } else {
            carry = false;
        }
        return sum;
    }

    /**
     * 遍历链表
     * @param l1 链表
     * @param firstNode 表头
     * @param nexttNode 表指针
     */
    private void traversal(ListNode l1, ListNode firstNode, ListNode nexttNode) {
        int sum = -1;
        while (Objects.nonNull(l1)) {
            sum = add(l1, new ListNode(0));
            if (Objects.isNull(firstNode)) {
                nexttNode = firstNode = new ListNode(sum);
            } else {
                nexttNode.next = new ListNode(sum);
                nexttNode = nexttNode.next;
            }
            l1 = l1.next;
        }

        // 用于走完循环，还是存在进位情况
        if (sum >= 0 && carry){
            nexttNode.next = new ListNode(1);
            carry = false;
        }
    }
}
