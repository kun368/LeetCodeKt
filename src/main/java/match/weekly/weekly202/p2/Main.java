package match.weekly.weekly202.p2;

class Solution {
    public int minOperations(int n) {
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            int c = (2 * i) + 1;
            if (c < n) {
                ans += Math.abs(c - n);
            }
        }
        return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        for (int i = 1; i <= 1000; ++i) {
            System.out.println(i + ": " + new Solution().minOperations(i));
        }
    }
}
