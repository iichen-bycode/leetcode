package 链表;

import helper.ListNode;
import helper.NodeBuilder;

import java.util.Comparator;
import java.util.PriorityQueue;

/*
给你一个链表数组，每个链表都已经按升序排列。

请你将所有链表合并到一个升序链表中，返回合并后的链表。

1 1 2   4 3 6   5 4



示例 1：

输入：lists = [[1,4,5],[1,3,4],[2,6]]
输出：[1,1,2,3,4,4,5,6]
解释：链表数组如下：
[
  1->4->5,
  1->3->4,
  2->6
]
将它们合并到一个有序链表中得到。
1->1->2->3->4->4->5->6
示例 2：

输入：lists = []
输出：[]
示例 3：

输入：lists = [[]]
输出：[]


提示：

k == lists.length
0 <= k <= 10^4
0 <= lists[i].length <= 500
-10^4 <= lists[i][j] <= 10^4
lists[i] 按 升序 排列
lists[i].length 的总和不超过 10^4
 */

// 合并 K 个升序链表
public class leetcode_23 {
    public static void main(String[] args) {
        ListNode.printNode(mergeKLists(new ListNode[]{new NodeBuilder().build(new int[]{1, 4, 5}), new NodeBuilder().build(new int[]{1, 3, 4}), new NodeBuilder().build(new int[]{2, 6})}));
    }


    // 使用堆 每次都把头节点元素加入堆即可
    public static ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });
        for (ListNode list : lists) {
            if (list != null) {
                minHeap.offer(list);
            }
        }
        ListNode vp = new ListNode(0);
        ListNode p = vp;
        while (!minHeap.isEmpty()) {
            ListNode t = minHeap.poll();
            if(t.next != null) {
                minHeap.offer(t.next);
            }
            p.next = t;
            p = t;
        }
        return vp.next;
    }



    public static ListNode mergeKLists3(ListNode[] lists) {
        return merge(lists, 0, lists.length - 1);
    }

    public static ListNode merge(ListNode[] lists, int l, int r) {
        if (l == r)
            return lists[l];
        if (l > r)
            return null;
        int mid = (r + l) >> 1;
        return mergeList(merge(lists, l, mid), merge(lists, mid + 1, r));
    }

    public static ListNode mergeList(ListNode a, ListNode b) {
        if (a == null || b == null)
            return a == null ? b : a;
        ListNode head = new ListNode(-1);
        ListNode p = head, pa = a, pb = b;
        while (pa != null && pb != null) {
            if (pa.val < pb.val) {
                p.next = pa;
                pa = pa.next;
            } else {
                p.next = pb;
                pb = pb.next;
            }
            p = p.next;
        }
        p.next = pa == null ? pb : pa;
        return head.next;
    }


    public static ListNode mergeKLists2(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        ListNode vp = new ListNode(0);
        int index = 0;
        for (; index < lists.length; index++) {
            if (lists[index] != null) {
                vp.next = lists[index];
                break;
            }
        }
        for (int i = index + 1; i < lists.length; i++) {
            ListNode t = lists[i];
            while (t != null) {
                ListNode p = vp;
                while (p.next != null) {
                    if (p.next.val <= t.val) {
                        p = p.next;
                    } else {
                        break;
                    }
                }
                ListNode nxt = t.next;
                t.next = p.next;
                p.next = t;
                t = nxt;
            }
        }
        return vp.next;
    }
}
