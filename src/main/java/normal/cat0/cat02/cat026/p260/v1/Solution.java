package normal.cat0.cat02.cat026.p260.v1;

import java.util.Arrays;

class Solution {
    public int[] singleNumber(int[] nums) {
        int res = 0;
        for (int i : nums) {
            res ^= i;
        }
        int n = res & (~res + 1);
        int a = 0, b = 0;
        for (int i : nums) {
            if ((i & n) > 0) {
                a ^= i;
            } else {
                b ^= i;
            }
        }
        return new int[]{a, b};
    }

    public static void main(String[] args) {
        int[] ints = new Solution().singleNumber(new int[]{1, 2, 1, 3, 2, 5});
        System.out.println(Arrays.toString(ints));
    }
}