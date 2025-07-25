package 链表;

import helper.ListNode;
import helper.NodeBuilder;

/*
给你链表的头节点 head 和一个整数 k 。

交换 链表正数第 k 个节点和倒数第 k 个节点的值后，返回链表的头节点（链表 从 1 开始索引）。



示例 1：


输入：head = [1,2,3,4,5], k = 2
输出：[1,4,3,2,5]
示例 2：

输入：head = [7,9,6,6,7,8,3,0,9,5], k = 5
输出：[7,9,6,6,8,7,3,0,9,5]
示例 3：

输入：head = [1], k = 1
输出：[1]
示例 4：

输入：head = [1,2], k = 1
输出：[2,1]
示例 5：

输入：head = [1,2,3], k = 2
输出：[1,2,3]


提示：

链表中节点的数目是 n
1 <= k <= n <= 105
0 <= Node.val <= 100
 */
public class leetcode_1721 {
    public static void main(String[] args) {
        /*
        输入：head = [7,9,6,6,7,8,3,0,9,5], k = 5
输出：[7,9,6,6,8,7,3,0,9,5]
         */
        ListNode a = swapNodes(new NodeBuilder().build(new int[]{7, 9, 6, 6, 7, 8, 3, 0, 9, 5}), 5);
        a.print();
        ListNode a2 = swapNodes(new NodeBuilder().build(new int[]{1, 2, 3, 4, 5}), 2);
        a2.print();
        ListNode a3 = swapNodes(new NodeBuilder().build(new int[]{1}), 1);
        a3.print();
        ListNode a4 = swapNodes(new NodeBuilder().build(new int[]{1, 2}), 1);
        a4.print();
        ListNode a5 = swapNodes(new NodeBuilder().build(new int[]{1, 2, 3}), 2);
        a5.print();
    }

    public static ListNode swapNodes(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy, p = dummy;
        int l = k;
        while (l-- > 0) {
            p = p.next;
        }
        ListNode q = p;
        while (q.next != null) {
            q = q.next;
            prev = prev.next;
        }
        int t = p.val;
        p.val = prev.next.val;
        prev.next.val = t;
        return dummy.next;
    }
}
