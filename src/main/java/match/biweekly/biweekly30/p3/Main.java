package match.biweekly.biweekly30.p3;

import java.util.Arrays;

class Solution {
    public int minDifference(int[] nums) {
        if (nums.length <= 4) {
            return 0;
        }
        Arrays.sort(nums);
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i <= 3; ++i) {
            int ed = i + nums.length - 3 - 1;
            ans = Math.min(ans, nums[ed] - nums[i]);
        }
        return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().minDifference(new int[]{5, 3, 2, 4}));
        System.out.println(new Solution().minDifference(new int[]{1, 5, 0, 10, 14}));
        System.out.println(new Solution().minDifference(new int[]{6, 6, 0, 1, 1, 4, 6}));
        System.out.println(new Solution().minDifference(new int[]{1, 5, 6, 14, 15}));
    }
}
