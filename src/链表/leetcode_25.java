package 链表;

import helper.ListNode;
import helper.NodeBuilder;
import org.w3c.dom.Node;

/*
给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。

k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。

你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。



示例 1：


输入：head = [1,2,3,4,5], k = 2
输出：[2,1,4,3,5]
示例 2：



输入：head = [1,2,3,4,5], k = 3
输出：[3,2,1,4,5]


提示：
链表中的节点数目为 n
1 <= k <= n <= 5000
0 <= Node.val <= 1000


进阶：你可以设计一个只用 O(1) 额外内存空间的算法解决此问题吗？
 */
public class leetcode_25 {
    public static void main(String[] args) {
        ListNode res = reverseKGroup(new NodeBuilder().build(new int[]{1,2,3,4,5}),2);
        res.print();
        ListNode res2 = reverseKGroup(new NodeBuilder().build(new int[]{1,2,3}),3);
        res2.print();
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode t = head;
        int count = 0;
        while (t != null) {
            count++;
            t = t.next;
        }
        int num = count / k;
        ListNode virtualNode = new ListNode(-1);
        virtualNode.next = head;
        ListNode prev = virtualNode,p = head;
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < k - 1; j++) {
                ListNode nxt = p.next;
                p.next = nxt.next;
                nxt.next = prev.next;
                prev.next = nxt;
            }
            prev = p;
            p = p.next;
        }
        return virtualNode.next;
    }
}
