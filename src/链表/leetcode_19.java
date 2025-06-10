package 链表;

import helper.ListNode;
import helper.NodeBuilder;

/*
给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。



示例 1：


输入：head = [1,2,3,4,5], n = 2
输出：[1,2,3,5]
示例 2：

输入：head = [1], n = 1
输出：[]
示例 3：

输入：head = [1,2], n = 1
输出：[1]


提示：

链表中结点的数目为 sz
1 <= sz <= 30
0 <= Node.val <= 100
1 <= n <= sz


进阶：你能尝试使用一趟扫描实现吗？
 */
public class leetcode_19 {
    public static void main(String[] args) {
        /*
        输入：head = [1,2,3,4,5], n = 2
        输出：[1,2,3,5]
        示例 2：

        输入：head = [1], n = 1
        输出：[]
        示例 3：

        输入：head = [1,2], n = 1
        输出：[1]
         */
        ListNode a = removeNthFromEnd(new NodeBuilder().build(new int[]{1, 2, 3, 4, 5}), 3);
        /*
            0 1 3

         */
        a.print();
        ListNode a2 = removeNthFromEnd(new NodeBuilder().build(new int[]{1, 2}), 2);
        a2.print();
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy, cur = head;
        ListNode p = head;
        while (p != null && n > 0) {
            p = p.next;
            n--;
        }
        while (p != null) {
            prev = cur;
            cur = cur.next;
            p = p.next;
        }
        if (cur != null) {
            prev.next = cur.next;
        }
        return dummy.next;
    }
}
