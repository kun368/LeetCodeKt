package match.weekly178.p3;

import utils.java.ListNode;
import utils.java.TreeNode;

import java.util.*;

class Solution {

    private boolean ok;
    private List<Integer> list;

    public boolean isSubPath(ListNode head, TreeNode root) {
        ok = false;
        list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }

        dfs(root, Collections.singleton(0));
        return ok;
    }

    private void dfs(TreeNode root, Set<Integer> matchedLen) {
        if (ok) {
            return;
        }
        if (matchedLen.contains(list.size())) {
            ok = true;
            return;
        }
        if (root == null) {
            return;
        }
        Set<Integer> set = new HashSet<>();
        set.add(0);
        for (Integer i : matchedLen) {
            if (root.val == list.get(i)) {
                set.add(i + 1);
            }
        }
        dfs(root.left, set);
        dfs(root.right, set);
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
