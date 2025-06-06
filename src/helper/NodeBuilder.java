package helper;

public class NodeBuilder {
    public ListNode build(int[] nodes) {
        if(nodes.length == 0) {
            return null;
        }
        ListNode head = new ListNode(nodes[0]);
        ListNode p = head;
        for (int i = 1; i < nodes.length; i++) {
            ListNode newNode = new ListNode(nodes[i]);
            p.next = newNode;
            p = newNode;
        }
        return head;
    }
}
