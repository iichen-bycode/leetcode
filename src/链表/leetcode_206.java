package 链表;

import helper.ListNode;
import helper.NodeBuilder;

/*
给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。


示例 1：


输入：head = [1,2,3,4,5]
输出：[5,4,3,2,1]
示例 2：


输入：head = [1,2]
输出：[2,1]
示例 3：

输入：head = []
输出：[]


提示：

链表中节点的数目范围是 [0, 5000]
-5000 <= Node.val <= 5000

 */
public class leetcode_206 {
    public static void main(String[] args) {
        ListNode res = reverseList(new NodeBuilder().build(new int[]{1}));
        res.print();
    }

    // 将第一个节点 从原链表断开 作为尾节点
    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode p = head.next;
        head.next = null;
        while (p != null) {
            ListNode cur = p;
            p = p.next;
            cur.next = head;
            head = cur;
        }
        return head;
    }
}
