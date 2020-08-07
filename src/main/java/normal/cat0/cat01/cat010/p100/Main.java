package normal.cat0.cat01.cat010.p100;

import utils.java.TreeNode;

import java.util.Objects;

class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if ((p == null && q != null) || (p != null && q == null)) {
            return false;
        }
        if (p == null && q == null) {
            return true;
        }
        return Objects.equals(p.val, q.val) && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().isSameTree(
                TreeNode.parse("[1,2,3]"),
                TreeNode.parse("[1,2,3]")
        ));
        System.out.println(new Solution().isSameTree(
                TreeNode.parse("[1,2]"),
                TreeNode.parse("[1,null,2]")
        ));
        System.out.println(new Solution().isSameTree(
                TreeNode.parse("[1,2,1]"),
                TreeNode.parse("[1,1,2]")
        ));
    }
}
