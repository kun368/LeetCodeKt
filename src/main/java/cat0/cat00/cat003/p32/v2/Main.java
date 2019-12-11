package cat0.cat00.cat003.p32.v2;


/**
 * 动态规划
 * dp[i] = 以i结尾的最长合法串长度
 */
class Solution {
    public int longestValidParentheses(String s) {
        int[] dp = new int[s.length() + 5];
        int ans = 0;
        for (int i = 1; i < s.length(); ++i) {
            if (s.charAt(i) == '(') {
                continue;
            }
            int pre = i - dp[i - 1] - 1;
            if (pre >= 0 && s.charAt(pre) == '(') {
                dp[i] = dp[i - 1] + 2;
                if (i - dp[i] >= 0) {
                    dp[i] += dp[i - dp[i]];
                }
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}


public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().longestValidParentheses("(()"));
        System.out.println(new Solution().longestValidParentheses(")()())"));
        System.out.println(new Solution().longestValidParentheses("()(())"));

    }
}
