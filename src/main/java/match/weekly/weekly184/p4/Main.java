package match.weekly.weekly184.p4;

class Solution {

    public static final int MOD = 1000000007;

    public int numOfWays(int n) {
        long same = 6, diff = 6;
        for (int i = 1; i < n; ++i) {
            long newSame = same * 3 + diff * 2;
            long newDiff = same * 2 + diff * 2;
            same = newSame % MOD;
            diff = newDiff % MOD;
        }
        return (int) ((same + diff) % MOD);
    }
}

public class Main {
    public static void main(String[] args) {
        for (int i = 1; i <= 10; ++i) {
            System.out.println("n = " + i + ", ans = " + new Solution().numOfWays(i));
        }
    }
}
