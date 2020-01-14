package match.weekly171.p4;


import java.util.Arrays;

class Solution {

    private static final int MAX = 0x3f3f3f3f;

    private int dis(int x, int y) {
        return Math.abs((x / 6) - (y / 6)) + Math.abs((x % 6) - (y % 6));
    }

    public int minimumDistance(String word) {
        int N = word.length();
        int[][][] dp = new int[N + 1][27][27];
        for (int i = 1; i <= N; ++i) {
            for (int j = 0; j < dp[i].length; ++j) {
                Arrays.fill(dp[i][j], MAX);
            }
        }
        int ans = MAX;
        for (int i = 1; i <= N; ++i) {
            int cur = word.charAt(i - 1) - 'A';
            for (int j = 0; j < 26; ++j) {
                for (int k = 0; k < 26; ++k) {
                    dp[i][cur][k] = Math.min(dp[i][cur][k], dp[i-1][j][k] + dis(j, cur));
                    dp[i][j][cur] = Math.min(dp[i][j][cur], dp[i-1][j][k] + dis(k, cur));
                    if (i == N) {
                        ans = Math.min(ans, Math.min(dp[i][cur][k], dp[i][j][cur]));
                    }
                }
            }
        }
        return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().minimumDistance("CAKE"));
        System.out.println(new Solution().minimumDistance("HAPPY"));
        System.out.println(new Solution().minimumDistance("NEW"));
        System.out.println(new Solution().minimumDistance("YEAR"));
    }
}
