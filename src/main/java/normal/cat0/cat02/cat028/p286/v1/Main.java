package normal.cat0.cat02.cat028.p286.v1;

import static utils.java.ArrayInputUtils.parseIntArr1;

class Solution {
    public int findDuplicate(int[] nums) {
        for (int i = 0; i < nums.length; ++i) {
            for (int j = i + 1; j < nums.length; ++j) {
                if (nums[i] == nums[j]) {
                    return nums[i];
                }
            }
        }
        return -1;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().findDuplicate(parseIntArr1("[1,3,4,2,2]")));
        System.out.println(new Solution().findDuplicate(parseIntArr1("[3,1,3,4,2]")));
    }
}
