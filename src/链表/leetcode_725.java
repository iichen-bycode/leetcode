package 链表;

import helper.ListNode;

/*
给你一个头结点为 head 的单链表和一个整数 k ，请你设计一个算法将链表分隔为 k 个连续的部分。

每部分的长度应该尽可能的相等：任意两部分的长度差距不能超过 1 。这可能会导致有些部分为 null 。

这 k 个部分应该按照在链表中出现的顺序排列，并且排在前面的部分的长度应该大于或等于排在后面的长度。

返回一个由上述 k 部分组成的数组。


示例 1：


输入：head = [1,2,3], k = 5
输出：[[1],[2],[3],[],[]]
解释：
第一个元素 output[0] 为 output[0].val = 1 ，output[0].next = null 。
最后一个元素 output[4] 为 null ，但它作为 ListNode 的字符串表示是 [] 。
示例 2：


输入：head = [1,2,3,4,5,6,7,8,9,10], k = 3
输出：[[1,2,3,4],[5,6,7],[8,9,10]]
解释：
输入被分成了几个连续的部分，并且每部分的长度相差不超过 1 。前面部分的长度大于等于后面部分的长度。


提示：

链表中节点的数目在范围 [0, 1000]
0 <= Node.val <= 1000
1 <= k <= 50
 */
public class leetcode_725 {
    public static void main(String[] args) {
        //head = [1,2,3,4,5,6,7,8,9,10], k = 3
        //[[1,2,3,4],[5,6,7],[8,9,10]]
//        ListNode[] res = splitListToParts(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4,
//                new ListNode(5, new ListNode(6, new ListNode(7, new ListNode(8, new ListNode(9, new ListNode(10)))))))))), 3);
        ListNode[] res2 = splitListToParts(new ListNode(1, new ListNode(2, new ListNode(3))), 5);
//        ListNode[] res3 = splitListToParts(new ListNode(0, new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))))), 3);
        for (ListNode re : res2) {
            ListNode node = re;
            while (node != null) {
                System.out.print(node.val + ",");
                node = node.next;
            }
            System.out.println();
        }
    }

    public static ListNode[] splitListToParts(ListNode head, int k) {
        // 5 / 3 = 1
        /*
            0 1 2 3 4
         */
        ListNode[] ans = new ListNode[k];
        ListNode p = head;
        int count = 0;
        while (p != null) {
            p = p.next;
            count++;
        }
        int cacheLen = count <= k ? 1 : count / k;
        int remain = count <= k ? 0 : count % k;
        int[] len = new int[k];
        for (int i = 0; i < k; i++) {
            len[i] = i <= remain - 1 ? cacheLen + 1 : cacheLen;
        }
        p = head;
        //head = [1,2,3,4,5,6,7,8,9,10], k = 3
        int index = 0;
        while (p != null) {
            if (len[index] > 0) {
                if (ans[index] == null) {
                    ans[index] = p;
                }
                len[index]--;
                if (len[index] == 0) {// 截断
                    ListNode t = p.next;
                    p.next = null;
                    p = t;
                    ++index;
                    continue;
                }
            }
            p = p.next;
        }
        return ans;
    }
}
