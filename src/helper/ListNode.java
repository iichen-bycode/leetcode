package helper;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public void print() {
        ListNode t = this;
        while (t != null) {
            System.out.print(t.val + ",");
            t = t.next;
        }
        System.out.println();
    }
}