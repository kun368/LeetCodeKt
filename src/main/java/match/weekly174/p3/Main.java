package match.weekly174.p3;


import utils.java.TreeNode;

import java.util.HashSet;
import java.util.Set;

class Solution {

    private static final long MOD = (long) (1e9 + 7);

    public int maxProduct(TreeNode root) {
        Set<Long> ss = new HashSet<>();
        long sum = dfs(root, ss);
        System.out.println(ss);
        long ans = 0;
        for (Long s : ss) {
            ans = Math.max(ans, s * (sum - s));
        }
        return (int) (ans % MOD);
    }

    private long dfs(TreeNode root, Set<Long> ss) {
        if (root == null) {
            return 0;
        }
        long l = dfs(root.left, ss);
        long r = dfs(root.right, ss);
        ss.add(l);
        ss.add(r);
        return l + r + root.val;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println((long) (1e9 + 7));
    }
}
