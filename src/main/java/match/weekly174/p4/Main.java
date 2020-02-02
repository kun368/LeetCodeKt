package match.weekly174.p4;

import utils.java.DebugUtils;

import java.util.HashMap;
import java.util.Map;

class Solution {

    private static final Map<Integer, Integer> dp = new HashMap<>();

    public int maxJumps(int[] arr, int d) {
        dp.clear();
        int ans = 0;
        for (int i = 0; i < arr.length; ++i) {
            ans = Math.max(ans, dfs(arr, i, d));
        }
        return ans;
    }

    private int dfs(int[] arr, int cur, int d) {
        if (dp.containsKey(cur)) {
            return dp.get(cur);
        }
        int ret = 1;
        for (int i = cur - 1; i >= 0 && i >= cur - d && arr[i] < arr[cur]; --i) {
            ret = Math.max(ret, dfs(arr, i, d) + 1);
        }
        for (int i = cur + 1; i < arr.length && i <= cur + d && arr[i] < arr[cur]; ++i) {
            ret = Math.max(ret, dfs(arr, i, d) + 1);
        }
        dp.put(cur, ret);
        return ret;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().maxJumps(DebugUtils.parseIntArr1("[6,4,14,6,8,13,9,7,10,6,12]"), 2));
        System.out.println(new Solution().maxJumps(DebugUtils.parseIntArr1("[3,3,3,3,3]"), 3));
        System.out.println(new Solution().maxJumps(DebugUtils.parseIntArr1("[7,6,5,4,3,2,1]"), 1));
        System.out.println(new Solution().maxJumps(DebugUtils.parseIntArr1("[7,1,7,1,7,1]"), 2));
        System.out.println(new Solution().maxJumps(DebugUtils.parseIntArr1("[66]"), 1));
    }
}
