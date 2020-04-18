package match.weekly.weekly178.p1;

class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] ret = new int[nums.length];
        for (int i = 0; i < nums.length; ++i) {
            for (int num : nums) {
                if (num < nums[i])
                    ++ret[i];
            }
        }
        return ret;
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
