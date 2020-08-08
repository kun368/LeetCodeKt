package normal.cat0.cat00.cat009.p99.v1;

import utils.java.TreeNode;

import java.util.*;

class Solution {

    private Map<TreeNode, Integer> leftSize;
    private List<Integer> valList;

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = dfs(root.left);
        int r = dfs(root.right);
        leftSize.put(root, l);
        valList.add(root.val);
        return l + r + 1;
    }

    private void rebuild(TreeNode root, List<Integer> valList) {
        if (root == null || valList.isEmpty()) {
            return;
        }
        int l = leftSize.get(root);
        root.val = valList.get(l);
        rebuild(root.left, new ArrayList<>(valList.subList(0, l)));
        rebuild(root.right, new ArrayList<>(valList.subList(l +1, valList.size())));
    }

    public void recoverTree(TreeNode root) {
        leftSize = new HashMap<>();
        valList = new ArrayList<>();
        dfs(root);
        Collections.sort(valList);
        rebuild(root, valList);
    }
}

public class Main {
    public static void main(String[] args) {
        new Solution().recoverTree(TreeNode.parse("[1,3,null,null,2]"));
        new Solution().recoverTree(TreeNode.parse("[3,1,4,null,null,2]"));
    }
}
