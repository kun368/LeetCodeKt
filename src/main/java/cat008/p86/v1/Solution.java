package cat008.p86.v1;

import utils.ext.ListNode;

/**
 * 分隔链表
 */
class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode p1 = new ListNode(-1);
        ListNode p2 = new ListNode(-1);
        ListNode h1 = p1, h2 = p2;
        while (head != null) {
            if (head.val < x) {
                p1.next = head;
                p1 = p1.next;
            } else {
                p2.next = head;
                p2 = p2.next;
            }
            head = head.next;
        }
        p1.next = h2.next;
        p2.next = null;
        return h1.next;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.partition(ListNode.parse("1->4->3->2->5->2"), 3));
    }
}