package 链表;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
给你一个长度为 n 的链表，每个节点包含一个额外增加的随机指针 random ，该指针可以指向链表中的任何节点或空节点。

构造这个链表的 深拷贝。 深拷贝应该正好由 n 个 全新 节点组成，其中每个新节点的值都设为其对应的原节点的值。新节点的 next 指针和 random 指针也都应指向复制链表中的新节点，并使原链表和复制链表中的这些指针能够表示相同的链表状态。复制链表中的指针都不应指向原链表中的节点 。

例如，如果原链表中有 X 和 Y 两个节点，其中 X.random --> Y 。那么在复制链表中对应的两个节点 x 和 y ，同样有 x.random --> y 。

返回复制链表的头节点。

用一个由 n 个节点组成的链表来表示输入/输出中的链表。每个节点用一个 [val, random_index] 表示：

val：一个表示 Node.val 的整数。
random_index：随机指针指向的节点索引（范围从 0 到 n-1）；如果不指向任何节点，则为  null 。
你的代码 只 接受原链表的头节点 head 作为传入参数。



示例 1：



输入：head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
输出：[[7,null],[13,0],[11,4],[10,2],[1,0]]
示例 2：



输入：head = [[1,1],[2,1]]
输出：[[1,1],[2,1]]
示例 3：



输入：head = [[3,null],[3,0],[3,null]]
输出：[[3,null],[3,0],[3,null]]


提示：

0 <= n <= 1000
-104 <= Node.val <= 104
Node.random 为 null 或指向链表中的节点。
 */
public class leetcode_138 {
    public static void main(String[] args) {
//        [[7,null],[13,0],[11,4],[10,2],[1,0]]
        Node head = new Node(7);
        head.random = null;

        Node n1 = new Node(13);
        n1.random = head;
        head.next = n1;

        Node n2 = new Node(11);
        n1.next = n2;

        Node n3 = new Node(10);
        n2.next = n3;
        n3.random = n2;

        Node n4 = new Node(1);
        n3.next = n4;
        n4.random = head;

        n2.random = n4;
        Node t = head;

        while (t != null) {
            System.out.print(t.val + ",");
            if (t.random != null) {
                System.out.print(t.random.val);
            }
            t = t.next;
            System.out.println();
        }

        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");

        Node node = copyRandomList(head);
        while (node != null) {
            System.out.print(node.val + ",");
            if (node.random != null) {
                System.out.print(node.random.val);
            }
            node = node.next;
            System.out.println();
        }
    }


    /*
        改变原链表 直接复制每一个节点到next内 随后再遍历新的链表 来设置random最终再把需要的 复制节点重新摘取出来
     */
    public static Node copyRandomList(Node head) {
        if (head == null)
            return head;
        for (Node node = head; node != null; node = node.next.next) {
            Node n = new Node(node.val);
            n.next = node.next;
            node.next = n;
        }
        for (Node node = head; node != null; node = node.next.next) {
            Node n = node.next;
            n.random = node.random == null ? null : node.random.next;
        }
        Node p = head.next;
        for (Node node = head; node != null; node = node.next) {
            Node nodeNew = node.next;
            node.next = node.next.next;
            nodeNew.next = (nodeNew.next != null) ? nodeNew.next.next : null;
        }
        return p;
    }

    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
