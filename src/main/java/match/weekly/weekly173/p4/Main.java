package match.weekly.weekly173.p4;

import utils.java.DebugUtils;

class Solution {

    private static final int MAX = Integer.MAX_VALUE / 2;

    public int minDifficulty(int[] jobDifficulty, int d) {
        int N = jobDifficulty.length;
        if (d > N) {
            return -1;
        }
        int[][] dp = new int[N + 1][d + 1];
        for (int i = 0; i <= N; ++i) {
            for (int j = 0; j <= d; ++j) {
                if (i == 0 && j == 0) {
                    dp[i][j] = 0;
                } else if (j == 0) {
                    dp[i][j] = MAX;
                } else if (j > i) {
                    dp[i][j] = MAX;
                } else {
                    dp[i][j] = MAX;
                    int t = 0;
                    for (int k = i - 1; k >= 0; --k) {
                        t = Math.max(t, jobDifficulty[k]);
                        dp[i][j] = Math.min(dp[i][j], dp[k][j - 1] + t);
                    }
                }
            }
        }
        return dp[N][d];
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().minDifficulty(DebugUtils.parseIntArr1("[6,5,4,3,2,1]"), 2));
        System.out.println(new Solution().minDifficulty(DebugUtils.parseIntArr1("[9,9,9]"), 4));
        System.out.println(new Solution().minDifficulty(DebugUtils.parseIntArr1("[1,1,1]"), 3));
        System.out.println(new Solution().minDifficulty(DebugUtils.parseIntArr1("[7,1,7,1,7,1]"), 3));
        System.out.println(new Solution().minDifficulty(DebugUtils.parseIntArr1("[11,111,22,222,33,333,44,444]"), 6));
    }
}
