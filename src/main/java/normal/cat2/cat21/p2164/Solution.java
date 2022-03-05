package normal.cat2.cat21.p2164;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

class Solution {
    public int[] sortEvenOdd(int[] nums) {
        LinkedList<Integer> list0 = new LinkedList<>();
        LinkedList<Integer> list1 = new LinkedList<>();
        for (int i = 0; i < nums.length; ++i) {
            if (i % 2 == 0) list0.add(nums[i]);
            if (i % 2 == 1) list1.add(nums[i]);
        }
        Collections.sort(list0);
        Collections.sort(list1);
        for (int i = 0; i < nums.length; ++i) {
            if (i % 2 == 0) nums[i] = list0.removeFirst();
            if (i % 2 == 1) nums[i] = list1.removeLast();
        }
        return nums;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().sortEvenOdd(new int[]{4, 1, 2, 3})));
        System.out.println(Arrays.toString(new Solution().sortEvenOdd(new int[]{2, 1})));
    }
}
