package 链表;

import helper.ListNode;

/*
给你一个链表的头节点 head ，该链表包含由 0 分隔开的一连串整数。链表的 开端 和 末尾 的节点都满足 Node.val == 0 。

对于每两个相邻的 0 ，请你将它们之间的所有节点合并成一个节点，其值是所有已合并节点的值之和。然后将所有 0 移除，修改后的链表不应该含有任何 0 。

 返回修改后链表的头节点 head 。



示例 1：


输入：head = [0,3,1,0,4,5,2,0]
输出：[4,11]
解释：
上图表示输入的链表。修改后的链表包含：
- 标记为绿色的节点之和：3 + 1 = 4
- 标记为红色的节点之和：4 + 5 + 2 = 11
示例 2：


输入：head = [0,1,0,3,0,2,2,0]
输出：[1,3,4]
解释：
上图表示输入的链表。修改后的链表包含：
- 标记为绿色的节点之和：1 = 1
- 标记为红色的节点之和：3 = 3
- 标记为黄色的节点之和：2 + 2 = 4


提示：

列表中的节点数目在范围 [3, 2 * 105] 内
0 <= Node.val <= 1000
不 存在连续两个 Node.val == 0 的节点
链表的 开端 和 末尾 节点都满足 Node.val == 0
 */
public class leetcode_2181 {
    public static void main(String[] args) {
        // head = [0,1,0,3,0,2,2,0]
        ListNode res = mergeNodes(new ListNode(0, new ListNode(1, new ListNode(0, new ListNode(3,
                new ListNode(0, new ListNode(2, new ListNode(2, new ListNode(0)))))))));
        // head = [0,3,1,0,4,5,2,0]
        ListNode res2 = mergeNodes(new ListNode(0, new ListNode(3, new ListNode(1, new ListNode(0,
                new ListNode(4, new ListNode(5, new ListNode(2, new ListNode(0)))))))));
        while (res != null) {
            System.out.print(res.val + ",");
            res = res.next;
        }
        System.out.println();
        while (res2 != null) {
            System.out.print(res2.val + ",");
            res2 = res2.next;
        }
    }

    // 换种想法 之前都是 通过向后不断 使用next取下一个节点，
    // 这里直接 不next移动到下一个节点，而是就是在初始处理的节点p 通过不断的改变 p.next 来实现后续逐个遍历
    public static ListNode mergeNodes(ListNode head) {
        ListNode p = head.next;
        while (p != null) {
            if(p.next.val == 0) { // 跳过
                p.next = p.next.next;
                p = p.next;
            } else {
                p.val += p.next.val;
                p.next = p.next.next;
            }
        }
        return head.next;
    }
}



