package 链表;

import helper.ListNode;
import helper.NodeBuilder;
/*
给定单个链表的头 head ，使用 插入排序 对链表进行排序，并返回 排序后链表的头 。

插入排序 算法的步骤:

插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。
每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。
重复直到所有输入数据插入完为止。
下面是插入排序算法的一个图形示例。部分排序的列表(黑色)最初只包含列表中的第一个元素。每次迭代时，从输入数据中删除一个元素(红色)，并就地插入已排序的列表中。

对链表进行插入排序。





示例 1：



输入: head = [4,2,1,3]
输出: [1,2,3,4]
示例 2：



输入: head = [-1,5,3,4,0]
输出: [-1,0,3,4,5]


提示：

列表中的节点数在 [1, 5000]范围内
-5000 <= Node.val <= 5000
 */

// 对链表进行插入排序
public class leetcode_147 {
    public static void main(String[] args) {
        ListNode.printNode(insertionSortList(new NodeBuilder().build(new int[]{4, 2, 1, 3})));
        /*
            2   4   1   3

         */
        ListNode.printNode(insertionSortList(new NodeBuilder().build(new int[]{-1, 5, 3, 4, 0})));
    }

    public static ListNode insertionSortList(ListNode head) {
        ListNode vp = new ListNode(0);
        vp.next = head;
        ListNode q = head;
        while (q != null && q.next != null) {
            if (q.next.val > q.val) {
                q = q.next;
            } else {
                ListNode p = vp;
                while (p.next != null) {
                    if (p.next.val < q.next.val) {
                        p = p.next;
                    } else {
                        // 处理节点
                        ListNode t = q.next;
                        q.next = t.next;
                        // 不要用q去链接 用前置的节点去找后置的节点
                        t.next = p.next;
                        p.next = t;
                        break;
                    }
                }
            }
        }
        return vp.next;
    }
}


























