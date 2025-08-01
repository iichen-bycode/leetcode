package 链表;

import helper.ListNode;
import helper.NodeBuilder;

/*
给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。



示例 1：


输入：head = [1,2,3,4]
输出：[2,1,4,3]
示例 2：

输入：head = []
输出：[]
示例 3：

输入：head = [1]
输出：[1]


提示：

链表中节点的数目在范围 [0, 100] 内
0 <= Node.val <= 100
 */
public class leetcode_24 {
    public static void main(String[] args) {
        ListNode res = swapPairs(new NodeBuilder().build(new int[]{1,2,3,4,5,6,7,8,9,0}));
        res.print();
    }

    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode virtualNode = new ListNode(-1);
        virtualNode.next = head;
        ListNode p = head,prev = virtualNode;
        while (p != null) {
            if(p.next == null) {
                break;
            }
            ListNode nxt = p.next;
            p.next = nxt.next;
            nxt.next = prev.next;
            prev.next = nxt;

            prev = p;
            p = p.next;
        }
        return virtualNode.next;
    }
}
