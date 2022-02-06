package normal.cat2.cat21.p2147;

import java.util.ArrayList;
import java.util.List;

class Solution {

    public static final long MOD = 1000000007;

    public int numberOfWays(String corridor) {
        int n = corridor.length();
        long[] dp = new long[n + 1];

        List<Integer> seats = new ArrayList<>();
        for (int i = 1; i <= n; ++i) {
            if (corridor.charAt(i - 1) == 'S') {
                seats.add(i);
                if (seats.size() == 2) {
                    dp[i] = 1;
                } else if (seats.size() > 2) {
                    long pre = dp[seats.get(seats.size() - 3)] % MOD;
                    long span = seats.get(seats.size() - 2) - seats.get(seats.size() - 3) % MOD;
                    dp[i] = (pre * span) % MOD;
                }
            } else {
                if (seats.size() >= 2) dp[i] = dp[i - 1];
            }
        }
        return (int) dp[n];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().numberOfWays("SSPPSPS")); // 3
        System.out.println(new Solution().numberOfWays("PPSPSP")); // 1
        System.out.println(new Solution().numberOfWays("S")); // 0
        System.out.println(new Solution().numberOfWays("PSPSPSPS"));
        System.out.println(new Solution().numberOfWays("SPSPSPSP"));
    }
}
