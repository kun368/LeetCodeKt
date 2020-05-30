package match.biweekly.biweekly27.p4;

import utils.java.DebugUtils;

import java.util.Arrays;

class Solution {

    private int N, M;
    private int[][] grid;
    private int[][][] dp;

    private void collect(int i, int a, int b) {
        dp[i][a][b] = -1;
        int cur = (a == b) ? grid[i][a] : grid[i][a] + grid[i][b];
        for (int x = a - 1; x <= a + 1; ++x) {
            for (int y = b - 1; y <= b + 1; ++y) {
                if (x < 0 || y < 0 || x >= M || y >= M) continue;
                int v = dp[i - 1][x][y];
                if (v >= 0) {
                    dp[i][a][b] = Math.max(dp[i][a][b], cur + dp[i - 1][x][y]);
                }
            }
        }
    }

    public int cherryPickup(int[][] grid) {
        this.N = grid.length;
        this.M = grid[0].length;
        this.grid = grid;
        this.dp = new int[N + 1][M + 1][M + 1];

        for (int[] i : dp[0]) {
            Arrays.fill(i, -1);
        }
        this.dp[0][0][M - 1] = grid[0][0] + grid[0][M - 1];

        int ans = 0;
        for (int i = 1; i < N; ++i) {
            for (int a = 0; a < M; ++a) {
                for (int b = 0; b < M; ++b) {
                    collect(i, a, b);
                    if (i == N - 1) {
                        ans = Math.max(ans, dp[i][a][b]);
                    }
                }
            }
        }
        return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().cherryPickup(DebugUtils.parseIntArr2("[[3,1,1],[2,5,1],[1,5,5],[2,1,1]]")));
        System.out.println(new Solution().cherryPickup(DebugUtils.parseIntArr2("[[1,0,0,0,0,0,1],[2,0,0,0,0,3,0],[2,0,9,0,0,0,0],[0,3,0,5,4,0,0],[1,0,2,3,0,0,6]]")));
        System.out.println(new Solution().cherryPickup(DebugUtils.parseIntArr2("[[1,0,0,3],[0,0,0,3],[0,0,3,3],[9,0,3,3]]")));
        System.out.println(new Solution().cherryPickup(DebugUtils.parseIntArr2("[[1,1],[1,1]]")));
        // 96
        System.out.println(new Solution().cherryPickup(DebugUtils.parseIntArr2("[[0,8,7,10,9,10,0,9,6],[8,7,10,8,7,4,9,6,10],[8,1,1,5,1,5,5,1,2],[9,4,10,8,8,1,9,5,0],[4,3,6,10,9,2,4,8,10],[7,3,2,8,3,3,5,9,8],[1,2,6,5,6,2,0,10,0]]")));
    }
}
