package 链表;

import helper.ListNode;
import helper.NodeBuilder;

import java.util.Deque;
import java.util.LinkedList;

/*
给你一个链表的头节点 head 。

移除每个右侧有一个更大数值的节点。

返回修改后链表的头节点 head 。



示例 1：



输入：head = [5,2,13,3,8]
输出：[13,8]
解释：需要移除的节点是 5 ，2 和 3 。
- 节点 13 在节点 5 右侧。
- 节点 13 在节点 2 右侧。
- 节点 8 在节点 3 右侧。
示例 2：

输入：head = [1,1,1,1]
输出：[1,1,1,1]
解释：每个节点的值都是 1 ，所以没有需要移除的节点。


提示：

给定列表中的节点数目在范围 [1, 105] 内
1 <= Node.val <= 105
 */

//  从链表中移除节点
public class leetcode_2487 {
    public static void main(String[] args) {
        ListNode.printNode(removeNodes(new NodeBuilder().build(new int[]{5, 2, 13, 3, 8})));
        ListNode.printNode(removeNodes(new NodeBuilder().build(new int[]{1, 1, 1, 1})));
        ListNode.printNode(removeNodes(new NodeBuilder().build(new int[]{3, 1, 2, 3, 4, 5, 6, 7, 8, 9})));
        ListNode.printNode(removeNodes(new NodeBuilder().build(new int[]{998, 112, 660, 961, 943, 721, 480, 522, 133, 129, 276, 362, 616, 52, 117, 300, 274, 862, 487, 715, 272, 232, 543, 275, 68, 144, 656, 623, 317, 63, 908, 565, 880, 12, 920, 467, 559, 91, 698})));
    }

    public static ListNode removeNodes2(ListNode head) {
        // 反向头插法
        Deque<ListNode> stack = new LinkedList<>();
        for (; head != null; head = head.next) {
            stack.push(head);
        }
        while (!stack.isEmpty()) {
            if (head == null || stack.peek().val > head.val) {
                stack.peek().next = head;
                head = stack.peek();
            }
            stack.pop();
        }
        return head;
    }
    public static ListNode removeNodes(ListNode head) {
        if(head.next == null)
            return head;
        ListNode p = removeNodes(head.next);
        if(head.val < p.val) {
            return p;
        }
        // 这一句进行串联起来
        head.next = p;
        return head;
    }
}
