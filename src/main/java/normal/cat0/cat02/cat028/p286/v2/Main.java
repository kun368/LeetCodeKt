package normal.cat0.cat02.cat028.p286.v2;

import static utils.java.DebugUtils.parseIntArr1;

class Solution {
    public int findDuplicate(int[] nums) {
        int a = 0, b = 0;
        while (true) {
            a = nums[a];
            b = nums[nums[b]];
            if (a == b) {
                a = 0;
                while (a != b) {
                    a = nums[a];
                    b = nums[b];
                }
                return a;
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().findDuplicate(parseIntArr1("[1,3,4,2,2]")));
        System.out.println(new Solution().findDuplicate(parseIntArr1("[3,1,3,4,2]")));
        System.out.println(new Solution().findDuplicate(parseIntArr1("[1,4,3,2,2]")));
        System.out.println(new Solution().findDuplicate(parseIntArr1("[2,5,9,6,9,3,8,9,7,1]")));
    }
}
