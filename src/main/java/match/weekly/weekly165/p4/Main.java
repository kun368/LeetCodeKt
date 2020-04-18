package match.weekly.weekly165.p4;

class Solution {

    private int getDiff(String s, int l, int r) {
        int ans = 0;
        for (int i = 0; l + i <= r - i; ++i) {
            if (s.charAt(l + i) != s.charAt(r - i)) ans += 1;
        }
        return ans;
    }

    public int palindromePartition(String s, int k) {
        int N = s.length();
        int[][] chg = new int[N + 1][N + 1];
        int[][] dp = new int[N + 1][N + 1];
        for (int i = 0; i < N; ++i) {
            for (int j = i; j < N; ++j) {
                chg[i + 1][j + 1] = getDiff(s, i, j);
            }
        }
        for (int i = 1; i <= N; ++i) {
            for (int j = 1; j <= i; ++j) {
                if (j == 1) {
                    dp[i][j] = chg[1][i];
                } else {
                    dp[i][j] = 0x3f3f3f3f;
                    for (int t = 1; t <= i - j + 1; ++t) {
                        dp[i][j] = Math.min(dp[i][j], dp[i - t][j - 1] + chg[i - t + 1][i]);
                    }
                }
            }
        }
        return dp[N][k];
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().palindromePartition("abc", 2));
        System.out.println(new Solution().palindromePartition("aabbc", 3));
        System.out.println(new Solution().palindromePartition("leetcode", 8));
    }
}
