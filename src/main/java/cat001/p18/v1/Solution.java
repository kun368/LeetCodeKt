package cat001.p18.v1;

import java.util.*;

/**
 * 在3sum的基础上再套一层，相当于2sum(双指针)外面套两层循环
 */
class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0));
        System.out.println(solution.fourSum(new int[]{1, -2, -5, -4, -3, 3, 3, 5}, -11));
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        Set<List<Integer>> ret = new HashSet<>();
        for (int i = 0; i < nums.length - 3; ++i) {
            for (int j = i + 1; j < nums.length - 2; ++j) {
                if (nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) {
                    break;
                }
                int L = j + 1;
                int R = nums.length - 1;
                while (L < R) {
                    int sum = nums[i] + nums[j] + nums[L] + nums[R];
                    if (sum == target) {
                        ret.add(Arrays.asList(nums[i], nums[j], nums[L], nums[R]));
                    }
                    if (sum <= target) ++L;
                    if (sum >= target) --R;
                }
            }
        }
        return new ArrayList<>(ret);
    }
}
