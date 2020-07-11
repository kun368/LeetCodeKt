package match.biweekly.biweekly30.p2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {

    public static final int MOD = 1000000007;

    public int rangeSum(int[] nums, int n, int left, int right) {
        List<Long> list = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            long sum = 0;
            for (int j = i; j < n; ++j) {
                list.add(sum += nums[j]);
            }
        }
        Collections.sort(list);
        long ans = 0;
        for (int i = left - 1; i < right; ++i) {
            ans = (ans + list.get(i)) % MOD;
        }
        return (int) ans;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().rangeSum(new int[]{1, 2, 3, 4}, 4, 1, 5));
        System.out.println(new Solution().rangeSum(new int[]{1, 2, 3, 4}, 4, 3, 4));
        System.out.println(new Solution().rangeSum(new int[]{1, 2, 3, 4}, 4, 1, 10));
    }
}
