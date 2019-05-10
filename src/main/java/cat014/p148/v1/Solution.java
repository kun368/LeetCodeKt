package cat014.p148.v1;

import utils.ext.ListNode;

/**
 * 排序链表
 */
class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode cur = head;
        ListNode mid = head;
        while (cur.next != null && cur.next.next != null) {
            mid = mid.next;
            cur = cur.next.next;
        }
        ListNode h1 = sortList(mid.next);
        mid.next = null;
        ListNode h2 = sortList(head);

        ListNode mock = new ListNode(-1);
        cur = mock;
        while (h1 != null || h2 != null) {
            if (h2 == null || (h1 != null && h1.val <= h2.val)) {
                cur.next = h1;
                h1 = h1.next;
            } else {
                cur.next = h2;
                h2 = h2.next;
            }
            cur = cur.next;
        }
        return mock.next;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.sortList(ListNode.parse("4->2->1->3")));
        System.out.println(solution.sortList(ListNode.parse("-1->5->3->4->0")));
    }
}