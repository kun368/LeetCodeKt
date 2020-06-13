package match.biweekly.biweekly28.p4;


import java.util.Arrays;

class Solution {

    private static final int MAX = Integer.MAX_VALUE / 2;
    private int[] houses;

    private int calc(int st, int ed) {
        int len = ed - st + 1;
        int mid;
        if (len % 2 == 0) {
            mid = (houses[st + len / 2 - 1] + houses[st + len / 2]) / 2;
        } else {
            mid = houses[st + len / 2];
        }
        int sum = 0;
        for (int i = st; i <= ed; ++i) {
            sum += Math.abs(mid - houses[i]);
        }
        return sum;
    }

    public int minDistance(int[] houses, int k) {
        this.houses = houses;
        Arrays.sort(houses);
        int N = houses.length;
        int[][] dp = new int[N + 5][k + 5];
        for (int i = 1; i <= N; ++i) {
            for (int j = 0; j <= k; ++j) {
                if (i == 0) {
                    dp[i][j] = 0;
                } else if (j == 0) {
                    dp[i][j] = MAX;
                } else if (i == 1) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = MAX;
                    for (int t = i; t >= 1; --t) {
                        dp[i][j] = Math.min(dp[i][j], dp[t - 1][j - 1] + calc(t - 1, i - 1));
                    }
                }
            }
        }
        return dp[N][k];
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().minDistance(new int[]{1, 4, 8, 10, 20}, 3));
        System.out.println(new Solution().minDistance(new int[]{2, 3, 5, 12, 18}, 2));
        System.out.println(new Solution().minDistance(new int[]{7, 4, 6, 1}, 1));
        System.out.println(new Solution().minDistance(new int[]{3, 6, 14, 10}, 4));
    }
}
