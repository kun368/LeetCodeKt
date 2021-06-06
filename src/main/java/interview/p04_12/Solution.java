package interview.p04_12;

import utils.java.TreeNode;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int pathSum(TreeNode root, int sum) {
        List<List<Integer>> all = new ArrayList<>();
        dfs(new ArrayList<>(), root, 0, sum, all);
        System.out.println(all);
        return all.size();
    }

    private void dfs(List<Integer> path, TreeNode root, int sum, int target, List<List<Integer>> all) {
        if (root == null) {
            return;
        }
        path.add(root.val);
        int curSum = sum + root.val;
        if (curSum == target) {
            all.add(new ArrayList<>(path));
        }
        dfs(path, root.left, curSum, target, all);
        dfs(path, root.right, curSum, target, all);
        path.remove(path.size() - 1);
    }
}