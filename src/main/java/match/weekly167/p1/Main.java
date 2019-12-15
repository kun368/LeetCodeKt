package match.weekly167.p1;

import utils.java.ListNode;

import java.math.BigInteger;

class Solution {
    public int getDecimalValue(ListNode head) {
        StringBuilder x = new StringBuilder();
        while (head != null) {
            x.append(head.val);
            head = head.next;
        }
        BigInteger ret = new BigInteger(x.toString(), 2);
        return ret.intValue();
    }
}

public class Main {
    public static void main(String[] args) {
    }
}
