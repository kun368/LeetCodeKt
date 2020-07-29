package normal.cat0.cat00.cat007.p72;


import java.util.Arrays;

/**
 * 72. 编辑距离
 */
class Solution {
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        Arrays.stream(dp).forEach(it -> Arrays.fill(it, Integer.MAX_VALUE / 2));
        dp[0][0] = 0;
        for (int i = 1; i <= word1.length(); ++i) dp[i][0] = i;
        for (int i = 1; i <= word2.length(); ++i) dp[0][i] = i;
        for (int i = 1; i <= word1.length(); ++i) {
            for (int j = 1; j <= word2.length(); ++j) {
                char c1 = word1.charAt(i - 1);
                char c2 = word2.charAt(j - 1);
                dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1] + (c1 == c2 ? 0 : 1));
                dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + 1);
                dp[i][j] = Math.min(dp[i][j], dp[i][j - 1] + 1);
            }
        }
        return dp[word1.length()][word2.length()];
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().minDistance("horse", "ros"));
        System.out.println(new Solution().minDistance("intention", "execution"));
        System.out.println(new Solution().minDistance("", "a"));
        System.out.println(new Solution().minDistance("", ""));
    }
}
