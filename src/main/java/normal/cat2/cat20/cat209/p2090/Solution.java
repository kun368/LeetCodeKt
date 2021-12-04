package normal.cat2.cat20.cat209.p2090;

class Solution {
    public int[] getAverages(int[] nums, int k) {
        long[] sums = new long[nums.length + 1];
        for (int i = 0; i < nums.length; ++i) {
            sums[i + 1] = sums[i] + nums[i];
        }

        int[] ret = new int[nums.length];
        for (int i = 0; i < nums.length; ++i) {
            int a = i - k, b = i + k;
            if (a < 0 || b >= nums.length) {
                ret[i] = -1;
            } else {
                ret[i] = (int) ((sums[b + 1] - sums[a]) / (k + k + 1));
            }
        }
        return ret;
    }
}
