package match.weekly.weekly177.p3;

import java.util.Arrays;

class Solution {
    public int[] closestDivisors(int num) {
        int N = (int) Math.sqrt(num) + 10;
        int ans1 = -1, ans2 = -1, best = Integer.MAX_VALUE;
        for (int i = 1; i <= N; ++i) {
            if ((num + 1) % i == 0) {
                int t = (num + 1) / i;
                int d = Math.abs(t - i);
                if (d < best) {
                    ans1 = i;
                    ans2 = t;
                    best = d;
                }
            }
            if ((num + 2) % i == 0) {
                int t = (num + 2) / i;
                int d = Math.abs(t - i);
                if (d < best) {
                    ans1 = i;
                    ans2 = t;
                    best = d;
                }
            }
        }
        return new int[]{ans1, ans2};
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().closestDivisors(8)));
        System.out.println(Arrays.toString(new Solution().closestDivisors(123)));
        System.out.println(Arrays.toString(new Solution().closestDivisors(999)));
    }
}
