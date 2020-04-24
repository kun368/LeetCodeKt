package normal.cat0.cat03.cat032.p322;

import java.util.Arrays;

/**
 * 322. 零钱兑换
 * <p>
 * 背包问题
 */
class Solution {

    private static final int inf = Integer.MAX_VALUE / 2;

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, 1, dp.length, inf);
        for (int i = 1; i <= amount; ++i) {
            for (int coin : coins) {
                if (i < coin) continue;
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }
        return dp[amount] >= inf ? -1 : dp[amount];
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().coinChange(new int[]{1, 2, 5}, 11)); // 3
        System.out.println(new Solution().coinChange(new int[]{2}, 3)); // -1
    }
}
