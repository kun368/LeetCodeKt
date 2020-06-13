package match.biweekly.biweekly28.p3;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {

    private static final int MAX = Integer.MAX_VALUE / 2;

    public int minSumOfLengths(int[] arr, int target) {
        Map<Integer, Integer> mp = new HashMap<>();
        mp.put(0, -1);
        int psum = 0;
        int[] edLen = new int[arr.length];
        int[] stLen = new int[arr.length + 1];
        Arrays.fill(stLen, MAX);
        for (int i = 0; i < arr.length; ++i) {
            psum += arr[i];
            Integer find = mp.get(psum - target);
            if (find != null) {
                edLen[i] = i - find;
                stLen[find + 1] = i - find;
            } else {
                edLen[i] = MAX;
            }
            mp.put(psum, i);
        }
        for (int i = arr.length - 1; i >= 0; --i) {
            stLen[i] = Math.min(stLen[i + 1], stLen[i]);
        }
        int ans = MAX;
        for (int i = 0; i < edLen.length; ++i) {
            ans = Math.min(ans, edLen[i] + stLen[i + 1]);
        }
        return ans >= MAX ? -1 : ans;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().minSumOfLengths(new int[]{3, 2, 2, 4, 3}, 3));
        System.out.println(new Solution().minSumOfLengths(new int[]{7, 3, 4, 7}, 7));
        System.out.println(new Solution().minSumOfLengths(new int[]{4, 3, 2, 6, 2, 3, 4}, 6));
        System.out.println(new Solution().minSumOfLengths(new int[]{5, 5, 4, 4, 5}, 3));
        System.out.println(new Solution().minSumOfLengths(new int[]{3, 1, 1, 1, 5, 1, 2, 1}, 3));
    }
}
