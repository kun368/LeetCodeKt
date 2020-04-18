package match.weekly.weekly164.p4;

class Solution {

    private final int mod = (int) (1e9 + 7);

    public int numWays(int steps, int arrLen) {
        long[] from = new long[arrLen];
        long[] to = new long[arrLen];
        from[0] = 1;
        for (int i = 1; i <= steps; ++i) {
            for (int j = 0; j < arrLen; ++j) {
                to[j] = (from[j] + (j == 0 ? 0 : from[j - 1]) + (j == arrLen - 1 ? 0 : from[j + 1])) % mod;
            }
            long[] t = from;
            from = to;
            to = t;
        }
        return (int) from[0];
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().numWays(3, 2));
        System.out.println(new Solution().numWays(2, 4));
        System.out.println(new Solution().numWays(4, 2));
        System.out.println(new Solution().numWays(500, 1000000));
    }
}
