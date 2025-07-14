package 链表;

import helper.ListNode;
import helper.NodeBuilder;

/*
给你两个链表 list1 和 list2 ，它们包含的元素分别为 n 个和 m 个。

请你将 list1 中下标从 a 到 b 的全部节点都删除，并将list2 接在被删除节点的位置。

下图中蓝色边和节点展示了操作后的结果：


请你返回结果链表的头指针。



示例 1：



输入：list1 = [10,1,13,6,9,5], a = 3, b = 4, list2 = [1000000,1000001,1000002]
输出：[10,1,13,1000000,1000001,1000002,5]
解释：我们删除 list1 中下标为 3 和 4 的两个节点，并将 list2 接在该位置。上图中蓝色的边和节点为答案链表。
示例 2：


输入：list1 = [0,1,2,3,4,5,6], a = 2, b = 5, list2 = [1000000,1000001,1000002,1000003,1000004]
输出：[0,1,1000000,1000001,1000002,1000003,1000004,6]
解释：上图中蓝色的边和节点为答案链表。


提示：

3 <= list1.length <= 104
1 <= a <= b < list1.length - 1
1 <= list2.length <= 104
 */

//  合并两个链表
public class leetcode_1669 {
    public static void main(String[] args) {
        ListNode.printNode(mergeInBetween(new NodeBuilder().build(new int[]{10, 1, 13, 6, 9, 5}), 1, 5, new NodeBuilder().build(new int[]{1000000, 1000001, 1000002})));
        ListNode.printNode(mergeInBetween(new NodeBuilder().build(new int[]{0, 1, 2, 3, 4, 5, 6}), 2, 5, new NodeBuilder().build(new int[]{1000000, 1000001, 1000002, 1000003, 1000004})));
    }

    public static ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        // 首不删除
        ListNode p1 = list1;
        ListNode p2 = list1;
        // 获取list2的尾指针
        ListNode list2Tail = list2;
        while (list2Tail.next != null) {
            list2Tail = list2Tail.next;
        }
        while (a > 1 || b >= 0) {
            if (a > 1) {
                p1 = p1.next;
                a--;
            }
            if (b >= 0) {
                p2 = p2.next;
                b--;
            }
        }
        p1.next = list2;
        list2Tail.next = p2;
        return list1;
    }
}
