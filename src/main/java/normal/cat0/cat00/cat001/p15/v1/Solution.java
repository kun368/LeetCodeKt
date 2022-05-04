package normal.cat0.cat00.cat001.p15.v1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
        System.out.println(solution.threeSum(new int[]{-4, -2, 1, -5, -4, -4, 4, -2, 0, 4, 0, -2, 3, 1, -5, 0}));
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ret = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; ++i) {
            int L = i + 1;
            int R = nums.length - 1;
            while (L < R) {
                int sum = nums[i] + nums[L] + nums[R];
                if (sum == 0) {
                    ret.add(Arrays.asList(nums[i], nums[L], nums[R]));
                    while (L + 1 < R && nums[L] == nums[L + 1]) ++L;
                    while (R - 1 > L && nums[R] == nums[R - 1]) --R;
                    L += 1;
                    R -= 1;
                }
                if (sum < 0) ++L;
                if (sum > 0) --R;
            }
            while (i + 1 < nums.length - 2 && nums[i] == nums[i + 1]) ++i;
        }
        return ret;
    }
}