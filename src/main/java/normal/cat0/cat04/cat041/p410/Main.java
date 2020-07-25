package normal.cat0.cat04.cat041.p410;

import java.util.Arrays;

class Solution {
    public int splitArray(int[] nums, int m) {
        int[][] dp = new int[nums.length + 1][m + 1];
        Arrays.stream(dp).forEach(it -> Arrays.fill(it, Integer.MAX_VALUE));
        dp[0][0] = 0;
        for (int i = 1; i <= nums.length; ++i) {
            for (int j = 1; j <= m && j <= i; ++j) {
                int sum = 0;
                for (int lastLen = 1; lastLen <= i - j + 1; ++lastLen) {
                    sum += nums[i - lastLen];
                    dp[i][j] = Math.min(dp[i][j], Math.max(dp[i - lastLen][j - 1], sum));
                }
            }
        }
        return dp[nums.length][m];
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().splitArray(new int[]{7, 2, 5, 10, 8}, 2));
    }
}
