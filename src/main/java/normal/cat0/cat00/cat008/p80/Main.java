package normal.cat0.cat00.cat008.p80;

import utils.java.DebugUtils;

class Solution {
    public int removeDuplicates(int[] nums) {
        int pos = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (i <= 1 || nums[i] != nums[pos - 1] || nums[i] != nums[pos - 2]) {
                nums[pos++] = nums[i];
            }
        }
        return pos;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().removeDuplicates(DebugUtils.parseIntArr1("[1,1,1,2,2,3]")));
        System.out.println(new Solution().removeDuplicates(DebugUtils.parseIntArr1("[0,0,1,1,1,1,2,3,3]")));
    }
}
