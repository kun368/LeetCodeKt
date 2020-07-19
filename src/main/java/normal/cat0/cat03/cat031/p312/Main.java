package normal.cat0.cat03.cat031.p312;

import java.util.Arrays;

/**
 * 312. 戳气球
 */
class Solution {

    private int[] nums;
    private int[][] dp;

    private int get(int idx) {
        return idx >= 0 & idx < nums.length ? nums[idx] : 1;
    }

    private int dfs(int l, int r) {
        if (l > r) return 0;
        if (dp[l][r] >= 0) {
            return dp[l][r];
        }
        int ans = 0;
        int outer = get(l - 1) * get(r + 1);
        for (int i = l; i <= r; ++i) {
            ans = Math.max(ans, nums[i] * outer + dfs(l, i - 1) + dfs(i + 1, r));
        }
        return dp[l][r] = ans;
    }

    public int maxCoins(int[] nums) {
        int N = nums.length;
        this.nums = nums;
        this.dp = new int[N + 1][N + 1];
        Arrays.stream(dp).forEach(it -> Arrays.fill(it, -1));
        return dfs(0, N - 1);
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().maxCoins(new int[]{3, 1, 5, 8}));
    }
}
