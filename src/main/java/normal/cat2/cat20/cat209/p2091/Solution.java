package normal.cat2.cat20.cat209.p2091;

import java.util.Arrays;
import java.util.Collections;

class Solution {
    public int minimumDeletions(int[] nums) {
        int min = Integer.MAX_VALUE, minIdx = -1;
        int max = Integer.MIN_VALUE, maxIdx = -1;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] < min) {
                minIdx = i;
                min = nums[i];
            }
            if (nums[i] > max) {
                maxIdx = i;
                max = nums[i];
            }
        }

        int ans1 = Math.max(minIdx + 1, maxIdx + 1);
        int ans2 = Math.max(nums.length - minIdx, nums.length - maxIdx);
        int ans3 = (minIdx + 1) + (nums.length - maxIdx);
        int ans4 = (nums.length - minIdx) + (maxIdx + 1);
        return Collections.min(Arrays.asList(ans1, ans2, ans3, ans4, nums.length));
    }
}
