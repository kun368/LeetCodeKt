package interview.p08_03;

class Solution {
    public int findMagicIndex(int[] nums) {
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] == i) {
                return i;
            }
        }
        return -1;
    }
}
