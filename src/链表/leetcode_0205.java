package 链表;

import helper.ListNode;

//https://leetcode.cn/problems/sum-lists-lcci/description/?envType=problem-list-v2&envId=linked-list
/*
给定两个用链表表示的整数，每个节点包含一个数位。

这些数位是反向存放的，也就是个位排在链表首部。

编写函数对这两个整数求和，并用链表形式返回结果。



示例：

输入：(7 -> 1 -> 6) + (5 -> 9 -> 2)，即617 + 295
输出：2 -> 1 -> 9，即912
进阶：思考一下，假设这些数位是正向存放的，又该如何解决呢?

示例：

输入：(6 -> 1 -> 7) + (2 -> 9 -> 5)，即617 + 295
输出：9 -> 1 -> 2，即912
 */
public class leetcode_0205 {
    public static void main(String[] args) {
//        ListNode l1 = new ListNode(2,new ListNode(4,new ListNode(3)));
//        ListNode l2 = new ListNode(5,new ListNode(6,new ListNode(4)));
//        ListNode l1 = new ListNode(1,new ListNode(8));
//        ListNode l2 = new ListNode(0);
        ListNode l1 = new ListNode(9,new ListNode(9));
        ListNode l2 = new ListNode(5);
        ListNode ans = addTwoNumbers(l1,l2);
        while (ans!= null) {
            System.out.print(ans.val+",");
            ans = ans.next;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ans = new ListNode();
        ListNode p = ans;
        int step = 0;
        while (l1 != null && l2 != null) {
            ListNode node = new ListNode();
            int x = l1.val + l2.val + step;
            step = x >= 10 ? 1 : 0;
            node.val = step > 0 ? x % 10 : x;
            l1 = l1.next;
            l2 = l2.next;
            p.next = node;
            p = node;
        }
        while (l1 != null) {
            int x = l1.val + step;
            step = x >= 10 ? 1 : 0;
            ListNode node = new ListNode(step > 0 ? x % 10 : x);
            p.next = node;
            p = node;
            l1 = l1.next;
        }
        while (l2 != null) {
            int x = l2.val + step;
            step = x >= 10 ? 1 : 0;
            ListNode node = new ListNode(step > 0 ? x % 10 : x);
            p.next = node;
            p = node;
            l2 = l2.next;
        }

        if(step == 1) {
            p.next = new ListNode(1);
        }
        return ans.next;
    }
}
