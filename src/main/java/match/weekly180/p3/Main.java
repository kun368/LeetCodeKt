package match.weekly180.p3;

import utils.java.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> vals = new ArrayList<>();
        dfsCollect(root, vals);
        Collections.sort(vals);
        return buildTree(vals);
    }

    private void dfsCollect(TreeNode root, List<Integer> vals) {
        if (root == null) {
            return;
        }
        vals.add(root.val);
        dfsCollect(root.left, vals);
        dfsCollect(root.right, vals);
    }

    private TreeNode buildTree(List<Integer> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        int mid = list.size() / 2;
        TreeNode root = new TreeNode(list.get(mid));
        root.left = buildTree(list.subList(0, mid));
        root.right = buildTree(list.subList(mid + 1, list.size()));
        return root;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().balanceBST(TreeNode.parse("[1,null,2,null,3,null,4,null,null]")).toJSONString());
    }
}
