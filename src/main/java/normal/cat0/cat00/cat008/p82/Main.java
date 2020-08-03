package normal.cat0.cat00.cat008.p82;

import utils.java.ListNode;

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode root = new ListNode(-1);
        ListNode current = root;
        ListNode pre = null;
        boolean ok = false;

        while (head != null) {
            if (pre == null || head.val != pre.val) {
                if (ok) {
                    current.next = pre;
                    current = current.next;
                }
                ok = true;
            } else {
                ok = false;
            }
            pre = head;
            head = head.next;
        }
        if (ok) {
            current.next = pre;
            current = current.next;
        }
        current.next = null;
        return root.next;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().deleteDuplicates(ListNode.parse("1->2->3->3->4->4->5")));
        System.out.println(new Solution().deleteDuplicates(ListNode.parse("1->1->1->2->3")));
        System.out.println(new Solution().deleteDuplicates(ListNode.parse("1->1->1->2->3->3")));
        System.out.println(new Solution().deleteDuplicates(ListNode.parse("1->1->1->2->2->3->3")));
    }
}
