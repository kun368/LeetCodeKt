package normal.cat0.cat01.cat011.p114;

import utils.java.TreeNode;

class Solution {

    private TreeNode dfs(TreeNode root, TreeNode pre) {
        if (root == null) return pre;
        pre.right = root;
        TreeNode last = dfs(root.right, dfs(root.left, root));
        root.left = null;
        return last;
    }

    public void flatten(TreeNode root) {
        dfs(root, new TreeNode(0));
    }
}

public class Main {
    public static void main(String[] args) {
        TreeNode tree = TreeNode.parse("[1, 2, 5, 3, 4, null, 6]");
        System.out.println(tree);
        new Solution().flatten(tree);
        System.out.println(tree);
    }
}
