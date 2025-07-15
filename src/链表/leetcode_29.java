package 链表;

import helper.ListNode;
import helper.NodeBuilder;

/*
给定循环单调非递减列表中的一个点，写一个函数向这个列表中插入一个新元素 insertVal ，使这个列表仍然是循环升序的。

给定的可以是这个列表中任意一个顶点的指针，并不一定是这个列表中最小元素的指针。

如果有多个满足条件的插入位置，可以选择任意一个位置插入新的值，插入后整个列表仍然保持有序。

如果列表为空（给定的节点是 null），需要创建一个循环有序列表并返回这个节点。否则。请返回原先给定的节点。



示例 1：




输入：head = [3,4,1], insertVal = 2
输出：[3,4,1,2]
解释：在上图中，有一个包含三个元素的循环有序列表，你获得值为 3 的节点的指针，我们需要向表中插入元素 2 。新插入的节点应该在 1 和 3 之间，插入之后，整个列表如上图所示，最后返回节点 3 。


示例 2：

输入：head = [], insertVal = 1
输出：[1]
解释：列表为空（给定的节点是 null），创建一个循环有序列表并返回这个节点。
示例 3：

输入：head = [1], insertVal = 0
输出：[1,0]


提示：

0 <= Number of Nodes <= 5 * 10^4
-10^6 <= Node.val <= 10^6
-10^6 <= insertVal <= 10^6
 */

// 循环有序列表的插入
public class leetcode_29 {
    public static void main(String[] args) {
        ListNode tail = new ListNode(1);
        ListNode a = new ListNode(3, new ListNode(4, tail));
        tail.next = a;
        insert(a, 2);
        /*

            7   8   5       4
         */
//        ListNode.printNode(insert(new NodeBuilder().build(new int[]{1}), 0));
//        ListNode.printNode(insert(new NodeBuilder().build(new int[]{}),1));
    }

    public static ListNode insert(ListNode head, int insertVal) {
        ListNode t = new ListNode(insertVal);
        if (head == null) {
            t.next = t;
            return t;
        }
        // 7 8 5    4
        // 3 4 1    2

        // 3 3 3    0
        if (head.next == head) {
            head.next = t;
            t.next = head;
            return head;
        }

        ListNode curr = head,next = head.next;
        while (next != head) {
            // 在两个中间
            if (insertVal >= curr.val && insertVal <= next.val) {
                break;
            }
            if (curr.val > next.val) {
                //   如： 3 4 1       0  也是在两个节点直接
                if (insertVal > curr.val || insertVal < next.val) {
                    break;
                }
                // 否则   3 4 1       2在需要插入到next之后
            }
            curr = curr.next;
            next = next.next;
        }
        curr.next = t;
        t.next = next;
        return head;
    }

}


