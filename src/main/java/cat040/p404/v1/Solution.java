package cat040.p404.v1;

import utils.java.TreeNode;

/**
 * 左叶子之和
 */
class Solution {

    private int sum(TreeNode root, boolean isLeft) {
        if (root == null) return 0;
        if (root.left != null || root.right != null) {
            return sum(root.left, true) + sum(root.right, false);
        }
        return isLeft ? root.val : 0;
    }

    public int sumOfLeftLeaves(TreeNode root) {
        return sum(root, false);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3,
                new TreeNode(9),
                new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        System.out.println(new Solution().sumOfLeftLeaves(root));
    }
}