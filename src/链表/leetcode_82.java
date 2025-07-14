package 链表;
import helper.ListNode;
import helper.NodeBuilder;
/*
给定一个已排序的链表的头 head ， 删除原始链表中所有重复数字的节点，只留下不同的数字 。返回 已排序的链表 。



示例 1：


输入：head = [1,2,3,3,4,4,5]
输出：[1,2,5]
示例 2：


输入：head = [1,1,1,2,3]
输出：[2,3]


提示：

链表中节点数目在范围 [0, 300] 内
-100 <= Node.val <= 100
题目数据保证链表已经按升序 排列
 */

// 删除排序链表中的重复元素 II
public class leetcode_82 {
    public static void main(String[] args) {
        ListNode.printNode(deleteDuplicates(new NodeBuilder().build(new int[]{1,2,3,3,4,4,5})));
        ListNode.printNode(deleteDuplicates(new NodeBuilder().build(new int[]{1,1,1,2,3})));
        ListNode.printNode(deleteDuplicates(new NodeBuilder().build(new int[]{1,1,1,2})));
        ListNode.printNode(deleteDuplicates(new NodeBuilder().build(new int[]{})));
    }

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode vn = new ListNode(0);
        vn.next = head;
        ListNode p = vn;
        while (p.next != null) {
            ListNode t = p.next;
            // 这里是去查询 最后一个重复的元素  也可以判断出现重复后 如：p.next.val == p.next.next.val后 从p开始while判断 后面值只要是val重复就不停后移
            while (t.next != null) {
                if(t.val == t.next.val) {
                    t = t.next;
                } else {
                    break;
                }
            }
            if(p.next != t) { // 出现重复了 直接修改当前p指向
                p.next = t.next;
            } else { // 否则 p = p.next
                p = t;
            }
        }
        return vn.next;
    }
}
