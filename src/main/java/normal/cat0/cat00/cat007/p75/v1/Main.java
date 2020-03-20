package normal.cat0.cat00.cat007.p75.v1;

import java.util.Arrays;

/**
 * 颜色分类
 */
class Solution {

    private void swap(int[] nums, int x, int y) {
        int t = nums[x];
        nums[x] = nums[y];
        nums[y] = t;
    }

    public void sortColors(int[] nums) {
        int p0 = 0, p2 = nums.length - 1;
        for (int i = 0; i <= p2;) {
            if (nums[i] == 0) {
                swap(nums, p0++, i++);
            } else if (nums[i] == 2) {
                swap(nums, p2--, i);
            } else if (nums[i] == 1) {
                i += 1;
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        int[] arr = {2, 0, 2, 1, 1, 0};
        Solution solution = new Solution();
        solution.sortColors(arr);
        System.out.println(Arrays.toString(arr));
    }
}
