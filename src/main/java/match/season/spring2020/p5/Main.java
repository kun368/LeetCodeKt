package match.season.spring2020.p5;

import utils.java.TreeNode;

class Solution {

    private static class Node {
        double singleTime, parallelTime;

        public Node(double singleTime, double parallelTime) {
            this.singleTime = singleTime;
            this.parallelTime = parallelTime;
        }
    }

    public double minimalExecTime(TreeNode root) {
        Node ans = dfs(root);
        return ans.singleTime + ans.parallelTime;
    }

    private Node dfs(TreeNode root) {
        if (root == null) {
            return new Node(0, 0);
        }
        Node nl = dfs(root.left), nr = dfs(root.right);
        double totl = nl.parallelTime * 2 + nl.singleTime;
        double totr = nr.parallelTime * 2 + nr.singleTime;
        double single1 = Math.abs(nl.singleTime - nr.singleTime);
        double single2;
        if (nl.singleTime >= nr.singleTime) {
            single2 = Math.max(nl.singleTime - totr, 0);
        } else {
            single2 = Math.max(nr.singleTime - totl, 0);
        }
        double single = Math.min(single1, single2);
        return new Node(single + root.val, (totl + totr - single) / 2.0);
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().minimalExecTime(TreeNode.parse("[47, 74, 31]")));
        System.out.println(new Solution().minimalExecTime(TreeNode.parse("[15, 21, null, 24, null, 27, 26]")));
        System.out.println(new Solution().minimalExecTime(TreeNode.parse("[1,3,2,null,null,4,4]")));
    }
}
