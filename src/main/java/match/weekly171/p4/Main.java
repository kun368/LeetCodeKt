package match.weekly171.p4;


class Solution {

    private static final int MAX = 0x3f3f3f3f;

    private int dis(String s, int x, int y) {
        if (x == 0) {
            return 0;
        }
        int a = s.charAt(x - 1) - 'A';
        int b = s.charAt(y - 1) - 'A';
        int ax = a / 6, ay = a % 6;
        int bx = b / 6, by = b % 6;
        // System.out.println("dis, x = " + (char) (a + 'A') + ", y = " + (char) (b + 'A') + ", ret = " + (Math.abs(ax - bx) + Math.abs(ay - by)));
        return Math.abs(ax - bx) + Math.abs(ay - by);
    }

    public int minimumDistance(String word) {
        int N = word.length();
        int[] psum = new int[N + 1];
        for (int i = 1; i <= N; ++i) {
            psum[i] = psum[i - 1] + dis(word, i - 1, i);
        }
        int[][] dp = new int[N + 1][N + 1];
        for (int i = 0; i <= N; ++i) {  // 0
            for (int j = 0; j <= N; ++j) { // 1
                if (i == j) {
                    dp[i][j] = MAX;
                } else if (i == 0 || j == 0) {
                    dp[i][j] = psum[Math.max(i, j)];
                } else {
                    dp[i][j] = MAX;
                    int end = Math.min(i, j) - 1;
                    int add = psum[Math.max(i, j)] - psum[end + 2];
                    for (int k = 0; k < end; ++k) {
                        dp[i][j] = Math.min(dp[i][j], dp[end][k] + dis(word, end, i) + dis(word, k, end + 2) + add);
                        dp[i][j] = Math.min(dp[i][j], dp[k][end] + dis(word, k, i) + dis(word, end, end + 2) + add);
                    }
                }
                 System.out.println("i = " + i + ", j = " + j + ", ans = " + dp[i][j]);
            }
        }
        int ans = MAX;
        for (int k = 0; k < N; ++k) {
            ans = Math.min(ans, dp[N][k]);
            ans = Math.min(ans, dp[k][N]);
        }
        return ans;
    }
}

public class Main {
    public static void main(String[] args) {
//        System.out.println(new Solution().minimumDistance("CAKE"));
        System.out.println(new Solution().minimumDistance("HAPPY"));
//        System.out.println(new Solution().minimumDistance("NEW"));
//        System.out.println(new Solution().minimumDistance("YEAR"));
    }
}
