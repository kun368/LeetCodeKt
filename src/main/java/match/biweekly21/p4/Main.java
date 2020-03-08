package match.biweekly21.p4;


import utils.java.TreeNode;

class Solution {

    private static class Node {
        boolean ok;
        int sum;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
    }

    int ans = 0;

    public int maxSumBST(TreeNode root) {
        ans = 0;
        dfs(root);
        return ans;
    }

    private Node dfs(TreeNode root) {
        if (root == null) {
            Node node = new Node();
            node.ok = true;
            node.sum = 0;
            return node;
        }
        Node n1 = dfs(root.left), n2 = dfs(root.right);
        Node cur = new Node();
        cur.ok = n1.ok && n2.ok && n1.max < root.val && n2.min > root.val;
        cur.sum = n1.sum + n2.sum + root.val;
        cur.max = Math.max(n1.max, Math.max(n2.max, root.val));
        cur.min = Math.min(n1.min, Math.min(n2.min, root.val));
        if (cur.ok && cur.sum > ans) {
            ans = cur.sum;
        }
        return cur;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().maxSumBST(TreeNode.parse("[1,4,3,2,4,2,5,null,null,null,null,null,null,4,6]")));
        System.out.println(new Solution().maxSumBST(TreeNode.parse("[4,3,null,1,2]")));
        System.out.println(new Solution().maxSumBST(TreeNode.parse("[-4,-2,-5]")));
        System.out.println(new Solution().maxSumBST(TreeNode.parse("[2,1,3]")));
        System.out.println(new Solution().maxSumBST(TreeNode.parse("[5,4,8,3,null,6,3]")));
    }
}
