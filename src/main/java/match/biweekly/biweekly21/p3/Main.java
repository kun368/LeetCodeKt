package match.biweekly.biweekly21.p3;

import utils.java.TreeNode;

class Solution {

    private static class Node {

        int left, right;

        public Node(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }

    int ans = 0;

    public int longestZigZag(TreeNode root) {
        ans = 0;
        dfs(root);
        return ans;
    }

    public Node dfs(TreeNode root) {
        if (root == null) {
            return new Node(-1, -1);
        }
        Node node = new Node(0, 0);
        node.left = dfs(root.left).right + 1;
        node.right = dfs(root.right).left + 1;
        ans = Math.max(ans, Math.max(node.left, node.right));
        return node;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().longestZigZag(TreeNode.parse("[1,null,1,1,1,null,null,1,1,null,1,null,null,null,1,null,1]")));
        System.out.println(new Solution().longestZigZag(TreeNode.parse("[1,1,1,null,1,null,null,1,1,null,1]")));
        System.out.println(new Solution().longestZigZag(TreeNode.parse("[1]")));
    }
}
