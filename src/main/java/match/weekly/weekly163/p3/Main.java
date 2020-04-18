package match.weekly.weekly163.p3;

import java.util.Arrays;

class Solution {
    public int maxSumDivThree(int[] nums) {
        int[][] dp = new int[nums.length + 1][3];
        for (int[] ints : dp) Arrays.fill(ints, Integer.MIN_VALUE);
        dp[0][0] = 0;
        for (int i = 1; i <= nums.length; ++i) {
            int cur = nums[i - 1];
            for (int j = 0; j < 3; ++j)
                dp[i][(j + cur) % 3] = Math.max(dp[i - 1][(j + cur) % 3], dp[i - 1][j] + cur);
        }
        return dp[nums.length][0];
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().maxSumDivThree(new int[]{3, 6, 5, 1, 8}));
        System.out.println(new Solution().maxSumDivThree(new int[]{4}));
        System.out.println(new Solution().maxSumDivThree(new int[]{1, 2, 3, 4, 4}));
        System.out.println(new Solution().maxSumDivThree(new int[]{2, 2, 2}));
    }
}
