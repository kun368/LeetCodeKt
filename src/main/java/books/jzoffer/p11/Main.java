package books.jzoffer.p11;

/**
 * 剑指 Offer 11. 旋转数组的最小数字
 */
class Solution {
    public int minArray(int[] nums) {
        int L = 0, R = nums.length, ok = nums[0];
        while (L < R) {
            int mid = (L + R) / 2;
            ok = Math.min(ok, nums[mid]);
            if (nums[mid] < nums[R - 1]) {
                R = mid;
            } else if (nums[mid] > nums[R - 1]) {
                L = mid + 1;
            } else {
                R -= 1;
            }
        }
        return ok;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().minArray(new int[]{3, 4, 5, 1, 2}));
        System.out.println(new Solution().minArray(new int[]{2, 2, 2, 0, 1}));
        System.out.println(new Solution().minArray(new int[]{1, 2, 3}));
        System.out.println(new Solution().minArray(new int[]{3, 1, 3}));
        System.out.println(new Solution().minArray(new int[]{3, 1, 3, 3}));
        System.out.println(new Solution().minArray(new int[]{3, 3, 1, 3}));
        System.out.println(new Solution().minArray(new int[]{3, 3, 3, 3, 3, 3, 3, 3, 1, 3}));
    }
}
