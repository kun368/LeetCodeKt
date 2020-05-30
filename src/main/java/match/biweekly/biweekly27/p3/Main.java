package match.biweekly.biweekly27.p3;

import utils.java.DebugUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {

    private Map<Integer, List<Integer>> G;
    private Map<String, Boolean> cache;

    private boolean check(int x, int y) {
        final String key = x + "#" + y;
        if (cache.containsKey(key)) {
            return cache.get(key);
        }
        boolean result = false;
        List<Integer> son = G.get(x);
        if (son != null) {
            for (Integer i : son) {
                if (i.equals(y)) {
                    result = true;
                    break;
                }
                if (check(i, y)) {
                    result = true;
                    break;
                }
            }
        }
        cache.put(key, result);
        return result;
    }


    public List<Boolean> checkIfPrerequisite(int n, int[][] prerequisites, int[][] queries) {
        this.G = new HashMap<>();
        this.cache = new HashMap<>();
        for (int[] prerequisite : prerequisites) {
            int from = prerequisite[0], to = prerequisite[1];
            if (!G.containsKey(from))
                G.put(from, new ArrayList<>());
            G.get(from).add(to);
        }
        List<Boolean> ret = new ArrayList<>();
        for (int[] query : queries) {
            ret.add(check(query[0], query[1]));
        }
        return ret;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().checkIfPrerequisite(2,
                DebugUtils.parseIntArr2("[[1,0]]"),
                DebugUtils.parseIntArr2("[[0,1],[1,0]]")
        ));
        System.out.println(new Solution().checkIfPrerequisite(2,
                DebugUtils.parseIntArr2("[]"),
                DebugUtils.parseIntArr2("[[1,0],[0,1]]")
        ));
        System.out.println(new Solution().checkIfPrerequisite(3,
                DebugUtils.parseIntArr2("[[1,2],[1,0],[2,0]]"),
                DebugUtils.parseIntArr2("[[1,0],[1,2]]")
        ));
        System.out.println(new Solution().checkIfPrerequisite(3,
                DebugUtils.parseIntArr2("[[1,0],[2,0]]"),
                DebugUtils.parseIntArr2("[[0,1],[2,0]]")
        ));
        System.out.println(new Solution().checkIfPrerequisite(5,
                DebugUtils.parseIntArr2("[[0,1],[1,2],[2,3],[3,4]]"),
                DebugUtils.parseIntArr2("[[0,4],[4,0],[1,3],[3,0]]")
        ));
        System.out.println(new Solution().checkIfPrerequisite(5,
                DebugUtils.parseIntArr2("[[0,1],[1,2],[2,3],[3,4]]"),
                DebugUtils.parseIntArr2("[[0,4],[4,0],[1,3],[3,0]]")
        ));
    }
}
