package match.biweekly.biweekly23.p4;

import java.util.Arrays;

class Solution {
    public int maxSatisfaction(int[] satisfaction) {
        int N = satisfaction.length;
        Arrays.sort(satisfaction);
        int[][] dp = new int[N + 5][N + 5];
        int ans = 0;
        for (int i = 1; i <= N; ++i) {
            for (int j = 0; j <= N; ++j) {
                if (j < i) {
                    dp[i][j] = Integer.MIN_VALUE;
                    continue;
                }
                dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j - 1] + i * satisfaction[j - 1]);
                ans = Math.max(ans, dp[i][j]);
            }
        }
        return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().maxSatisfaction(new int[]{-1, -8, 0, 5, -9}));
        System.out.println(new Solution().maxSatisfaction(new int[]{4, 3, 2}));
        System.out.println(new Solution().maxSatisfaction(new int[]{-1, -4, -5}));
        System.out.println(new Solution().maxSatisfaction(new int[]{-2, 5, -1, 0, 3, -3}));
    }
}
