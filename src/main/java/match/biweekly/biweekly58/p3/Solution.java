package match.biweekly.biweekly58.p3;

import java.util.Arrays;

class Solution {

    public int minSpaceWastedKResizing(int[] nums, int k) {
        int N = nums.length;
        int[][] dp = new int[N + 1][k + 1];
        int max = 0, sum = 0;
        Arrays.fill(dp[0], 0);
        for (int i = 0; i < N; ++i) {
            max = Math.max(max, nums[i]);
            sum += nums[i];
            Arrays.fill(dp[i + 1], max * (i + 1) - sum);
        }
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < k; ++j) {
                int tmax = 0, tsum = 0;
                for (int t = i + 1; t < N; ++t) {
                    tmax = Math.max(tmax, nums[t]);
                    tsum += nums[t];
                    dp[t + 1][j + 1] = Math.min(dp[t + 1][j + 1], dp[i + 1][j] + tmax * (t - i) - tsum);
                }
            }
        }
        return dp[N][k];
    }


    public static void main(String[] args) {
        System.out.println(new Solution().minSpaceWastedKResizing(new int[]{10, 20}, 0));
        System.out.println(new Solution().minSpaceWastedKResizing(new int[]{10, 20, 30}, 1));
        System.out.println(new Solution().minSpaceWastedKResizing(new int[]{10, 20, 15, 30, 20}, 2));
        System.out.println(new Solution().minSpaceWastedKResizing(new int[]{2, 48, 18, 16, 15, 9, 48, 7, 44, 48}, 1)); // 179
    }
}
