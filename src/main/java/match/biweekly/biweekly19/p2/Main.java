package match.biweekly.biweekly19.p2;

import utils.java.DebugUtils;

class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int sum = 0, ans = 0;
        for (int i = 0; i < arr.length; ++i) {
            sum += arr[i];
            if (i < k - 1) {
                continue;
            }
            if (i - k >= 0) {
                sum -= arr[i - k];
            }
            if (sum >= k * threshold) {
                ans += 1;
            }
        }
        return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().numOfSubarrays(DebugUtils.parseIntArr1("[2,2,2,2,5,5,5,8]"), 3, 4));
        System.out.println(new Solution().numOfSubarrays(DebugUtils.parseIntArr1("[1,1,1,1,1]"), 1, 0));
        System.out.println(new Solution().numOfSubarrays(DebugUtils.parseIntArr1("[11,13,17,23,29,31,7,5,2,3]"), 3, 5));
        System.out.println(new Solution().numOfSubarrays(DebugUtils.parseIntArr1("[7,7,7,7,7,7,7]"), 7, 7));
        System.out.println(new Solution().numOfSubarrays(DebugUtils.parseIntArr1("[4,4,4,4]"), 4, 1));
    }
}
