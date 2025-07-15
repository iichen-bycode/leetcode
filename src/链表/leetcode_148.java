package 链表;

import helper.ListNode;
import helper.NodeBuilder;

/*
给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。



示例 1：


输入：head = [4,2,1,3]
输出：[1,2,3,4]
示例 2：


输入：head = [-1,5,3,4,0]
输出：[-1,0,3,4,5]
示例 3：

输入：head = []
输出：[]


提示：

链表中节点的数目在范围 [0, 5 * 104] 内
-105 <= Node.val <= 105


进阶：你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？
 */

// 排序链表
public class leetcode_148 {
    public static void main(String[] args) {
        ListNode.printNode(sortList(new NodeBuilder().build(new int[]{4, 2, 1, 3})));
        ListNode.printNode(sortList(new NodeBuilder().build(new int[]{-1, 5, 3, 4, 0})));
    }

    public static ListNode sortList(ListNode head) {
        // 分治排序
        if(head == null || head.next == null)
            return head;
        // 获取中间节点的前一个节点
        ListNode midPre = getMidPreListNode(head);
        return mergeListNode(sortList(head),sortList(midPre));
    }

    private static ListNode mergeListNode(ListNode node1, ListNode node2) {
        ListNode vp = new ListNode(0);
        ListNode p = vp;
        while (node1 != null && node2 != null) {
            if(node1.val > node2.val) {
                p.next = node2;
                node2 = node2.next;
            } else {
                p.next = node1;
                node1 = node1.next;
            }
            p = p.next;
        }
        p.next = node1 != null ? node1 : node2;
        return vp.next;
    }

    private static ListNode getMidPreListNode(ListNode head) {
        ListNode pre = head,p = head,q = head;
        while (q != null && q.next != null) {
            pre = p;
            p = p.next;
            q = q.next.next;
        }
        if (pre != null) {
            pre.next = null;
        }
        return p;
    }



    public static ListNode sortList2(ListNode head) {
        ListNode vp = new ListNode(0);
        vp.next = head;
        ListNode p = vp, t = null, q = head;
        while (q != null && q.next != null) {
            if (q.next.val > q.val) {
                q = q.next;
            } else {
                p = t == null ? vp : (t.val >= q.next.val ? vp : t);
                while (p.next != null) {
                    if(p.next.val < q.next.val) {
                        p = p.next;
                    } else {
                        ListNode s = q.next;
                        q.next = s.next;
                        s.next = p.next;
                        p.next = s;
                        t = s;
                        break;
                    }
                }
            }
        }
        return vp.next;
    }
}
