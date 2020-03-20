package normal.cat0.cat04.cat044.p445.v1;

import utils.java.ListNode;

import java.util.Stack;

class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> st1 = new Stack<>();
        Stack<Integer> st2 = new Stack<>();
        while (l1 != null) {
            st1.add(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            st2.add(l2.val);
            l2 = l2.next;
        }

        ListNode head = new ListNode(0);
        int push = 0;
        while (!st1.isEmpty() || !st2.isEmpty() || push > 0) {
            int sum = push;
            if (!st1.isEmpty()) {
                sum += st1.pop();
            }
            if (!st2.isEmpty()) {
                sum += st2.pop();
            }
            ListNode cur = new ListNode(sum % 10);
            cur.next = head.next;
            head.next = cur;
            push = sum / 10;
        }
        return head.next;
    }

    public static void main(String[] args) {
        ListNode l1 = ListNode.parse("6 -> 3 -> 5 -> 8");
        ListNode l2 = ListNode.parse("1 -> 4 -> 3");
        System.out.println(new Solution().addTwoNumbers(l1, l2));
    }
}