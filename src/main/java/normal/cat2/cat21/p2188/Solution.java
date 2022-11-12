package normal.cat2.cat21.p2188;

import utils.java.DebugUtils;

import java.util.Arrays;

class Solution {
    public int minimumFinishTime(int[][] tires, int changeTime, int numLaps) {
        int[] cu = new int[numLaps + 5];
        Arrays.fill(cu, Integer.MAX_VALUE / 2);
        for (int[] tire : tires) {
            int f = tire[0], r = tire[1];
            int cost = f, acc = f + changeTime;
            cu[0] = Math.min(cu[0], acc);
            for (int i = 1; cost <= f + changeTime && i < cu.length; ++i) {
                cost *= r;
                acc += cost;
                cu[i] = Math.min(cu[i], acc);
            }
        }

        int[] dp = new int[numLaps + 5];
        for (int i = 1; i <= numLaps; ++i) {
            dp[i] = cu[i - 1];
            for (int j = 1; j < i; ++j) {
                dp[i] = Math.min(dp[i], dp[j] + dp[i - j]);
            }
        }
        return dp[numLaps] - changeTime;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minimumFinishTime(
                DebugUtils.parseIntArr2("[[2,3],[3,4]]"), 5, 4
        ));
        System.out.println(new Solution().minimumFinishTime(
                DebugUtils.parseIntArr2("[[1,10],[2,2],[3,4]]"), 6, 5
        ));
    }
}
