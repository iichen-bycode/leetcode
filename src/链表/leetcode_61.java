package 链表;

import helper.ListNode;
import helper.NodeBuilder;

/*
给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。



示例 1：


输入：head = [1,2,3,4,5], k = 2
输出：[4,5,1,2,3]
示例 2：


输入：head = [0,1,2], k = 4
输出：[2,0,1]


提示：

链表中节点的数目在范围 [0, 500] 内
-100 <= Node.val <= 100
0 <= k <= 2 * 109
 */
public class leetcode_61 {
    public static void main(String[] args) {
    /*
    输入：head = [1,2,3,4,5], k = 2
输出：[4,5,1,2,3]
示例 2：


输入：head = [0,1,2], k = 4
输出：[2,0,1]
     */
        ListNode a = rotateRight(new NodeBuilder().build(new int[]{1, 2, 3, 4, 5}), 7);
        //[4,5,1,2,3]   2
        //[3,4,5,1,2]   3
        //[2,3,4,5,1]   4
        //[1,2,3,4,5]   5
        a.print();
        ListNode a2 = rotateRight(new NodeBuilder().build(new int[]{0}), 3);
        a2.print();
    }

    public static ListNode rotateRight(ListNode head, int k) {
        if(head == null)
            return null;
        int len = 0;
        ListNode t = head;
        while (t != null) {
            len++;
            if (len == k && t.next == null) {
                return head;
            }
            if (len > k) {
                break;
            }
            t = t.next;
        }
        len = len > k ? k : k % len;
        if (len == 0)
            return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy,cur = dummy;
        for (int i = 0; i < len; i++) {
            cur = cur.next;
        }
        while (cur.next != null) {
            prev = prev.next;
            cur = cur.next;
        }
        dummy.next = prev.next;
        prev.next = null;
        cur.next = head;
        return dummy.next;
    }
}
