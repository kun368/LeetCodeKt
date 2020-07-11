package match.biweekly.biweekly30.p4;

import java.util.HashMap;
import java.util.Map;

class Solution {

    private static final Map<Integer, Boolean> cache = new HashMap<>();

    public boolean winnerSquareGame(int n) {
        if (cache.containsKey(n)) {
            return cache.get(n);
        }
        boolean ans = false;
        int sqrt = (int) Math.sqrt(n);
        if (sqrt * sqrt == n) ans = true;
        if (!ans) {
            for (int i = sqrt + 3; i >= 1; --i) {
                int next = n - i * i;
                if (next >= 1 && !winnerSquareGame(next)) {
                    ans = true;
                    break;
                }
            }
        }
        cache.put(n, ans);
        return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        for (int i = 1; i < 1000000; ++i) {
            System.out.println(i + ", " + new Solution().winnerSquareGame(i));
        }
    }
}
