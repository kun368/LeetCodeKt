package normal.cat0.cat01.cat010.p104.v2;


import utils.java.TreeNode;

class Solution {
    public int maxDepth(TreeNode root) {
        return root == null ? 0 : Math.max(maxDepth(root.left) + 1, maxDepth(root.right) + 1);
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
