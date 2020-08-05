package normal.cat0.cat03.cat033.p337;


import utils.java.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

class Solution {

    private Map<Integer, Integer> cache = new HashMap<>();

    private int dfs(TreeNode root, boolean canUse) {
        if (root == null) {
            return 0;
        }
        final int key = Objects.hash(root, root.val, canUse);
        if (cache.containsKey(key)) {
            return cache.get(key);
        }
        int ret = 0;
        if (canUse) ret = Math.max(ret, root.val + dfs(root.left, false) + dfs(root.right, false));
        ret = Math.max(ret, dfs(root.left, true) + dfs(root.right, true));
        cache.put(key, ret);
        return ret;
    }

    public int rob(TreeNode root) {
        this.cache.clear();
        return dfs(root, true);
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().rob(TreeNode.parse("[3,2,3,null,3,null,1]")));
        System.out.println(new Solution().rob(TreeNode.parse("[3,4,5,1,3,null,1]")));
        System.out.println(new Solution().rob(TreeNode.parse("[4,1,null,2,null,3]")));
    }
}
