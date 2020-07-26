package match.weekly.weekly199.p4;


import java.util.Arrays;

class Solution {

    public int len(String s) {
        int c = 0, cnt = 0;
        int ret = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) != c) {
                ret += ((c == 0 ? 0 : 1) + (cnt <= 1 ? 0 : String.valueOf(cnt).length()));
                c = s.charAt(i);
                cnt = 1;
            } else {
                cnt += 1;
            }
        }
        ret += ((c == 0 ? 0 : 1) + (cnt <= 1 ? 0 : String.valueOf(cnt).length()));
        return ret;
    }

    public int getLengthOfOptimalCompression(String s, int k) {
        if (k == 0) {
            return len(s);
        }
        int[][] dp = new int[s.length()][k + 1];
        String[][] dps = new String[s.length()][k + 1];
        Arrays.stream(dp).forEach(it -> Arrays.fill(it, Integer.MAX_VALUE / 2));
        Arrays.stream(dps).forEach(it -> Arrays.fill(it, ""));
        dp[0][0] = 1;
        dp[0][1] = 0;
        dps[0][0] = s.substring(0, 1);
        for (int i = 1; i < s.length(); ++i) {
            for (int j = 0; j <= k && j <= i + 1; ++j) {
                if (j == 0) {
                    dps[i][j] = s.substring(0, i + 1);
                    dp[i][j] = len(dps[i][j]);
                } else {
                    for (int t = 0; t <= i - 1; ++t) {
                        String cur = dps[t][j - 1] + s.substring(t + 1, i);
                        int curLen = len(cur);
                        if (curLen < dp[i][j]) {
                            dps[i][j] = cur;
                            dp[i][j] = curLen;
                        }
                    }
                }
                System.out.println(String.format("dp[%d][%d] = %d, %s", i, j, dp[i][j], dps[i][j]));
            }
        }
        int ans = Integer.MAX_VALUE / 2;
        for (int i = 0; i < s.length(); ++i) {
            String cur = dps[i][k] + s.substring(i + 1);
            ans = Math.min(ans, len(cur));
        }
        return ans;
    }
}


public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().getLengthOfOptimalCompression("aaabcccd", 2));
        System.out.println(new Solution().getLengthOfOptimalCompression("aabbaa", 2));
//        System.out.println(new Solution().getLengthOfOptimalCompression("aaaaaaaaaaa", 0));
    }
}
