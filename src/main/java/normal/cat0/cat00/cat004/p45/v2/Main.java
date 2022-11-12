package normal.cat0.cat00.cat004.p45.v2;

import utils.java.DebugUtils;

class Solution {
    public int jump(int[] nums) {
        int cnt = 0;
        int l = 0, r = 0;
        while (r < nums.length - 1) {
            int max = r;
            for (int i = l; i <= r; ++i) {
                max = Math.max(max, i + nums[i]);
            }
            cnt += 1;
            l = r + 1;
            r = max;
        }
        return cnt;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().jump(DebugUtils.parseIntArr1("[2,3,1,1,4]")));
        System.out.println(new Solution().jump(DebugUtils.parseIntArr1("[2,3,0,1,4]")));
    }
}
