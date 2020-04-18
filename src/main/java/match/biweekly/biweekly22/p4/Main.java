package match.biweekly.biweekly22.p4;

class Solution {
    public int maxSizeSlices(int[] slices) {
        int N = slices.length;
        int[][][] dp = new int[2][N][N / 3 + 1];
        for (int i = 0; i < N - 1; ++i) {
            for (int j = 1; j <= N / 3; ++j) {
                dp[0][i][j] = Math.max(i == 0 ? 0 : dp[0][i - 1][j], i <= 1 ? slices[i] : slices[i] + dp[0][i - 2][j - 1]);
            }
        }
        for (int i = 1; i < N; ++i) {
            for (int j = 1; j <= N / 3; ++j) {
                dp[1][i][j] = Math.max(dp[1][i - 1][j], i <= 1 ? slices[i] : slices[i] + dp[1][i - 2][j - 1]);
            }
        }
        return Math.max(dp[0][N - 2][N / 3], dp[1][N - 1][N / 3]);
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().maxSizeSlices(new int[]{1, 2, 3, 4, 5, 6}));
        System.out.println(new Solution().maxSizeSlices(new int[]{8, 9, 8, 6, 1, 1}));
        System.out.println(new Solution().maxSizeSlices(new int[]{4, 1, 2, 5, 8, 3, 1, 9, 7}));
        System.out.println(new Solution().maxSizeSlices(new int[]{3, 1, 2}));
    }
}
