package 链表;

import helper.ListNode;
import helper.NodeBuilder;

/*
给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。

请你将两个数相加，并以相同形式返回一个表示和的链表。

你可以假设除了数字 0 之外，这两个数都不会以 0 开头。



示例 1：


输入：l1 = [2,4,3], l2 = [5,6,4]
输出：[7,0,8]
解释：342 + 465 = 807.
示例 2：

输入：l1 = [0], l2 = [0]
输出：[0]
示例 3：

输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
    9999999
       9999
       8999000

输出：[8,9,9,9,0,0,0,1]


提示：

每个链表中的节点数在范围 [1, 100] 内
0 <= Node.val <= 9
题目数据保证列表表示的数字不含前导零
 */

//  两数相加
public class leetcode_2 {
    public static void main(String[] args) {
        ListNode.printNode(addTwoNumbers(new NodeBuilder().build(new int[]{5}), new NodeBuilder().build(new int[]{5})));

//        ListNode.printNode(addTwoNumbers(new NodeBuilder().build(new int[]{2, 4, 3}), new NodeBuilder().build(new int[]{5, 6, 4})));
//        ListNode.printNode(addTwoNumbers(new NodeBuilder().build(new int[]{0}), new NodeBuilder().build(new int[]{0})));
//        ListNode.printNode(addTwoNumbers(new NodeBuilder().build(new int[]{9, 9, 9, 9, 9, 9, 9}), new NodeBuilder().build(new int[]{9, 9, 9, 9})));
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p = l1, q = l2;
        int step = 0;
        ListNode t = null;
        while (p != null && q != null) {
            int count = p.val + q.val + step;
            int a = count % 10;
            step = count / 10;
            p.val = a;
            if(p.next == null)
                t = p;
            p = p.next;
            q = q.next;
        }
        if(t != null) {
            t.next = q;
        }
        if(q != null) {
            while (q != null) {
                int count = q.val + step;
                int a = count % 10;
                step = count / 10;
                q.val = a;
                if(q.next == null && step != 0) {
                    q.next = new ListNode(step);
                    break;
                }
                q = q.next;
            }
        } else if(p != null){
            while (p != null) {
                int count = p.val + step;
                int a = count % 10;
                step = count / 10;
                p.val = a;
                if(p.next == null && step != 0) {
                    p.next = new ListNode(step);
                    break;
                }
                p = p.next;
            }
        } else {
            if(step != 0) {
                t.next = new ListNode(step);
            }
        }
        return l1;
    }
}
