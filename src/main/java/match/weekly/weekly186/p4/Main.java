package match.weekly.weekly186.p4;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 5180. 带限制的子序列和
 * <p>
 * DP + 单调队列优化
 */
class Solution {
    public int constrainedSubsetSum(int[] nums, int k) {
        int ans = nums[0];
        int[] dp = new int[nums.length + 1];
        Deque<Integer> deque = new ArrayDeque<>(k);
        for (int i = 1; i <= nums.length; ++i) {
            int cur = nums[i - 1];
            dp[i] = cur;
            while (!deque.isEmpty() && i - deque.getFirst() > k) {
                deque.removeFirst();
            }
            if (!deque.isEmpty()) {
                dp[i] = Math.max(dp[i], cur + dp[deque.getFirst()]);
            }
            while (!deque.isEmpty() && dp[deque.getLast()] <= dp[i]) {
                deque.removeLast();
            }
            deque.addLast(i);
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().constrainedSubsetSum(new int[]{10, 2, -10, 5, 20}, 2));
        System.out.println(new Solution().constrainedSubsetSum(new int[]{-1, -2, -3}, 1));
        System.out.println(new Solution().constrainedSubsetSum(new int[]{10, -2, -10, -5, 20}, 2));
    }
}
