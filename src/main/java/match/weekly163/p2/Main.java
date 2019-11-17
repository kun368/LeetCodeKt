package match.weekly163.p2;


import utils.java.TreeNode;

import java.util.HashSet;
import java.util.Set;

class FindElements {

    private Set<Integer> set = new HashSet<>();

    public FindElements(TreeNode root) {
        dfs(root, 0);
    }

    private void dfs(TreeNode root, int rv) {
        if (root == null) return;
        set.add(rv);
        dfs(root.left, rv * 2 + 1);
        dfs(root.right, rv * 2 + 2);
    }

    public boolean find(int target) {
        return set.contains(target);
    }
}

public class Main {
    public static void main(String[] args) {
        FindElements f = new FindElements(new TreeNode(-1, null, new TreeNode(-1)));
        System.out.println(f.find(1));
        System.out.println(f.find(2));
    }
}
