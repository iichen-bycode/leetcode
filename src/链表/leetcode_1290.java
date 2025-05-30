package 链表;

import helper.ListNode;

import java.util.ArrayList;
import java.util.List;

/*
给你一个单链表的引用结点 head。链表中每个结点的值不是 0 就是 1。已知此链表是一个整数数字的二进制表示形式。

请你返回该链表所表示数字的 十进制值 。



示例 1：



输入：head = [1,0,1]
输出：5
解释：二进制数 (101) 转化为十进制数 (5)
示例 2：

输入：head = [0]
输出：0
示例 3：

输入：head = [1]
输出：1
示例 4：

输入：head = [1,0,0,1,0,0,1,1,1,0,0,0,0,0,0]
输出：18880
示例 5：

输入：head = [0,0]
输出：0


提示：

链表不为空。
链表的结点总数不超过 30。
每个结点的值不是 0 就是 1。
 */
public class leetcode_1290 {
    public static void main(String[] args) {
//        [1,0,0,1,0,0,1,1,1,0,0,0,0,0,0]
//         16384  8192  4096  2048  1024  512  256  128  64  32  16  8   4  2  1
        System.out.println(getDecimalValue2(new ListNode(1, new ListNode(0, new ListNode(1)))));
    }

    public static int getDecimalValue2(ListNode head) {
        int sum = 0;
        while (head != null) {
            // 想象成10进制  526 5 * 100 + 2 * 10 + 6
            sum = 2 * sum + head.val;
            head = head.next;
        }
        return sum;
    }

    public static int getDecimalValue(ListNode head) {
        int t = 1;
        int ans = 0;
        List<Integer> cache = new ArrayList<>();
        while (head != null) {
            cache.add(0, head.val);
            head = head.next;
        }

        for (Integer integer : cache) {
            if (integer != 0) {
                ans += t;
            }
            t *= 2;
        }
        return ans;

    }
}
