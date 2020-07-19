package match.weekly.weekly198.p2;

import utils.java.DebugUtils;

import java.util.*;

class Solution {

    private String labels;
    private Map<Integer, List<Integer>> sons;
    private Map<Integer, Integer> ans;
    private Set<Integer> vis;

    public int[] countSubTrees(int n, int[][] edges, String labels) {
        this.labels = labels;
        this.sons = new HashMap<>();
        this.ans = new HashMap<>(n);
        this.vis = new HashSet<>(n);
        for (int[] edge : edges) {
            if (!sons.containsKey(edge[0])) sons.put(edge[0], new ArrayList<>());
            sons.get(edge[0]).add(edge[1]);
            if (!sons.containsKey(edge[1])) sons.put(edge[1], new ArrayList<>());
            sons.get(edge[1]).add(edge[0]);
        }
        dfs(0);
        int[] ret = new int[n];
        for (int i = 0; i < n; ++i) {
            ret[i] = ans.getOrDefault(i, 0);
        }
        return ret;
    }

    private Map<Character, Integer> dfs(int root) {
        vis.add(root);
        Map<Character, Integer> counter = new HashMap<>();
        char c = labels.charAt(root);
        counter.put(c, 1);
        List<Integer> son = sons.get(root);
        if (son != null) {
            for (Integer i : son) {
                if (vis.contains(i)) {
                    continue;
                }
                for (Map.Entry<Character, Integer> entry : dfs(i).entrySet()) {
                    counter.put(entry.getKey(), counter.getOrDefault(entry.getKey(), 0) + entry.getValue());
                }
            }
        }
        ans.put(root, counter.get(c));
        return counter;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().countSubTrees(7, DebugUtils.parseIntArr2("[[0,1],[0,2],[1,4],[1,5],[2,3],[2,6]]"), "abaedcd")));
        System.out.println(Arrays.toString(new Solution().countSubTrees(4, DebugUtils.parseIntArr2("[[0,1],[1,2],[0,3]]"), "bbbb")));
        System.out.println(Arrays.toString(new Solution().countSubTrees(5, DebugUtils.parseIntArr2("[[0,1],[0,2],[1,3],[0,4]]"), "aabab")));
        System.out.println(Arrays.toString(new Solution().countSubTrees(6, DebugUtils.parseIntArr2("[[0,1],[0,2],[1,3],[3,4],[4,5]]"), "cbabaa")));
        System.out.println(Arrays.toString(new Solution().countSubTrees(7, DebugUtils.parseIntArr2("[[0,1],[1,2],[2,3],[3,4],[4,5],[5,6]]"), "aaabaaa")));
        System.out.println(Arrays.toString(new Solution().countSubTrees(4, DebugUtils.parseIntArr2("[[0,2],[0,3],[1,2]]"), "aeed")));
    }
}
