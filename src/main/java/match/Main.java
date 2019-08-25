package match;

import utils.java.ListNode;

class A {}
class B {}

public class Main {


    boolean hasCycle(ListNode root) {
        if (root == null) {
            return false;
        }
        ListNode a = root;
        ListNode b = root;
        while (a != null && b != null) {
            a = a.next;
            b = a == null ? null : a.next;
            if (a == b) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) throws Exception {



    }
}