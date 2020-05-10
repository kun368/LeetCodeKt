package match.weekly.weekly188.p3;


import utils.java.DebugUtils;

import java.util.*;

class Solution {

    private List<Boolean> hasApple;
    private Map<Integer, List<Integer>> tree;

    private int dfs(int root) {
        List<Integer> son = tree.get(root);
        if (son == null) {
            return hasApple.get(root) ? 1 : 0;
        }
        int sum = 0;
        for (Integer i : son) {
            sum += dfs(i);
        }
        if (sum == 0) {
            return hasApple.get(root) ? 1 : 0;
        } else {
            return sum + 1;
        }
    }

    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        this.hasApple = hasApple;
        this.tree = new HashMap<>();
        for (int[] edge : edges) {
            if (!tree.containsKey(edge[0]))
                tree.put(edge[0], new ArrayList<>());
            tree.get(edge[0]).add(edge[1]);
        }
        int sum = dfs(0);
        return sum == 0 ? 0 : (sum - 1) * 2;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().minTime(7,
                DebugUtils.parseIntArr2("[[0,1],[0,2],[1,4],[1,5],[2,3],[2,6]]"),
                Arrays.asList(false, false, true, false, true, true, false)));
        System.out.println(new Solution().minTime(7,
                DebugUtils.parseIntArr2("[[0,1],[0,2],[1,4],[1,5],[2,3],[2,6]]"),
                Arrays.asList(false, false, true, false, false, true, false)));
        System.out.println(new Solution().minTime(7,
                DebugUtils.parseIntArr2("[[0,1],[0,2],[1,4],[1,5],[2,3],[2,6]]"),
                Arrays.asList(false, false, false, false, false, false, false)));
    }
}
