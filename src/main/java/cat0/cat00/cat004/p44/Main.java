package cat0.cat00.cat004.p44;


class Solution {
    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length() + 5][p.length() + 5];
        dp[0][0] = true;

        for (int j = 1; j <= p.length(); ++j) {
            char cur = p.charAt(j - 1);
            if (cur == '?') {
                for (int i = 1; i <= s.length(); ++i) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
            } else if (cur == '*') {
                boolean ok = false;
                for (int i = 0; i <= s.length(); ++i) {
                    if (dp[i][j - 1]) ok = true;
                    dp[i][j] = ok;
                }
            } else {
                for (int i = 1; i <= s.length(); ++i) {
                    dp[i][j] = cur == s.charAt(i - 1) && dp[i - 1][j - 1];
                }
            }
        }
        return dp[s.length()][p.length()];
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().isMatch("aa", "a"));
        System.out.println(new Solution().isMatch("aa", "*"));
        System.out.println(new Solution().isMatch("cb", "?a"));
        System.out.println(new Solution().isMatch("adceb", "*a*b"));
        System.out.println(new Solution().isMatch("acdcb", "a*c?b"));
    }
}
