package utils.java;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
        next = null;
    }

    @Override
    public String toString() {
        return val + (next == null ? "" : "->" + next.toString());
    }

    public static ListNode parse(String str) {
        ListNode head = new ListNode(-1);
        ListNode cur = head;
        for (String s : str.split("->")) {
            cur.next = new ListNode(Integer.valueOf(s));
            cur = cur.next;
        }
        return head.next;
    }
}
