package normal.cat0.cat00.cat009.p95;

import utils.java.TreeNode;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 95. 不同的二叉搜索树 II
 */
class Solution {

    private List<TreeNode> dfs(SortedSet<Integer> ids) {
        if (ids.size() == 0) {
            return Collections.singletonList(null);
        }
        if (ids.size() == 1) {
            return Collections.singletonList(new TreeNode(ids.iterator().next()));
        }
        List<TreeNode> ret = new ArrayList<>();
        for (Integer id : ids) {
            for (TreeNode left : dfs(new TreeSet<>(ids.headSet(id)))) {
                for (TreeNode right : dfs(new TreeSet<>(ids.tailSet(id + 1)))) {
                    ret.add(new TreeNode(id, left, right));
                }
            }
        }
        return ret;
    }

    public List<TreeNode> generateTrees(int n) {
        if (n == 0) return new ArrayList<>();
        return dfs(new TreeSet<>(IntStream.range(1, n + 1).boxed().collect(Collectors.toList())));
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().generateTrees(3));
    }
}
