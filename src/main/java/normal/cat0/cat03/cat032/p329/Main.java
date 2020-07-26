package normal.cat0.cat03.cat032.p329;


class Solution {

    private static final int[][] dir = {{0, 0}, {0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    private int[][] matrix;
    private int[][] dp;

    private boolean isIn(int x, int y) {
        return x >= 0 && y >= 0 && x < matrix.length && y < matrix[0].length;
    }

    private int dfs(int x, int y) {
        if (dp[x][y] > 0) {
            return dp[x][y];
        }
        dp[x][y] = 1;
        for (int[] d : dir) {
            int xx = x + d[0], yy = y + d[1];
            if (isIn(xx, yy) && matrix[xx][yy] > matrix[x][y]) {
                dp[x][y] = Math.max(dp[x][y], 1 + dfs(xx, yy));
            }
        }
        return dp[x][y];
    }

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        this.matrix = matrix;
        this.dp = new int[matrix.length][matrix[0].length];
        int max = 1;
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[0].length; ++j) {
                max = Math.max(max, dfs(i, j));
            }
        }
        return max;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().longestIncreasingPath(new int[][]{
                {9, 9, 4},
                {6, 6, 8},
                {2, 1, 1}
        }));
        System.out.println(new Solution().longestIncreasingPath(new int[][]{
                {3, 4, 5},
                {3, 2, 6},
                {2, 2, 1}
        }));
    }
}
