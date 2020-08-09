package match.weekly.weekly201.p4;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {

    int n;
    private int[] cuts;
    private Map<String, Integer> cache;

    private int dfs(int L, int R) {
        final String key = L + "#" + R;
        if (cache.containsKey(key)) {
            return cache.get(key);
        }
        int ans = Integer.MAX_VALUE;
        for (int cut : cuts) {
            if (cut > L && cut < R) {
                ans = Math.min(ans, (R - L) + dfs(L, cut) + dfs(cut, R));
            }
        }
        ans = ans == Integer.MAX_VALUE ? 0 : ans;
        cache.put(key, ans);
        return ans;
    }

    public int minCost(int n, int[] cuts) {
        this.n = n;
        this.cuts = cuts;
        this.cache = new HashMap<>();
        Arrays.sort(this.cuts);
        return dfs(0, n);
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().minCost(7, new int[]{1, 3, 4, 5}));
        System.out.println(new Solution().minCost(9, new int[]{5, 6, 1, 4, 2}));
    }
}
