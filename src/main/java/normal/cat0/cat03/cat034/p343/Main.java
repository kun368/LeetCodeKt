package normal.cat0.cat03.cat034.p343;


class Solution {

    private int[] cache;

    private int dfs(int n) {
        if (n <= 1) {
            return 1;
        }
        if (cache[n] > 0) {
            return cache[n];
        }
        int best = 0;
        for (int i = 1; i <= n - 1; ++i) {
            best = Math.max(best, i * Math.max(n - i, dfs(n - i)));
        }
        return cache[n] = best;
    }

    public int integerBreak(int n) {
        this.cache = new int[n + 1];
        return dfs(n);
    }
}


public class Main {
    public static void main(String[] args) {
        for (int i = 2; i <= 58; ++i) {
            System.out.println("i = " + i + ", ans = " + new Solution().integerBreak(i));
        }
    }
}
