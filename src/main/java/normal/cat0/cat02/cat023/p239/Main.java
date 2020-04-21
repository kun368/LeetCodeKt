package normal.cat0.cat02.cat023.p239;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> qu = new LinkedList<>();
        int[] ret = new int[nums.length - k + 1];
        int pos = 0;
        for (int i = 0; i < nums.length; ++i) {
            while (!qu.isEmpty() && qu.getFirst() <= i - k) {
                qu.removeFirst();
            }
            while (!qu.isEmpty() && nums[qu.getLast()] <= nums[i]) {
                qu.removeLast();
            }
            qu.addLast(i);
            if (i >= k - 1) {
                ret[pos++] = nums[qu.getFirst()];
            }
        }
        return ret;
    }
}


public class Main {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
    }
}
