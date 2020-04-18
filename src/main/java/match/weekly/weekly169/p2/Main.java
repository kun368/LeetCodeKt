package match.weekly.weekly169.p2;


import utils.java.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> ret = new ArrayList<>();
        dfs(root1, ret);
        dfs(root2, ret);
        Collections.sort(ret);
        return ret;
    }

    void dfs(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        dfs(root.left, list);
        dfs(root.right, list);
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
