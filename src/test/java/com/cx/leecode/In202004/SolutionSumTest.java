package com.cx.leecode.In202004;

import com.cx.leecode.utils.TestTimeHolder;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Objects;

import static org.junit.Assert.*;

public class SolutionSumTest extends TestCase {

    @Before
    public void setUp() throws Exception {
        TestTimeHolder.newInstance();
    }

    @After
    public void tearDown() throws Exception {
        TestTimeHolder.end();
    }

    @Test
    public void testAddTwoNumbers() {
        SolutionSum solutionSum = new SolutionSum();
        int[] arr = new int[]{1, 2, 3, 4};
        int[] arr2 = new int[]{1, 2, 3, 4};
        SolutionSum.ListNode l1 = generateListNode(arr);
        SolutionSum.ListNode l2 = generateListNode(arr2);
        SolutionSum.ListNode reslut = solutionSum.addTwoNumbers(l1, l2);
        int reslutInt = printListNoe(reslut);
        assertEquals("链表相加结果不相等", 8642, reslutInt);
        System.out.println();

        arr = new int[]{1, 2, 3, 4, 5};
        arr2 = new int[]{1, 2, 3, 4};
        l1 = generateListNode(arr);
        l2 = generateListNode(arr2);
        reslut = solutionSum.addTwoNumbers(l1, l2);
        reslutInt = printListNoe(reslut);
        assertEquals("链表相加结果不相等", 58642, reslutInt);
        System.out.println();

        arr = new int[]{1, 2, 3, 4};
        arr2 = new int[]{1, 2, 3, 4, 5};
        l1 = generateListNode(arr);
        l2 = generateListNode(arr2);
        reslut = solutionSum.addTwoNumbers(l1, l2);
        reslutInt = printListNoe(reslut);
        assertEquals("链表相加结果不相等", 58642, reslutInt);
        System.out.println();

        arr = new int[]{9, 2, 3, 4};
        arr2 = new int[]{9, 2, 3, 4};
        l1 = generateListNode(arr);
        l2 = generateListNode(arr2);
        reslut = solutionSum.addTwoNumbers(l1, l2);
        reslutInt = printListNoe(reslut);
        assertEquals("链表相加结果不相等", 8658, reslutInt);
        System.out.println();

        arr = new int[]{9, 2, 3, 9};
        arr2 = new int[]{9, 2, 3, 4};
        l1 = generateListNode(arr);
        l2 = generateListNode(arr2);
        reslut = solutionSum.addTwoNumbers(l1, l2);
        reslutInt = printListNoe(reslut);
        assertEquals("链表相加结果不相等", 13658, reslutInt);
        System.out.println();

        arr = new int[]{9, 9, 9, 9};
        arr2 = new int[]{9};
        l1 = generateListNode(arr);
        l2 = generateListNode(arr2);
        reslut = solutionSum.addTwoNumbers(l1, l2);
        reslutInt = printListNoe(reslut);
        assertEquals("链表相加结果不相等", 10008, reslutInt);
        System.out.println();

        arr = new int[]{9, 9, 9, 9};
        arr2 = new int[]{1};
        l1 = generateListNode(arr);
        l2 = generateListNode(arr2);
        reslut = solutionSum.addTwoNumbers(l1, l2);
        reslutInt = printListNoe(reslut);
        assertEquals("链表相加结果不相等", 10000, reslutInt);
        System.out.println();

        arr = new int[]{1};
        arr2 = new int[]{9, 9, 9, 9};
        l1 = generateListNode(arr);
        l2 = generateListNode(arr2);
        reslut = solutionSum.addTwoNumbers(l1, l2);
        reslutInt = printListNoe(reslut);
        assertEquals("链表相加结果不相等", 10000, reslutInt);
        System.out.println();
    }

    /**
     * 生成 链表方法
     *
     * @param arr 数组
     * @return 链表
     */
    public SolutionSum.ListNode generateListNode(int[] arr) {
        SolutionSum solutionSum = new SolutionSum();
        SolutionSum.ListNode firstNode = null;
        SolutionSum.ListNode nextNode = null;
        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                firstNode = solutionSum.new ListNode(arr[i]);
                nextNode = firstNode;
            } else {
                nextNode.next = solutionSum.new ListNode(arr[i]);
                nextNode = nextNode.next;
            }
        }
        printListNoe(firstNode);
        return firstNode;
    }

    /**
     * 打印listNode
     *
     * @param listNode 待打印链表
     * @return 生成的整数
     */
    public int printListNoe(SolutionSum.ListNode listNode) {
        StringBuilder sb = new StringBuilder("链表数据: ");
        StringBuilder sbInt = new StringBuilder();
        while (Objects.nonNull(listNode)) {
            sb.append(listNode.val);
            if (Objects.nonNull(listNode.next)) {
                sb.append(" -> ");
            }
            sbInt.append(listNode.val);
            listNode = listNode.next;
        }
        System.out.println(sb.toString());
        sbInt.reverse();
        System.out.println("结果整数：" + sbInt.toString());
        return Integer.parseInt(sbInt.toString());
    }
}