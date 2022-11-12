package normal.cat0.cat00.cat004.p45.v1;

import utils.java.DebugUtils;

class Solution {
    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        dp[nums.length - 1] = 0;
        for (int i = nums.length - 2; i >= 0; --i) {
            dp[i] = Integer.MAX_VALUE / 2;
            for (int j = i + 1; j < nums.length && j <= i + nums[i]; ++j) {
                dp[i] = Math.min(dp[i], dp[j] + 1);
            }
        }
        return dp[0];
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().jump(DebugUtils.parseIntArr1("[2,3,1,1,4]")));
        System.out.println(new Solution().jump(DebugUtils.parseIntArr1("[2,3,0,1,4]")));
    }
}
