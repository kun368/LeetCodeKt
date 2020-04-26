package normal.cat0.cat01.cat010.p102;

import utils.java.TreeNode;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        dfs(lists, root, 0);
        return lists;
    }

    private void dfs(List<List<Integer>> lists, TreeNode root, int dep) {
        if (root == null) {
            return;
        }
        while (lists.size() <= dep) {
            lists.add(new ArrayList<>());
        }
        lists.get(dep).add(root.val);
        dfs(lists, root.left, dep + 1);
        dfs(lists, root.right, dep + 1);
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().levelOrder(TreeNode.parse("[3,9,20,null,null,15,7]")));
    }
}
