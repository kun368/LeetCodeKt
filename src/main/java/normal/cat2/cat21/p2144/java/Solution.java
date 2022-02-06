package normal.cat2.cat21.p2144.java;

import java.util.Arrays;

class Solution {
    public int minimumCost(int[] cost) {
        Arrays.sort(cost);
        int sum = 0;
        for (int i = 0; i < cost.length; ++i) {
            if (i % 3 == 2) continue;
            sum += cost[cost.length - 1 - i];
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minimumCost(new int[]{1, 2, 3}));
        System.out.println(new Solution().minimumCost(new int[]{6, 5, 7, 9, 2, 2}));
        System.out.println(new Solution().minimumCost(new int[]{5, 5}));
    }
}
