package normal.cat2.cat20.cat208.p2089;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        Arrays.sort(nums);
        List<Integer> ret = new ArrayList<>();
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] == target)
                ret.add(i);
        }
        return ret;
    }
}