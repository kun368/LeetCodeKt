package match.weekly.weekly165.p3;

class Solution {

    private int sum(int[][] dp) {
        int ans = 0;
        for (int[] ints : dp) {
            for (int i : ints) ans += i;
        }
        return ans;
    }

    public int countSquares(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int[][] from = new int[n][m];
        int[][] to = new int[n][m];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) from[i][j] = mat[i][j];
        }
        int ans = sum(from);
        for (int len = 2; len <= Math.min(n, m); ++len) {
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < m; ++j) {
                    if (i - len < -1 || j - len < -1) {
                        to[i][j] = 0;
                    } else if (mat[i][j] > 0 && mat[i - len + 1][j - len + 1] > 0 && from[i - 1][j] > 0 && from[i][j - 1] > 0) {
                        to[i][j] = 1;
                    } else {
                        to[i][j] = 0;
                    }
                }
            }
            // System.out.println("len = " + len + ", arr = " + Arrays.deepToString(to));
            int[][] t = to;
            to = from;
            from = t;
            ans += sum(from);
        }
        return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().countSquares(new int[][]{
                {0, 1, 1, 1},
                {1, 1, 1, 1},
                {0, 1, 1, 1}
        }));
        System.out.println(new Solution().countSquares(new int[][]{
                {1, 0, 1},
                {1, 1, 0},
                {1, 1, 0}
        }));
    }
}
