package cat0.cat01.cat010.p101.v1;

import utils.java.TreeNode;

/**
 * 对称二叉树
 * 递归实现
 */
class Solution {

    private boolean check(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return true;
        }
        if (t1 == null || t2 == null) {
            return false;
        }
        if (t1.val != t2.val) {
            return false;
        }
        return check(t1.left, t2.right) && check(t1.right, t2.left);
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return check(root.left, root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1,
                new TreeNode(2, new TreeNode(3), new TreeNode(4)),
                new TreeNode(2, new TreeNode(4), new TreeNode(3))
        );
        System.out.println(new Solution().isSymmetric(root));

        root = new TreeNode(1,
                new TreeNode(2, null, new TreeNode(3)),
                new TreeNode(2, null, new TreeNode(3))
        );
        System.out.println(new Solution().isSymmetric(root));
    }
}