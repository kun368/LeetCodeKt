package normal.cat0.cat00.cat009.p99.v2;

import utils.java.TreeNode;

class Solution {
    
    TreeNode t1, t2, pre;
    
    private void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.left);
        if (pre != null && root.val < pre.val) {
            if (t1 == null) t1 = pre;
            t2 = root;
        }
        pre = root;
        dfs(root.right);
    }
    
    public void recoverTree(TreeNode root) {
        dfs(root);
        int t = t1.val;
        t1.val = t2.val;
        t2.val = t;
    }
}

public class Main {
    public static void main(String[] args) {
        new Solution().recoverTree(TreeNode.parse("[1,3,null,null,2]"));
        new Solution().recoverTree(TreeNode.parse("[3,1,4,null,null,2]"));
    }
}
