package normal.cat0.cat00.cat006.p64.v2;

class Solution {
    public int minPathSum(int[][] grid) {
        int N = grid.length, M = grid[0].length;
        int[][] dp = new int[N][M];
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < M; ++j) {
                dp[i][j] = Integer.MAX_VALUE;
                if (i == 0 && j == 0) {
                    dp[i][j] = grid[i][j];
                }
                if (i > 0) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + grid[i][j]);
                }
                if (j > 0) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][j - 1] + grid[i][j]);
                }
            }
        }
        return dp[N - 1][M - 1];
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().minPathSum(new int[][]{
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        }));
    }
}
