package cat014.p141.v1;

import utils.java.ListNode;

public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode cur1 = head;
        ListNode cur2 = head;
        while (true) {
            cur1 = cur1 == null ? null : cur1.next;
            cur2 = cur2 == null ? null : cur2.next;
            cur2 = cur2 == null ? null : cur2.next;
            if (cur1 == null || cur2 == null) {
                return false;
            }
            if (cur1 == cur2) {
                return true;
            }
        }
    }
}