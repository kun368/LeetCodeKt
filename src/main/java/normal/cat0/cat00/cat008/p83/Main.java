package normal.cat0.cat00.cat008.p83;

import utils.java.ListNode;

import java.util.Random;

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode root = new ListNode(new Random().nextInt());
        ListNode current = root;
        while (head != null) {
            if (head.val != current.val) {
                current.next = head;
                current = current.next;
            }
            head = head.next;
        }
        current.next = null;
        return root.next;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().deleteDuplicates(ListNode.parse("1->1->2->3->3")));
    }
}
