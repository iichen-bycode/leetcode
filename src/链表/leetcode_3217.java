package 链表;

import helper.ListNode;

import java.util.HashSet;

/*
给你一个整数数组 nums 和一个链表的头节点 head。从链表中移除所有存在于 nums 中的节点后，返回修改后的链表的头节点。



示例 1：

输入： nums = [1,2,3], head = [1,2,3,4,5]

输出： [4,5]

解释：



移除数值为 1, 2 和 3 的节点。

示例 2：

输入： nums = [1], head = [1,2,1,2,1,2]

输出： [2,2,2]

解释：



移除数值为 1 的节点。

示例 3：

输入： nums = [5], head = [1,2,3,4]

输出： [1,2,3,4]

解释：



链表中不存在值为 5 的节点。



提示：

1 <= nums.length <= 105
1 <= nums[i] <= 105
nums 中的所有元素都是唯一的。
链表中的节点数在 [1, 105] 的范围内。
1 <= Node.val <= 105
输入保证链表中至少有一个值没有在 nums 中出现过。
 */
public class leetcode_3217 {
    public static void main(String[] args) {
//        nums = [1], head = [1,2,1,2,1,2]
//        nums = [5], head = [1,2,3,4]
        ListNode res = modifiedList(new int[]{1},new ListNode(1,new ListNode(2,new ListNode(1,new ListNode(2,new ListNode(1,new ListNode(2)))))));
        ListNode res2 = modifiedList(new int[]{5},new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4)))));
        res.print();
        res2.print();
    }

    public static ListNode modifiedList(int[] nums, ListNode head) {
        HashSet<Integer> cache = new HashSet<>();
        for (int num : nums) {
            cache.add(num);
        }
        while (head != null && cache.contains(head.val)) head = head.next;
        ListNode p = head;
        while (p != null) {
            if(p.next != null && cache.contains(p.next.val)) {
                p.next = p.next.next;
            } else {
                p = p.next;
            }
        }
        return head;
    }
}
