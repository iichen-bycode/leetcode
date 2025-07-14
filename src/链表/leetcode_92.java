package 链表;

import helper.ListNode;
import helper.NodeBuilder;

/*
给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。


示例 1：


输入：head = [1,2,3,4,5], left = 2, right = 4
输出：[1,4,3,2,5]
示例 2：

输入：head = [5], left = 1, right = 1
输出：[5]


提示：

链表中节点数目为 n
1 <= n <= 500
-500 <= Node.val <= 500
1 <= left <= right <= n


进阶： 你可以使用一趟扫描完成反转吗？
 */
public class leetcode_92 {
    public static void main(String[] args) {
        ListNode res = reverseBetween(new NodeBuilder().build(new int[]{1, 2, 3, 4, 5}), 2, 4);
        res.print();
    }

    // 头插法 （或者遍历拆分子区间链表翻转后再拼接）
    public static ListNode reverseBetween(ListNode head, int left, int right) {
        /*
        输入：head = [1,2,3,4,5], left = 2, right = 4
            输出：[1,4,3,2,5]
         */
        ListNode virtualNode = new ListNode(-1);
        virtualNode.next = head;
        ListNode prev = virtualNode;
        for (int i = 0; i < left - 1; i++) {
            prev = prev.next;
        }
        ListNode cur = prev.next;
        for (int i = 0; i < right - left; i++) {
            ListNode next = cur.next;
            cur.next = next.next;
            next.next = prev.next;
            prev.next = next;
        }
        return virtualNode.next;
    }
}
