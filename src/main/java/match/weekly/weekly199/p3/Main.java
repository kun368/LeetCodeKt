package match.weekly.weekly199.p3;

import utils.java.TreeNode;

import java.util.HashMap;
import java.util.Map;

class Solution {

    static class Node {
        int count = 0;
        Map<TreeNode, Integer> dis = new HashMap<>();
    }

    private Node dfs(TreeNode root, int distance) {
        if (root.left == null && root.right == null) {
            Node node = new Node();
            node.dis.put(root, 1);
            return node;
        }
        Node left = root.left == null ? null : dfs(root.left, distance);
        Node right = root.right == null ? null : dfs(root.right, distance);
        Node current = new Node();
        current.count = (left != null ? left.count : 0) + (right != null ? right.count : 0);
        if (left != null && right != null) {
            for (Map.Entry<TreeNode, Integer> a : left.dis.entrySet()) {
                for (Map.Entry<TreeNode, Integer> b : right.dis.entrySet()) {
                    if (a.getValue() + b.getValue() <= distance) {
                        current.count += 1;
                    }
                }
            }
        }
        if (left != null) {
            for (Map.Entry<TreeNode, Integer> a : left.dis.entrySet()) {
                current.dis.put(a.getKey(), a.getValue() + 1);
            }
        }
        if (right != null) {
            for (Map.Entry<TreeNode, Integer> a : right.dis.entrySet()) {
                current.dis.put(a.getKey(), a.getValue() + 1);
            }
        }
        return current;
    }

    public int countPairs(TreeNode root, int distance) {
        return dfs(root, distance).count;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().countPairs(TreeNode.parse("[1,2,3,null,4]"), 3));
        System.out.println(new Solution().countPairs(TreeNode.parse("[1,2,3,4,5,6,7]"), 3));
        System.out.println(new Solution().countPairs(TreeNode.parse("[7,1,4,6,null,5,3,null,null,null,null,null,2]"), 3));
        System.out.println(new Solution().countPairs(TreeNode.parse("[100]"), 1));
        System.out.println(new Solution().countPairs(TreeNode.parse("[1,1,1]"), 2));
        System.out.println(new Solution().countPairs(TreeNode.parse("[6,46,5,23,71,29,53,35,11,9,95,20,50,44,10,30,4,17,1,17,24,64,23,50,85,27,59,26,34,94,88,48,29,42,74,36,29,88,43,46,60,51,65,42,1,51,44,15,89,97,53,75,58,61,82,66,79,48,80,59,99,6,1,68,27,42,65,53,25,42,4,68,28,66,31,87,26,12,23,86,58,63,31,24,86,63,45,20,13,86,53,94,82,46,10,11,77,82,5,57,39,76,5,74,64,91,63,68,42,31,5,26,27,71,39,11,37,13,7,98,97,10,2,75,22,73,25,30,58,29,55,9,24,82,14,11,81,92,96]"), 9));

    }
}
