package match.weekly.weekly278.p1;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int findFinalValue(int[] nums, int original) {
        final Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            if (i % original == 0) {
                set.add(i);
            }
        }
        for (int i = 0; ; ++i) {
            if (!set.contains(original * (1 << i))) {
                return original * (1 << i);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findFinalValue(new int[]{5, 3, 6, 1, 12}, 3));
        System.out.println(new Solution().findFinalValue(new int[]{2, 7, 9}, 4));
    }
}
