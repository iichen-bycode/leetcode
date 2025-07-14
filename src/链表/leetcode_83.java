package 链表;
/*
给定一个已排序的链表的头 head ， 删除所有重复的元素，使每个元素只出现一次 。返回 已排序的链表 。



示例 1：


输入：head = [1,1,2]
输出：[1,2]
示例 2：


输入：head = [1,1,2,3,3]
输出：[1,2,3]


提示：

链表中节点数目在范围 [0, 300] 内
-100 <= Node.val <= 100
题目数据保证链表已经按升序 排列
 */

import helper.ListNode;
import helper.NodeBuilder;

// 删除排序链表中的重复元素
public class leetcode_83 {
    public static void main(String[] args) {
        ListNode.printNode(deleteDuplicates(new NodeBuilder().build(new int[]{1,1,2})));
        ListNode.printNode(deleteDuplicates(new NodeBuilder().build(new int[]{1,1,2,3,3})));
    }
    public static ListNode deleteDuplicates(ListNode head) {
        if(head == null)
            return head;
        ListNode p = head;
        while (p.next != null) {
            ListNode t = p.next;
            if(t.val == p.val) {
                p.next = t.next;
            } else {
                p = p.next;
            }
        }
        return head;
    }
}
