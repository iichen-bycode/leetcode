package 链表;

import helper.ListNode;

/*
给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。


示例 1：


输入：head = [1,2,6,3,4,5,6], val = 6
输出：[1,2,3,4,5]
示例 2：

输入：head = [], val = 1
输出：[]
示例 3：

输入：head = [7,7,7,7], val = 7
输出：[]


提示：

列表中的节点数目在范围 [0, 104] 内
1 <= Node.val <= 50
0 <= val <= 50
 */
public class leetcode_203 {
    public static void main(String[] args) {
        ListNode res = removeElements(new ListNode(1,new ListNode(2,new ListNode(6,new ListNode(3,new ListNode(4,new ListNode(5,new ListNode(6))))))), 6);
//        ListNode res = removeElements(new ListNode(6,new ListNode(6,new ListNode(6,new ListNode(6,new ListNode(6,new ListNode(6,new ListNode(6))))))), 6);
        while (res != null) {
            System.out.print(res.val + ",");
            res = res.next;
        }
    }

    public static ListNode removeElements(ListNode head, int val) {
        if (head == null)
            return null;
        ListNode p = head;
        while (p != null) {
            if (p.next != null && p.next.val == val) {
                p.next = p.next.next;
            } else {
                p = p.next;
            }
        }
        return head;
    }
}
