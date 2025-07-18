package 链表;

import helper.ListNode;
import helper.NodeBuilder;

/*
给你一个链表的头节点 head 。

链表中的节点 按顺序 划分成若干 非空 组，这些非空组的长度构成一个自然数序列（1, 2, 3, 4, ...）。一个组的 长度 就是组中分配到的节点数目。换句话说：

节点 1 分配给第一组
节点 2 和 3 分配给第二组
节点 4、5 和 6 分配给第三组，以此类推
注意，最后一组的长度可能小于或者等于 1 + 倒数第二组的长度 。

反转 每个 偶数 长度组中的节点，并返回修改后链表的头节点 head 。



示例 1：



输入：head = [5,2,6,3,9,1,7,3,8,4]
输出：[5,6,2,3,9,1,4,8,3,7]
解释：
- 第一组长度为 1 ，奇数，没有发生反转。
- 第二组长度为 2 ，偶数，节点反转。
- 第三组长度为 3 ，奇数，没有发生反转。
- 最后一组长度为 4 ，偶数，节点反转。
示例 2：



输入：head = [1,1,0,6]
输出：[1,0,1,6]
解释：
- 第一组长度为 1 ，没有发生反转。
- 第二组长度为 2 ，节点反转。
- 最后一组长度为 1 ，没有发生反转。
示例 3：



输入：head = [2,1]
输出：[2,1]
解释：
- 第一组长度为 1 ，没有发生反转。
- 最后一组长度为 1 ，没有发生反转。


提示：

链表中节点数目范围是 [1, 105]
0 <= Node.val <= 105
 */
public class leetcode_2074 {
    public static void main(String[] args) {
//        输入：head = [5,2,6,3,9,1,7,3,8,4]
//        输出：[5,6,2,3,9,1,4,8,3,7]
        ListNode l = reverseEvenLengthGroups(new NodeBuilder().build(new int[]{5, 2, 6, 3, 9, 1, 7, 3, 8, 4}));
        l.print();
//
//        输入：head = [1,1,0,6]
//        输出：[1,0,1,6]
        ListNode l1 = reverseEvenLengthGroups(new NodeBuilder().build(new int[]{1, 1, 0, 6}));
        l1.print();
//
//        输入：head = [1,1,0,6,5]
//        输出：[1,0,1,5,6]
        ListNode l2 = reverseEvenLengthGroups(new NodeBuilder().build(new int[]{1, 1, 0, 6, 5}));
        l2.print();
    }

    public static ListNode reverseEvenLengthGroups(ListNode head) {
        // 考虑的是当前分组是不是偶数 不要拘泥分组是奇数还是偶数
        int i = 1;
        // 5, 2, 6, 3, 9, 1, 7, 3, 8, 4
        ListNode p = head, prev = head;
        while (p != null) {
            // 获取当前分组的长度
            int len = 0;
            ListNode t = p;
            for (int j = 0; j < i && t != null; j++) {
                len++;
                t = t.next;
            }
            if (len % 2 == 0) { // 偶数反转
                for (int j = 0; j < len - 1; j++) {
                    ListNode nxt = p.next;
                    p.next = nxt.next;
                    nxt.next = prev.next;
                    prev.next = nxt;
                }
                prev = p;
                p = p.next;
            } else {
                for (int j = 0; j < len; j++) {
                    prev = p;
                    p = p.next;
                }
            }
            i++;
        }
        return head;
    }
}
