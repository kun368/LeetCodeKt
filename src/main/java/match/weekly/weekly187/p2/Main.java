package match.weekly.weekly187.p2;

class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        int pre = Integer.MIN_VALUE / 2;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 1) {
                continue;
            }
            if (i - pre <= k) {
                return false;
            }
            pre = i;
        }
        return true;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().kLengthApart(new int[]{1, 0, 0, 0, 1, 0, 0, 1}, 2));
        System.out.println(new Solution().kLengthApart(new int[]{1, 0, 0, 1, 0, 1}, 2));
        System.out.println(new Solution().kLengthApart(new int[]{1, 1, 1, 1, 1}, 0));
        System.out.println(new Solution().kLengthApart(new int[]{0, 1, 0, 1}, 1));
    }
}
