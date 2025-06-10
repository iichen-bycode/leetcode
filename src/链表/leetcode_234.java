package 链表;

import helper.ListNode;
import helper.NodeBuilder;

/*
给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。



示例 1：


输入：head = [1,2,2,1]
输出：true
示例 2：


输入：head = [1,2]
输出：false


提示：

链表中节点数目在范围[1, 105] 内
0 <= Node.val <= 9


进阶：你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
https://leetcode.cn/problems/palindrome-linked-list/description/
 */
public class leetcode_234 {
    public static void main(String[] args) {
        System.out.println(isPalindrome(new NodeBuilder().build(new int[]{1})));
        System.out.println(isPalindrome(new NodeBuilder().build(new int[]{1,0,1})));
        System.out.println(isPalindrome(new NodeBuilder().build(new int[]{1, 1})));
        System.out.println(isPalindrome(new NodeBuilder().build(new int[]{1, 2})));
        System.out.println(isPalindrome(new NodeBuilder().build(new int[]{1, 2, 3, 1})));
        System.out.println(isPalindrome(new NodeBuilder().build(new int[]{1, 2, 3, 3, 2, 1})));
    }
    /*
        获取中间节点 -> 反转后半部分 -> 反转后的与前半部分匹配
     */
    public static boolean isPalindrome(ListNode head) {
        ListNode p = head, q = head;
        while (q != null && q.next != null) {
            p = p.next;
            q = q.next.next;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = p;
        while (p != null && p.next != null) {
            ListNode next = p.next;
            p.next = next.next;
            next.next = dummy.next;
            dummy.next = next;
        }
        ListNode t = dummy.next;
        while (head != null && t != null) {
            if (head.val != t.val)
                return false;
            head = head.next;
            t = t.next;
        }
        return true;
    }
}
